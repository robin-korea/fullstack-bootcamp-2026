package org.doit.ik.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;
import org.doit.ik.domain.PageDTO;
import org.doit.ik.service.BoardService;
import org.doit.ik.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@AllArgsConstructor
public class EmpController {
	
	private EmpService empService;
	
	@GetMapping("/empnoCheck/{empno}")
	public String checkEmpno(@PathVariable("empno") int empno) {
		boolean isAvailable =  this.empService.isEmpnoAvailable(empno);
		
		return isAvailable ? "AVAILABLE" : "X";
	}
	

}




