package days02;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.DBConn;

/**
 * @author AN
 * @date 2026. 7. 6. 오후 5:20:51
 * @subject 삭제할 부서번호를 입력받아서 삭제..
 * @content 
 */
public class Ex04_03 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int deptno;
		
		System.out.print("> 삭제할 부서 번호를 입력하시오");
		deptno = scanner.nextInt();
		
		Connection conn = null;
		Statement stmt = null;
		
		conn = DBConn.getConnection();
		
		String sql = String.format(
				"DELETE FROM dept WHERE deptno = %d"
				, deptno);
		
		try {
			stmt = conn.createStatement();
			
			int rowCount = stmt.executeUpdate(sql);

			if (rowCount == 1) {
			    System.out.println("삭제 완료");
			} else {
				System.out.println("해당 부서번호가 없습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("end");
		
	}

}
