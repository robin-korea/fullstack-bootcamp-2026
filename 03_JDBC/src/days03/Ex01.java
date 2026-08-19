package days03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import org.doit.domain.EmpDeptSalgradeVO2;

import com.util.DBConn;

/**
 * @author AN
 * @date 2026. 7. 7. 오전 9:01:47
 * @subject
 * @content emp 테이블에서 사원정보를 검색 조회
 *    		1) 검색조건(searchCondition): 사원명(n), 잡(j), 입사일자(h), sal 등급(g), 사원명+잡(nj)
 *    		2) 검색어(searchKeyword)
 *    		3) 출력형식
 *      	-----------------------------------------------
      		사번   이름           직업          입사일           급여    부서
      		-----------------------------------------------
      		7369 SMITH         CLERK      1980-12-17        800    20
      		7876 ADAMS         CLERK      1987-05-23        1100   20
      		7900 JAMES         CLERK      1981-12-03        950    30
      		-----------------------------------------------
 			end 
 */
public class Ex01 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String searchCondition, searchKeyword;
		
		System.out.print("> 검색조건, 검색어 입력 ? ");
		searchCondition = scanner.next();
		searchKeyword = scanner.next();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<EmpDeptSalgradeVO2> list = null;
		EmpDeptSalgradeVO2 vo = null;

		conn = DBConn.getConnection();

		String sql = """
				SELECT empno, ename, job, hiredate, sal + NVL(comm, 0) pay, d.deptno, grade
				FROM emp e LEFT JOIN dept d ON e.deptno = d.deptno
				            	JOIN salgrade s ON sal BETWEEN losal AND hisal
				WHERE
				""";
		
		if(searchCondition.equalsIgnoreCase("n")) {
			sql += String.format("REGEXP_LIKE(ename, '%s', 'i')",searchKeyword);
		}else if(searchCondition.equalsIgnoreCase("j")){
			sql += String.format("REGEXP_LIKE(job, '%s', 'i')",searchKeyword);
		}else if(searchCondition.equalsIgnoreCase("h")){
			sql += String.format("REGEXP_LIKE(TO_CHAR(hiredate,'YYYY-MM-DD'), '%s')",searchKeyword);
		}else if(searchCondition.equalsIgnoreCase("g")){
				sql += String.format("REGEXP_LIKE(grade, '%s', 'i')",searchKeyword);
		}else if(searchCondition.equalsIgnoreCase("nj")){
			sql += String.format("REGEXP_LIKE(ename, '%1$s', 'i') OR REGEXP_LIKE(job, '%1$s', 'i')",searchKeyword);
		}
		
		sql += " ORDER BY empno ASC";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			 int empno;          
			 String ename;
			 String job;
			 LocalDate hiredate;
			 double pay;             
			 int deptno;      
			 int grade;          

			if (rs.next()) {
				list = new ArrayList<EmpDeptSalgradeVO2>();
				do {
					empno = rs.getInt("empno");
					ename = rs.getString("ename");
					job = rs.getString("job");
					hiredate = rs.getDate("hiredate").toLocalDate();
					pay = rs.getDouble("pay");
					deptno = rs.getInt("deptno");
					grade = rs.getInt("grade");

					vo = EmpDeptSalgradeVO2.builder()
							.empno(empno)
							.ename(ename)
							.job(job)
							.hiredate(hiredate)
							.pay(pay)
							.deptno(deptno)
							.grade(grade)
							.build();

					list.add(vo);
				} while (rs.next());
			}

			dispEmpDeptSalgradeInfo(list);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("end");
		
	}
	
	private static void dispEmpDeptSalgradeInfo(ArrayList<EmpDeptSalgradeVO2> list) {

		list.forEach(System.out::println);

	}

}
