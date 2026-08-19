package days02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.doit.domain.EmpVO;

import com.util.DBConn;

/**
 * @author AN
 * @date 2026. 7. 6. 오후 2:03:33
 * @subject 
 * @content 
 */
public class Ex01 {

	public static void main(String[] args) {
		
		/*
		 * 1. JDBC Driver 로딩
		 * 	Class.forName("oracle.jdbc.driver.OracleDriver");
		 * 
		 * 2. DB 연결
		 * 	 Connection conn = DriverManager.getConnection(url,user,password);
		 * 
		 * 3. 질의/응답 처리
		 * 	String sql = "SELECT * FROM dept";
		 * 	Statement stmt = conn.createStatement();
		 * 	ResultSet rs = stmt.excuteQuery();
		 * 
		 * 	while(boolean rs.next()){
		 * 		int deptno = rs.getInt("deptno");
		 * 		// 부서명
		 * 		// 지역명
		 * 
		 *		// 출력..
		 * }
		 * 
		 * 4. DB 닫기
		 *  rs.close();
		 * 	stmt.close()	
		 * 	conn.close();
		 * 
		 * 
		 * DBConn.java (싱글톤) 
		 * 	 ㄴ Connect getConnection(){}
		 * 	 ㄴ Connect getConnection(String url, String user, String password){}
		 *   ㄴ close(){}
		 *   
		 * 
		 * 1 + 2
		 * Connection conn = DBConn.getConnection();
		 * 
		 * 3. 직접 구현
		 * 
		 * 
		 * 4
		 * DBConn.close();
		 * 
		 */
		
		// 모든 사원 정보를 조회해서 ArrayList<> 저장하고 출력하는 메서드를 만들어서 출력
		// EmpVO.java
		// dispEmpInfo() 메서드 구현
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<EmpVO> list = null;
		EmpVO vo = null;
		
		conn = DBConn.getConnection();
		
		String sql = """
				SELECT *
				FROM emp
				ORDER BY empno ASC
				""";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			int empno, mgr, deptno;
			double sal, comm;
			String ename, job;
			LocalDateTime hiredate;
			
			if (rs.next()) { // 첫 번째 레코드는 존재한다.
				list = new ArrayList<EmpVO>();
				do {
					empno = rs.getInt("empno");
					ename = rs.getString("ename");
					job = rs.getString("job");
					mgr = rs.getInt("mgr");
					hiredate = rs.getDate("hiredate").toLocalDate().atStartOfDay();
					sal = rs.getDouble("sal");
					comm = rs.getDouble("comm");
					deptno = rs.getInt("deptno");
					
					// vo = new DeptVO(deptno, dname, loc);
					vo = EmpVO.builder()
							.empno(empno)
							.ename(ename)
							.job(job)
							.mgr(mgr)
							.hiredate(hiredate)
							.sal(sal)
							.comm(comm)
							.deptno(deptno)
							.build();
					// System.out.println(vo);
					
					list.add(vo);
				} while (rs.next());
			}
			
			while (rs.next()) {
				
			}
			
			dispEmpInfo(list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				// 4
				DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("end");
		

	}

	private static void dispEmpInfo(ArrayList<EmpVO> list) {
		
		list.forEach(System.out::println);
		
	}
		
}
