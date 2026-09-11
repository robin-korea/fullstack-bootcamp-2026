package org.doit.ik.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;
import org.doit.ik.domain.PageDTO;
import org.doit.ik.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/board/")
public class BoardController {
	
	// spring 4.3 이상에서 자동 주입
	private  BoardService boardService;
	
	/*
	 * // [1] /board/list + GET 게시글 목록 요청
	 * 
	 * @GetMapping(value = "list") public void list(Model model) {
	 * log.info("🤣 BoardController.list()... GET"); model.addAttribute("list",
	 * this.boardService.getList()); }	
	 */
	
	// [1-2] 페이징 처리 O
	// http://localhost/board/list
	// http://localhost/board/list?pageNum=3&amount=10
	@GetMapping(value = "list") 
	public void list(Model model, Criteria criteria) {
		log.info("🤣 BoardController.list()... GET");
		model.addAttribute("list", this.boardService.getListWithPaging(criteria)); 
		// list.jsp 포워딩 : 페이징 블럭   1 2 [3] 4 5 6  6 7 8 9 10 >
		
		int total = this.boardService.getTotal(criteria);
		
		model.addAttribute("pageMaker", new PageDTO(criteria, total));
	}
	
	// [2] /board/register + GET  게시글 쓰기 페이지 요청
	@GetMapping(value = "register")
	public void register(Model model) {  
		log.info("🤣 BoardController.register()... GET");	
	}
	
	// [2-2] /board/register + POST  게시글 쓰기 요청 -> 글 목록 리다이렉트
	@PostMapping(value = "register")
	public String register(Model model, BoardVO boardVO, RedirectAttributes rttr) {  // 커맨드 객체
		log.info("🤣 BoardController.register()... POST : " + boardVO );	
		
		this.boardService.register(boardVO);
		
		// rttr.addAttribute("result", boardVO.getBno() );   list.jsp?result=2
		rttr.addFlashAttribute("result", boardVO.getBno() );
		
		// 리다이렉트
		return "redirect:/board/list";
		// return "redirect:/board/list?result=success";  파라미터
	}
	
	
	 // /board/get?bno=4  + GET 글 상세 보기.
	// /board/modify?bno=4  + GET 글 수정.
	@GetMapping(value = {"get","modify"})
	public void get(Model model, @RequestParam("bno") Long bno, @ModelAttribute("criteria") Criteria criteria) {  
		log.info("🤣 BoardController.get()&modify()... GET/ bno: " + bno );
		
		BoardVO boardVO = this.boardService.get(bno);
		
		model.addAttribute("boardVO", boardVO);
		// return "/board/get" -> get.jsp
	}
	
	// /board/remove?bno=4&...  + GET 글 상세 보기.
	@GetMapping(value = "remove")
	public String remove(Model model, @RequestParam("bno") Long bno
			,  RedirectAttributes rttr) {  
		log.info("🤣 BoardController.remove()... GET/ bno: " + bno );	
		if(  this.boardService.remove(bno) ) {
			rttr.addFlashAttribute("result", "REMOVE_SUCCESS");  // 1회성 (임시) 
			rttr.addAttribute("bno", bno);   // ?bno=6
		} // 		
		return "redirect:/board/list";
	}
	
	// /board/modify + Post 수정 요청 컨트롤러 메서드 선언
	@PostMapping(value = "modify")
	public String modify(BoardVO boardVO, RedirectAttributes rttr, Criteria criteria) { // 커멘드 객체
		log.info("🤣 BoardController.modify()... POST");
			if(this.boardService.modify(boardVO)) {
				rttr.addFlashAttribute("result", "SUCCESS");
			}
			rttr.addAttribute("pageNum", criteria.getPageNum());
			rttr.addAttribute("amount", criteria.getAmount());
			rttr.addAttribute("type", criteria.getType());
			rttr.addAttribute("keyword", criteria.getKeyword());
			rttr.addAttribute("bno",boardVO.getBno());
			return "redirect:/board/get";
	}

}




