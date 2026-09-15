package org.doit.ik.controller;


import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.doit.ik.domain.DeptEmpSalgradeDTO;
import org.doit.ik.domain.EmpDTO;
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
		List<DeptEmpSalgradeDTO> desList =  this.deptEmpSalgradeMapper.getDept();
		
		// 2. 각 부서의 부서원들 조회
		for(DeptEmpSalgradeDTO dto : desList) {
			List<EmpDTO> empList = this.deptEmpSalgradeMapper.getEmpOfDept(dto.getDeptno());
			dto.setEmpList(empList);
		}
		
		model.addAttribute("desList", desList);
		
		
	}
	
}
