package org.doit.ik.memo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/memo")
public class MemoController {
	
	private final MemoRepository memoRepository;
	
	@GetMapping("/list/{pageNumber}")
	public String memoList(@PathVariable("pageNumber") int pageNumber
							, Model model
							) {
		
		int pageSize = 10;
		
		Sort sort = Sort.by("mno").descending();
		Pageable pageable = PageRequest.of(pageNumber-1, pageSize, sort);
		Page<Memo> mPage = this.memoRepository.findAll(pageable);
		
		List<Memo> mList = mPage.getContent();
		model.addAttribute("mList", mList);
		
		int pageBlock = 10;
		int currentBlock = (pageNumber-1)/pageBlock;
		int startPage = currentBlock * pageBlock + 1;
		
		int endPage = startPage + pageBlock - 1;
		if(endPage > mPage.getTotalPages()) endPage = mPage.getTotalPages();
		
		long totalPages = mPage.getTotalPages();
		
		boolean hasPreviousBlock = startPage > 1;
		boolean hasNextBlock = endPage < totalPages;
		
		model.addAttribute("mPage", mPage);
		model.addAttribute("currentPage", pageNumber);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("hasPreviousBlock", hasPreviousBlock);
		model.addAttribute("hasNextBlock", hasNextBlock);
		
		return "/memo/list";
	}
}
