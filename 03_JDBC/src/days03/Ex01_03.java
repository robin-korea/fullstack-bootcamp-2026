package days03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import org.doit.domain.EmpVO;

import com.util.DBConn;

/**
 * @author AN
 * @date 2026. 7. 7. 오전 10:18:07
 * @subject Statement X 
 * @content PreparedStatement O
 */
public class Ex01_03 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String searchCondition, searchKeyword;
		
		System.out.print("> 검색 조건 입력(n,j,h,g,nj): ");
		searchCondition = scanner.next();
		System.out.print("> 검색어 입력: ");
		searchKeyword = scanner.next();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<EmpVO> list = null;
		
		String sql = """
				SELECT e.*
				FROM emp e
				""";

	
		String WhereClause = switch (searchCondition.toLowerCase()) {
		
		case "n" -> "WHERE REGEXP_LIKE(ename, ?, 'i')";
		case "j" -> "WHERE REGEXP_LIKE(job, ?, 'i')";
		case "h" -> "WHERE TO_CHAR(hiredate, 'yyyy') = ?";
		case "g" -> "JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal "
					+ "WHERE s.grade = ?";
		case "nj" -> "WHERE REGEXP_LIKE(ename, ?, 'i')"
					+ " OR REGEXP_LIKE(job, ?, 'i')";
		
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
			pstmt = conn.prepareStatement(sql);
			// ? IN
			pstmt.setString(1, searchKeyword);
			
			if(searchCondition.equalsIgnoreCase("nj")) {
				pstmt.setString(2, searchKeyword);
			}
			
			rs = pstmt.executeQuery();
			
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
				pstmt.close();
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
