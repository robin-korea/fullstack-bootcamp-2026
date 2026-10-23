package org.doit.ik.board.service;

import java.util.List;
import java.util.stream.Collectors;

import org.doit.ik.board.dto.ReplyDTO;
import org.doit.ik.board.entity.Board;
import org.doit.ik.board.entity.Reply;
import org.doit.ik.board.repository.ReplyRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	private final ReplyRepository replyRepository;
	
	@Override
	public Long register(ReplyDTO replyDTO) {
		
		Reply reply = this.dtoToEntity(replyDTO);
		this.replyRepository.save(reply);
		
		return reply.getRno();
	}

	@Override
	public List<ReplyDTO> getList(Long bno) {
		
		Board board = Board.builder()
				.bno(bno)
				.build();
		List<Reply> result = this.replyRepository.getRepliesByBoardOrderByRno(board);
		
		return result
				.stream()
				.map(reply -> entityToDTO(reply))
				.collect(Collectors.toList())
				;
	}

	@Override
	public void modify(ReplyDTO replyDTO) {
		// rno 댓글 정보를 select -> Entity
		Reply reply = this.dtoToEntity(replyDTO);
		this.replyRepository.save(reply);
		
	}

	@Override
	public void remove(Long rno) {
		this.replyRepository.deleteById(rno);
	}

}
