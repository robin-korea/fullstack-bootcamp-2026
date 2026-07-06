package days01;

import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.Connection;


/**
 * @author AN
 * @date 2026. 7. 3. 오전 9:14:05
 * @subject
 * @content
 */
public class Ex02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1) JDBC 드라이버 로딩
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2) DB 연결(OPEN): DriverManager 객체 -> Connection 생성
		Connection conn =
				DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521/XEPDB1",
				"scott",
				"tiger"
				);
		
		System.out.println(conn.isClosed()); // DB 연결 O false
		System.out.println(conn); // DB 연결 O false
		
		conn.close();
		
		System.out.println("end");
		
		
		
	}

}
