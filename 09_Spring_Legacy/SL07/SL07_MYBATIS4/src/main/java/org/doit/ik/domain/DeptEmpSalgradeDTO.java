	package org.doit.ik.domain;
	
	import java.util.Date;
	
	import org.apache.ibatis.type.Alias;
	
	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Alias("DeptEmpSalgradeDTOAlias")
	public class DeptEmpSalgradeDTO {
		
		// 1:1 연관 관계 (부서)
		// DeptDTO
		private DeptDTO deptDTO;
		
		// 1:N 연관 관계
		// EmpDTO
		
		
		// Salgrade
		private EmpDTO empDTO;
		
	}
