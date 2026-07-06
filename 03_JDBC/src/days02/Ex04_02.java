package days02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import org.doit.domain.DeptVO;

import com.util.DBConn;

/**
 * @author AN
 * @date 2026. 7. 6. 오후 5:01:41
 * @subject 부서 테이블 검색
 * @content 
 * 			검색조건 ? d 부서번호    n 부서명    l 지역명    nl 부서명,지역명
 * 			검색어  ? 
 */
public class Ex04_02 {

	public static void main(String[] args) {
		
		// 1.
		Scanner scanner = new Scanner(System.in);
		String searchCondition, searchKeyword;
		
		System.out.print("> 검색조건, 검색어 입력 ? ");
		searchCondition = scanner.next(); // d, n, l, dl
		searchKeyword = scanner.next();
		
		// 2.
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<DeptVO> list = null;
		DeptVO vo = null;

		conn = DBConn.getConnection();

		String sql = """
				SELECT *
				FROM dept
				WHERE 
				""";
		
		if(searchCondition.equalsIgnoreCase("d")) {
			sql += String.format("deptno = %s",searchKeyword);
		}else if(searchCondition.equalsIgnoreCase("n")){
			sql += String.format("REGEXP_LIKE(dname, '%s', 'i')",searchKeyword);
		}else if(searchCondition.equalsIgnoreCase("l")){
			sql += String.format("REGEXP_LIKE(loc, '%s', 'i')",searchKeyword);
		}else if(searchCondition.equalsIgnoreCase("nl")){
			sql += String.format("REGEXP_LIKE(dname, '%1$s', 'i') OR REGEXP_LIKE(loc, '%1$s', 'i')",searchKeyword);
		}
		
		sql += "ORDER BY deptno ASC";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			int deptno;
			String dname, loc;

			if (rs.next()) { // 첫 번째 레코드는 존재한다.
				list = new ArrayList<DeptVO>();
				do {
					deptno = rs.getInt("deptno");
					dname = rs.getString("dname");
					loc = rs.getString("loc");
					
					vo = DeptVO.builder()
							.deptno(deptno)
							.dname(dname)
							.loc(loc)
							.build();
					
					list.add(vo);
				} while (rs.next());
			}

			while (rs.next()) {

			}

			dispDeptInfo(list);

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

	private static void dispDeptInfo(ArrayList<DeptVO> list) {

		list.forEach(System.out::println);
	}
}
