package org.doit.ik;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.doit.ik.domain.scott.DeptDTO;
import org.doit.ik.domain.scott.EmpDTO;
import org.doit.ik.mapper.scott.DeptMapper;
import org.doit.ik.mapper.scott.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;


@Controller
@Log4j
public class ScottController {
	
	// private static final Logger logger = LoggerFactory.getLogger(TimeMybatisController.class);
	
	@Autowired
	private DeptMapper deptMapper;
	
	@Autowired
	private EmpMapper empMapper;
	
	@GetMapping(value = "/scott/dept")
	public String dept(HttpServletRequest request) {
		
		log.info("😁😁😁 ScottController.dept()...");
		
		ArrayList<DeptDTO> list = deptMapper.selectDept();
		request.setAttribute("list",list);
		
		return "/scott/dept";
	}
	
	// deptno=10&deptno=30	
	@PostMapping(value = "/scott/emp")
	public String emp(Model model, @RequestParam("deptno") int [] dpetnoArr) {
		
		log.info("😁😁😁 ScottController.emp()...");
		
		ArrayList<EmpDTO> list = empMapper.selectEmp(dpetnoArr);
		model.addAttribute("list",list);
		
		return "/scott/emp";
	}
	
	/*
	 * @GetMapping(value = "/scott/empdept") public String deptEmp(Model
	 * model, @RequestParam(value = "deptno", required = false) int[] deptnoArr) {
	 * 
	 * log.info("😁😁😁 ScottController.deptEmp()...");
	 * 
	 * if (deptnoArr == null || deptnoArr.length == 0) { ArrayList<DeptDTO> deptList
	 * = deptMapper.selectDept();
	 * 
	 * model.addAttribute("deptList", deptList);
	 * 
	 * return "/scott/empdept"; }
	 * 
	 * else { ArrayList<EmpDTO> empList = empMapper.selectEmp(deptnoArr);
	 * model.addAttribute("empList", empList);
	 * 
	 * ArrayList<DeptDTO> deptList = deptMapper.selectDept();
	 * model.addAttribute("deptList", deptList);
	 * 
	 * return "/scott/empdept_search"; } }
	 */
	
	@GetMapping(value = "/scott/empdept")
	public String empDept(Model model, @RequestParam(value = "deptno", defaultValue = "10") int deptno) {
		
		log.info("😁😁😁 ScottController.emp()...");

		ArrayList<DeptDTO> dlist = deptMapper.selectDept();
		model.addAttribute("dlist", dlist);
		
		
		ArrayList<EmpDTO> elist = empMapper.selectEmpDept(deptno);
		model.addAttribute("elist",elist);
		
		return "/scott/empdept";
	}
	
	/*
	 * @GetMapping(value = "/scott/empdept") public String empDept(Model
	 * model, @RequestParam(value = "deptno", required = false) Integer deptno) {
	 * 
	 * log.info("😁😁😁 ScottController.emp()...");
	 * 
	 * if ( deptno == null ) { deptno = 10; }
	 * 
	 * ArrayList<DeptDTO> dlist = deptMapper.selectDept();
	 * model.addAttribute("dlist", dlist);
	 * 
	 * 
	 * ArrayList<EmpDTO> elist = empMapper.selectEmpDept(deptno);
	 * model.addAttribute("elist",elist);
	 * 
	 * return "/scott/empdept"; }
	 */
	
}
