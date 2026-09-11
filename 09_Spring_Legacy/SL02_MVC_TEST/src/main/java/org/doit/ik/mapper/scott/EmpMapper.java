package org.doit.ik.mapper.scott;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.doit.ik.domain.scott.EmpDTO;

public interface EmpMapper {
	
	// [1] 모든 사원 조회
	ArrayList<EmpDTO> selectEmp();
	
	ArrayList<EmpDTO> selectEmp(int[] dpetnoArr);
	
	ArrayList<EmpDTO> selectEmpDept(@Param("deptno") int deptno);
	
}
