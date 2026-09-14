package org.doit.ik.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.doit.ik.domain.Criteria;
import org.doit.ik.domain.ReplyVO;

public interface ReplyMapper {
	
	// [1] 댓글 쓰기
	int insert(ReplyVO replyVO);
	
	
	// [2] 댓글 조회
	ReplyVO read(Long rno);
	
	
	// [3] 댓글 삭제
	int delete(Long rno);
	
	
	// [4] 댓글 수정
	int update(ReplyVO replyVO);
	
	
	// [5] 댓글 목록
	// MyBatis 에서 두 개 이상의 데이터를 파라미터로 전달하는 방법
	// 1) Map 을 이용하는 방법
	// 2) @Param 어노테이션을 이용하는 방법
	//        #{cri}
	List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);
	
	// [6] 댓글 갯수
	int getCountByBno(Long bno);
}






