package org.doit.ik.board.repository;

import java.util.List;

import org.doit.ik.board.entity.Board;
import org.doit.ik.board.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface ReplyRepository extends JpaRepository<Reply, Long>{
	
	// 해당 글벙호(bno)에 해당하는 모든 댓글을 삭제하는 메서드 선언
	@Transactional
	@Modifying // Spring Data JPA 에게 i/u/d 처리되는 쿼리
	@Query("""
			DELETE FROM Reply r
			WHERE r.board.bno = :bno
			""")
	void deleteByBno(@Param("bno") Long bno);
	
	// 게시글의 댓글 목록 을 조회
	List<Reply> getRepliesByBoardOrderByRno(Board board);
}
