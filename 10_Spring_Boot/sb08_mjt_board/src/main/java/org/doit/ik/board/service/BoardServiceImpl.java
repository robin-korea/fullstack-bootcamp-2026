package org.doit.ik.board.service;

import java.util.function.Function;

import org.doit.ik.board.dto.BoardDTO;
import org.doit.ik.board.dto.PageRequestDTO;
import org.doit.ik.board.dto.PageResultDTO;
import org.doit.ik.board.entity.Board;
import org.doit.ik.board.entity.Member;
import org.doit.ik.board.repository.BoardRepository;
import org.doit.ik.board.repository.ReplyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private final BoardRepository boardRepository;
	private final ReplyRepository replyRepository;
	
	// 게시글 목록
	@Override
	public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
		log.info("BoardServiceImpl.getList()..." + pageRequestDTO);
		
		
		Page<Object []> result = this.boardRepository.getBoardWithReplyCount(pageRequestDTO.getPageable(Sort.by("bno").descending()));
		
		// Entity -> DTO 변환
		// Page<Object []> -> ResponseDTO 변환
		
		Function<Object [], BoardDTO> fn = (en -> entityToDTO( (Board)en[0], (Member)en[1], (Long)en[2] ));
		return new PageResultDTO<>(result, fn);
	}
	
	// 게시글 등록
	@Override
	public Long register(BoardDTO boardDTO) {
		log.info("BoardServiceImpl.register()..." + boardDTO);
		
		// BoardDTO -> Board 반환
		Board entity = this.dtoToEntity(boardDTO);
		this.boardRepository.save(entity);
		return entity.getBno();
	}
	
	// 게시글 상세보기
	@Override
	public BoardDTO get(Long bno) {
		log.info("BoardServiceImpl.get()..." + bno);
		// this.boardRepository.findById(bno);
		Object result = this.boardRepository.getBoardByBno(bno);
		Object [] arr = (Object[]) result;
		return entityToDTO((Board)arr[0], (Member)arr[1], (Long)arr[2]);
	}
	
	// 게시글 수정
	@Override
	public void modify(BoardDTO boardDTO) {
		
		Board entity = this.boardRepository.getReferenceById(boardDTO.getBno()); // 지연로딩 방식으로 처리
		
		if(entity != null) {
			// 제목, 내용 수정
			entity.changeTitle(boardDTO.getTitle());
			entity.changeContent(boardDTO.getContent());
			
			this.boardRepository.save(entity);
		}
	}
	
	// 게시글 삭제
	@Override
	public void removeWithReplies(Long bno) {
		
		// (주의) dept    emp 
		//        10      10번 사원들 먼저 삭제
		this.replyRepository.deleteByBno(bno);
		this.boardRepository.deleteById(bno);
		
	}

}
