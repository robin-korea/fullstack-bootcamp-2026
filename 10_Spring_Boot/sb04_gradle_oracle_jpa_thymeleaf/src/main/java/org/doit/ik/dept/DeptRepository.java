package org.doit.ik.dept;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface DeptRepository extends JpaRepository<Dept, Integer>{
	
	// 방법 1) 기본 제공 메서드
	
	// 방법 2) 쿼리 메서드
	// 예) 부서명으로 Dept 조회
	// 앞에 findBy 를 붙이고 뒤에 엔티티의 필드명을 붙인다
	// AND 를 써서 2개도 사용 가능
	List<Dept> findByDname(String dname);
	List<Dept> findByDnameAndLoc(String dname, String loc);
	List<Dept> findByDnameOrLoc(String dname, String loc);
	
	// 방법 3) @Query 어노테이션을 사용 + JPQL, Native SQL 사용
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

/*
복잡한 뭐리 사용할 경우
1) 쿼리 메서드
2) JPQL 사용
3) @Query()
4) QueryDsl 사용

키워드   의미   SQL 개념
GreaterThan   초과   >
GreaterThanEqual   이상   >=
LessThan   미만   <
LessThanEqual   이하   <=
Between   범위   BETWEEN
Equal   같음   =
Not   다름   <>

*/