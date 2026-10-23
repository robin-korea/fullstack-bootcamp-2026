package org.doit.ik.board.service;

import java.util.List;

import org.doit.ik.board.dto.ReplyDTO;
import org.doit.ik.board.entity.Board;
import org.doit.ik.board.entity.Reply;

public interface ReplyService {
	
	// [1] 댓글 등록
	Long register(ReplyDTO replyDTO);
	
	// [2] 댓글 목록
	List<ReplyDTO> getList(Long rno);
	
	// [3] 댓글 수정
	void modify(ReplyDTO replyDTO);
	
	// [4] 댓글 삭제
	void remove(Long rno);
	
	// [5] dto -> Entity 변환
	default Reply dtoToEntity(ReplyDTO replyDTO) {
	      Board board = Board.builder().bno(replyDTO.getBno()).build();
	      
	      Reply reply = Reply.builder()
	            .rno(replyDTO.getRno())
	            .text(replyDTO.getText())
	            .replyer(replyDTO.getReplyer())
	            .board(board)
	            .build();
	      return reply;      
	   }
	
	// [6] Entity -> dto 변환
	default ReplyDTO entityToDTO(Reply reply) {    
	      ReplyDTO replyDTO = ReplyDTO.builder()
	            .rno(reply.getRno())
	            .text(reply.getText())
	            .replyer(reply.getReplyer())
	            .regDate(reply.getRegDate())
	            .modDate(reply.getModDate())
	            .build();
	      return replyDTO;
	   }
}
