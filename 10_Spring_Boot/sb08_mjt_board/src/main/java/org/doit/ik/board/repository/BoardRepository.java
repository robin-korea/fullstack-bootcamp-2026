package org.doit.ik.board.repository;


import java.util.List;

import org.doit.ik.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
	// [1] JPQL 쿼리, LEFT JOIN 사용
	// Board 게시글 정보를 조회할 때 Writer 작성자 정보도 조인해서 같이 SELECT
	@Query("""
			SELECT b , w
			FROM Board b LEFT JOIN b.writer w
			WHERE b.bno = :bno
			""")
	Object getBoardWithWriter(@Param("bno") Long bno);
	
	// [2] 게시글 + 댓글정보도 조회
	// Board 와 Reply 엔티티의 연관관계에 따라서 JPQL 달라질 수 있다.
	// Board <- Reply 단반향 @ManyToOne
	@Query("""
			SELECT b , r
			FROM Board b LEFT JOIN Reply r ON r.board = b
			WHERE b.bno = :bno
			""")
	List<Object[]> getBoardWithReply(@Param("bno") Long bno);
	
	// [3] 게시글 목록 조회: 게시판 + 회원 + 댓글 조인
	// countQuery: 페이징(Pageable)을 사용할 때 전체 데이터 갯수를 카운팅하기 위해 별도로 실행되는 쿼리
	@Query( value = """
			SELECT b , w, COUNT(r)
			FROM Board b LEFT JOIN b.writer w
						 LEFT JOIN Reply r ON r.board = b
			GROUP BY b
			"""
			, countQuery = "SELECT COUNT(b) FROM Board b" )
	Page<Object[]> getBoardWithReplyCount(Pageable pageable);
	
	
	// [4] 조회 
	@Query("""
			SELECT b, w, COUNT(r)
			FROM Board b LEFT JOIN b.writer w
						 LEFT JOIN Reply r ON r.board = b
			WHERE b.bno = :bno 
			""")
	Object getBoardByBno(@Param("bno") Long bno);
	
}
