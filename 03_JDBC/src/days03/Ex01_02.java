package days03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import org.doit.domain.EmpVO;

import com.util.DBConn;

public class Ex01_02 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String searchCondition, searchKeyword;
		
		System.out.print("> 검색 조건 입력(n,j,h,g,nj): ");
		searchCondition = scanner.next();
		System.out.print("> 검색어 입력: ");
		searchKeyword = scanner.next();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<EmpVO> list = null;
		
		String sql = """
				SELECT e.*
				FROM emp e
				""";

	
		String WhereClause = switch (searchCondition.toLowerCase()) {
		
		case "n" -> "WHERE REGEXP_LIKE(ename,'" + searchKeyword +"', 'i')";
		case "j" -> "WHERE REGEXP_LIKE(job,'" + searchKeyword +"', 'i')";
		case "h" -> "WHERE TO_CHAR(hiredate, 'yyyy') = " + searchKeyword;
		case "g" -> "JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal "
					+ "WHERE s.grade = " + searchKeyword;
		case "nj" -> "WHERE REGEXP_LIKE(ename,'" + searchKeyword +"', 'i')"
					+ " OR REGEXP_LIKE(job,'" + searchKeyword +"', 'i')";
		
		default -> throw new IllegalArgumentException("검색조건 입력 X");
		};
		
		sql += WhereClause;
		sql += " ORDER BY e.empno ASC";
		
		// System.out.println(sql);
		
		int empno;
		String ename;
		String job;
		LocalDateTime hiredate;
		double sal;
		int deptno;
		EmpVO vo = null;
		
		try {
			conn = DBConn.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				list = new ArrayList<EmpVO>();
				do {
					empno = rs.getInt("empno");
					ename = rs.getString("ename");
					job = rs.getString("job");
					hiredate = rs.getDate("hiredate").toLocalDate().atStartOfDay();
					sal = rs.getDouble("sal");
					deptno = rs.getInt("deptno");
					
					vo = EmpVO.builder()
							.empno(empno)
							.ename(ename)
							.job(job)
							.hiredate(hiredate)
							.sal(sal)
							.deptno(deptno)
							.build();
					
					list.add(vo);
					
				} while (rs.next());
			}
			
			dispEmpInfo(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				DBConn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("end");
	}

	private static void dispEmpInfo(ArrayList<EmpVO> list) {
		
		list.forEach(System.out::println);
		
	}
}

	


