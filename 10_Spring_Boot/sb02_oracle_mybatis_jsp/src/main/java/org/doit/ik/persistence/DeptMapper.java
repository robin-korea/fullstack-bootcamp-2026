package org.doit.ik.persistence;

import java.util.List;

import org.doit.ik.domain.DeptVO;

public interface DeptMapper {
	
	List<DeptVO> getDeptList() throws Exception;
	
}
