package org.doit.ik.dept;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@Log4j2
@RequestMapping("/dept")
@RequiredArgsConstructor
public class DeptController {
	
	private final DeptService deptService;
	
	/*
	@GetMapping("/list")
	public void deptList(Model model) {
		log.info("DeptController.deptList().....");
		int pageNumber = 1;
		int pageSize = 10;
		Page<Dept> dPage = this.deptService.getDeptsByPage(pageNumber, pageSize);
		
		List<Dept> dList = dPage.getContent();
		
		long totalElements = dPage.getTotalElements();
		long totalPages = dPage.getTotalPages();
		boolean next = dPage.hasNext();
		boolean prev = dPage.hasPrevious();
		
		model.addAttribute("dList", dList);
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("next", next);
		model.addAttribute("prev", prev);
	}
	*/
	
	@GetMapping("/list")
	public void deptList(Model model
				, @RequestParam(name = "page", defaultValue = "1") int pageNumber
				, @RequestParam(name = "amount", defaultValue = "2") int pageSize) {
		log.info("DeptController.deptList().....");
		
		Page<Dept> dPage = this.deptService.getDeptsByPage(pageNumber, pageSize);
		
		List<Dept> dList = dPage.getContent();
		
		long totalElements = dPage.getTotalElements();
		long totalPages = dPage.getTotalPages();
		boolean next = dPage.hasNext();
		boolean prev = dPage.hasPrevious();
		
		
		model.addAttribute("dList", dList);
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("next", next);
		model.addAttribute("prev", prev);
		
		// [1] 2 3 4 5 6 7 8 9 10 >> 페이징 블럭
		int pageBlock = 2;
		model.addAttribute("currentPage", pageNumber);
		
		// 현재 페이지가 속한 페이지 그룹: startPage, endPage 계산..
		int currentBlock = (pageNumber-1)/pageBlock;
		int startPage = currentBlock * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;
		if(endPage > dPage.getTotalPages()) endPage = dPage.getTotalPages();
		
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		// 이전, 다음
		boolean hasPreviousBlock = startPage > 1;
		boolean hasNextBlock = endPage < totalPages;
		model.addAttribute("hasPreviousBlock", hasPreviousBlock);
		model.addAttribute("hasNextBlock", hasNextBlock);
		
	}
	
	@GetMapping("/insert")
	public String deptInsert(Dept dept, RedirectAttributes rttr) {
		
		log.info("DeptController.deptInsert().....");
		Dept saveDept = this.deptService.saveDept(dept);
		int deptno = saveDept.getDeptno();
		rttr.addFlashAttribute("deptno", deptno);
		
		return "redirect:/dept/list";
	}
	
	@GetMapping("/update")
	public String deptUpdate(Dept dept, RedirectAttributes rttr) {
		
		log.info("DeptController.deptUpdate().....");
		Dept updateDept = this.deptService.updateDept(dept);
		int deptno = updateDept.getDeptno();
		rttr.addFlashAttribute("deptno", deptno);
		
		return "redirect:/dept/list";
	}
	
	@GetMapping("/delete")
	public String deptDelete(@RequestParam("deptno") Integer deptno, RedirectAttributes rttr) {
		
		log.info("DeptController.deptDelete().....");
		this.deptService.deleteDept(deptno);
		rttr.addFlashAttribute("deptno", deptno);
		return "redirect:/dept/list";
	}
	
}
