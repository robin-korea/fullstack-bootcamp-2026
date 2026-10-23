package org.doit.ik.board.repository.search;
import java.util.List;
import java.util.stream.Collectors;

import org.doit.ik.board.entity.Board;
import org.doit.ik.board.entity.QBoard;
import org.doit.ik.board.entity.QMember;
import org.doit.ik.board.entity.QReply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SearchBoardRepositoryImpl extends QuerydslRepositorySupport implements SearchBoardRepository{

	public SearchBoardRepositoryImpl() {
		super(Board.class);
		
	}

	// Board, Reply, Member 여러 엔티티를
	// 1) 조인 2) 검색 3) 페이징 처리
	@Override
	public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {
		
		log.info("SearchBoardRepositoryImpl.searchPage()...");
		
		// 1. Querydsl 에서 Q클래스 객체 먼저 생성
		QBoard board = QBoard.board;
		QReply reply = QReply.reply;
		QMember member = QMember.member;
		
		// 2. JPQLQuery를 이용해서 쿼리 작성
		// FROM 절 부터 시작 : from()
		JPQLQuery<Board> jpqlQuery = from(board);
		
		// SQL: LEFT JOIN member m ON b.writer = m.writer
		// JPQL: 조인 코딩 
		jpqlQuery.leftJoin(member).on(board.writer.eq(member));
		jpqlQuery.leftJoin(reply).on(reply.board.eq(board));
		
		// Tuple: select board, member, reply 다양한 타입의 값을 한 행에 담기 위해서 사용되는 Querydsl의 결과 타입
		JPQLQuery<Tuple> tuple = jpqlQuery.select(board, member, reply.count());
		
		// 검색 조건 추가
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		// WHERE bno > 0
		BooleanExpression booleanExpression = board.bno.gt(0L);
		booleanBuilder.and(booleanExpression);
		
		if ( type != null) {
	         String [] typeArr = type.split("");
	         BooleanBuilder conditionBuilder = new BooleanBuilder();
	         for (String t : typeArr) {
	            switch (t) {
	            case "t":  
	               conditionBuilder.or(board.title.contains(keyword));
	               break; 
	            case "c":  
	               conditionBuilder.or(board.content.contains(keyword));
	               break; 
	            case "w":  
	               conditionBuilder.or(member.email.contains(keyword));
	               break;
	            } // switch
	         } // for
	         booleanBuilder.and(conditionBuilder);
	      } // if
		
		tuple.where(booleanBuilder);
		tuple.groupBy(board);
		
		// 페이징 처리 추가
		this.getQuerydsl().applyPagination(pageable, tuple);
		
		// 쿼리를 실행해서 결과... fetch()
		List<Tuple> result = tuple.fetch();
		log.info(result);
		
		// fetchCount(): 쿼리를 실행 한 후 총 레코드 수를 반환하는 메서드
		long count = tuple.fetchCount();
		log.info("COUNT: " + count);
		
		// List<Tuple> -> Page<Object[]> 변환
		
		// List<Tuple>       result;
		// Stream<Tuple>     result.stream()
		// Stream<Object[]>  result.stream.map(Tuple::toArray)
		// List<Object[]>    result.stream.map(Tuple::toArray).collect<Object[]>
		
		// PageImpl 클래스
		
		return new PageImpl<Object[]>(
	            result.stream().map(Tuple::toArray).collect(Collectors.toList())  // List<T> content
	            , pageable
	            , count
	            );
	}

}
