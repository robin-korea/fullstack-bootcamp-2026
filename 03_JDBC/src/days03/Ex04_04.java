package days03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConn;

/**
 * @author AN
 * @date 2026. 7. 7. 오전 11:30:43
 * @subject 부서 정보 수정
 * @content 부서명만 수정
 * 			지역명만 수정
 * 			부서명 + 지역명 수정
 */
public class Ex04_04 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int udeptno;
		String udname, uloc;

		System.out.print("> 수정할 부서번호 입력 ? "); // 필수 입력
		udeptno = Integer.parseInt(scanner.nextLine());

		System.out.print("> 수정할 부서명 입력 ? "); // 입력하지 않고 엔터 -> 수정 X
		udname = scanner.nextLine();

		System.out.print("> 수정할 지역명 입력 ? ");
		uloc = scanner.nextLine();

		String sql = "UPDATE dept ";

		if (udname.isEmpty() && !uloc.isEmpty()) {
			sql += "SET loc = ? ";
		}else if (!udname.isEmpty() && uloc.isEmpty()){
			sql += "SET dname = ? ";
		}else if (!udname.isEmpty() && !uloc.isEmpty()){
			sql += "SET dname = ?, loc = ? ";
		}
		sql	+= "WHERE deptno = ?";
		
		// System.out.println(sql);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int rowCount = 0;
		
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (udname.isEmpty() && !uloc.isEmpty()) {
				pstmt.setString(1, uloc);
				pstmt.setInt(2, udeptno);
			}else if (!udname.isEmpty() && uloc.isEmpty()){
				pstmt.setString(1, udname);
				pstmt.setInt(2, udeptno);
			}else if (!udname.isEmpty() && !uloc.isEmpty()){
				pstmt.setString(1, udname);
				pstmt.setString(2, uloc);
				pstmt.setInt(3, udeptno);
			}
			rowCount = pstmt.executeUpdate();
			if(rowCount == 1) {
				System.out.println("부서 수정 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	

	}

}
