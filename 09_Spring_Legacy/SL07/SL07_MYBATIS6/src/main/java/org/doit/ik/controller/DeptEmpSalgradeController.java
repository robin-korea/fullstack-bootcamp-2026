package org.doit.ik.controller;


import java.util.List;
import java.util.Locale;

import org.doit.ik.domain.DeptDTO;
import org.doit.ik.mapper.DeptEmpSalgradeMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class DeptEmpSalgradeController {
	
	private DeptEmpSalgradeMapper deptEmpSalgradeMapper;
	
	@RequestMapping(value = "/dept/emp", method = RequestMethod.GET)
	public void getDeptEmpSalgrade(Locale locale, Model model) {
		log.info("🤣🤣🤣 DeptEmpSalgradeController.getDeptEmpSalgrade()...");
		
		// 1. 모든 부서 정보 조회
		// empList 는 <collection> 에 의해 자동으로 채워진다
		List<DeptDTO> desList =  this.deptEmpSalgradeMapper.getDept();
		
		model.addAttribute("desList", desList);
		
		
	}
	
}
