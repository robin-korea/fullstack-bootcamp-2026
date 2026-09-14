package org.doit.ik.service;

import org.doit.ik.mapper.EmpMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {

	private final EmpMapper empMapper;
	
	// null 이라면 empno는 사용가능 하기에 true 를 반환.
	@Override
	public boolean isEmpnoAvailable(int empno) {
		
		return this.empMapper.checkEmpno(empno) == null;
	}

}
