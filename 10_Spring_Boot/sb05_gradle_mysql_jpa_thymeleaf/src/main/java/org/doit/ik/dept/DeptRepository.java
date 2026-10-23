package org.doit.ik.dept;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface DeptRepository extends JpaRepository<Dept, Integer>{
	

	List<Dept> findByDname(String dname);
	List<Dept> findByDnameAndLoc(String dname, String loc);
	List<Dept> findByDnameOrLoc(String dname, String loc);
	
	@Query("SELECT d FROM Dept d")
	List<Dept> getAllDepts();
	
	@Query(
		    value = "SELECT * FROM DEPT WHERE DNAME = :dname",
		    nativeQuery = true
		)
	List<Dept> findByDepts2(@Param("dname") String dname);
	
	@Modifying
	@Transactional
	@Query("UPDATE Dept d SET d.dname = :dname, d.loc = :loc WHERE d.deptno = :deptno")
	int updateDept(
	        @Param("deptno") Integer deptno,
	        @Param("dname") String dname,
	        @Param("loc") String loc);
}

