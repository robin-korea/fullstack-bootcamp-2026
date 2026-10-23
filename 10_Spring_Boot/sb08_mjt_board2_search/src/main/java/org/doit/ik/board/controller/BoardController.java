package org.doit.ik.board.controller;

import org.doit.ik.board.dto.BoardDTO;
import org.doit.ik.board.dto.PageRequestDTO;
import org.doit.ik.board.dto.PageResultDTO;
import org.doit.ik.board.service.BoardService;
import org.doit.ik.board.service.BoardServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/board")
public class BoardController {

	private final BoardService boardService;
	
	// [1] 게시글 목록
	// http://localhost/board/list?page=1&size=10&type=t&keyword=검색어
	@GetMapping("/list")
	public void list(PageRequestDTO pageRequestDTO, Model model) {
		
		PageResultDTO<BoardDTO, Object[]> result = this.boardService.getList(pageRequestDTO);
		model.addAttribute("result", result);
	}
	
	
	// [2] 게시글 등록
	@GetMapping("/register")
	public void register() {
		
	}
	
	// [2-2] 게시글 등록
	@PostMapping("/register")
	public String register( BoardDTO boardDTO, RedirectAttributes rttr ) {
		
		Long bno = this.boardService.register(boardDTO);
		rttr.addFlashAttribute("msg", bno);
		return "redirect:/board/list";
	}
	
	// [3] 게시글 상세보기
	@GetMapping( value = {"/read", "/modify"})
	public void readAndmodify(@RequestParam("bno") Long bno, Model model, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO) {
		
		BoardDTO boardDTO = this.boardService.get(bno);
		model.addAttribute("dto", boardDTO);
	}
	
	// [4] 게시글 수정
	@PostMapping("/modify")
	public String modify(BoardDTO boardDTO, RedirectAttributes rttr, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO ) {
		
		this.boardService.modify(boardDTO);
		
		rttr.addAttribute("page",pageRequestDTO.getPage());
		rttr.addAttribute("type",pageRequestDTO.getType());
		rttr.addAttribute("keyword",pageRequestDTO.getKeyword());
		rttr.addAttribute("bno",boardDTO.getBno());
		
		rttr.addFlashAttribute("bno",boardDTO.getBno());
		
		return "redirect:/board/read";
	}
	
	// [5] 게시글 삭제
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		
		this.boardService.removeWithReplies(bno);
		rttr.addFlashAttribute("msg", bno);
		return "redirect:/board/list";
	}
	
	
}
