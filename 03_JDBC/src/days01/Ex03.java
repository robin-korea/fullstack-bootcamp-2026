package days01;

import java.sql.Connection;

import com.util.DBConn;

/**
 * @author AN
 * @date 2026. 7. 3. 오전 10:09:31
 * @subject DBConn.java
 * @content
 */
public class Ex03 {

	public static void main(String[] args) {
		// 조지훈 DB서버/scott
		String url = "jdbc:oracle:thin:@192.168.10.166:1521/XEPDB1";
		String user = "scott";
		String password = "tiger";
		
		Connection conn = DBConn.getConnection();
		System.out.println(conn);
		
//		conn = DBConn.getConnection();
//		System.out.println(conn);
//		
//		conn = DBConn.getConnection();
//		System.out.println(conn);
		
		DBConn.close();
		System.out.println("end");

	}

}
