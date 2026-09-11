package org.doit.ik;
import org.doit.ik.domain.scott.DeptDTO;
import org.doit.ik.mapper.scott.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
// @RequiredArgsConstructor
public class ScottRestController {
	
	// @Autowired
	@Setter(onMethod=@__({@Autowired}))
	private DeptMapper deptMapper;
	
	// http://localhost/scott/dept/new + POST 부서 추가
	@PostMapping(value = "/scott/dept/new")
	public ResponseEntity<String> insertDept(@RequestBody DeptDTO dto){
		
		log.info("😁😁😁 ScottController.dept()...");
		
		int rowCount =  this.deptMapper.insertDept(dto);
		return rowCount == 1 
				? new ResponseEntity<String>("SUCCESS", HttpStatus.OK)
				: new ResponseEntity<String>("SUCCESS", HttpStatus.INTERNAL_SERVER_ERROR);							
	}
	
	
	// http://localhost/scott/dept/50 + DELETE 부서 삭제
	@DeleteMapping(value = "/scott/dept/{deptno}")
	public ResponseEntity<String> deleteDept(@PathVariable("deptno") int deptno){
		
		log.info("😁😁😁 ScottController.deleteDept()..." + deptno);
		
		int rowCount =  this.deptMapper.deleteDept(deptno);
		return rowCount == 1 
				? new ResponseEntity<String>("SUCCESS", HttpStatus.OK)
						: new ResponseEntity<String>("SUCCESS", HttpStatus.INTERNAL_SERVER_ERROR);							
	}
	
}
