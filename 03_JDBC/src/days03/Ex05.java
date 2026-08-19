package days03;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.util.DBConn;

/**
 * @author AN
 * @date 2026. 7. 7. 오후 2:36:01
 * @subject Statement
 * @content PreparedStatemnet
 * 			CallabledStatement        저장 프로시저, 저장 함수 (쓰지 않는다)
 */
public class Ex05 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("> 중복 체크할 ID(empno)를 입력 ? ");
		int id = scanner.nextInt();
		
		Connection conn = null;
		CallableStatement cstmt = null;
		
		String sql = "{ CALL UP_IDCHECK(pid=>?,pcheck=>?) }";
		
		try {
			conn = DBConn.getConnection();
			cstmt = conn.prepareCall(sql);
			// IN ?
			cstmt.setInt(1, id);
			// OUT ?
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.executeQuery();
			
			int check = cstmt.getInt(2); // 실행 후에 출력용 파라미터 값을 얻어와서 변수에 저장
			
			if (check == 1) {
				System.out.println("이미 사용 중인 ID(empno)입니다. ");
			} else {
				System.out.println("사용 가능한 ID(empno)입니다. ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cstmt.close();
				DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}

/*
CREATE OR REPLACE PROCEDURE up_idcheck
(
    pid IN emp.empno%TYPE,
    pcheck OUT NUMBER      -- 0 사용가능, 1 사용 중
)
IS
BEGIN
    SELECT COUNT(*) INTO pcheck
    FROM emp
    WHERE empno = pid;
-- EXCEPTION
END;


DECLARE
    vcheck NUMBER(1);
BEGIN
    up_idcheck(9999,vcheck);
    DBMS_OUTPUT.PUT_LINE(vcheck);
END;
*/