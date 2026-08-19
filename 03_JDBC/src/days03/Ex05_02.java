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
public class Ex05_02 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("> 중복 체크할 ID(empno)를 입력 ? ");
		int id = scanner.nextInt();
		
		Connection conn = null;
		CallableStatement cstmt = null;
		
		String sql = "{ CALL UP_IDCHECK(?) }";
		
		try {
			conn = DBConn.getConnection();
			cstmt = conn.prepareCall(sql);
			// IN ?
			cstmt.setInt(1, id);
			
			// cstmt.executeQuery();
			cstmt.execute(); // boolean 저장 프로시저 실행
			
			System.out.println("사용 가능한 ID(empno)입니다. ");
			
		} catch (SQLException e) {
			// 이미 사용중인 ID 예외 처리 코딩을 하면 된다.
			// e.printStackTrace();
			if (e.getErrorCode() == 20001) {
				System.out.println("이미 사용 중인 ID(empno)입니다. ");
			}else {
				// 그 외 예외처리 구문 추가
			}
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
    pid IN emp.empno%TYPE
)
IS
    vcheck NUMBER(1);
    ex_duplicate_id EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO vcheck
    FROM emp
    WHERE empno = pid;
    
    IF vcheck > 0 THEN
        RAISE ex_duplicate_id;
    END IF;
EXCEPTION
    WHEN ex_duplicate_id THEN
        RAISE_APPLICATION_ERROR(
            -20001,'이미 사용 중인 ID(사원번호)입니다');
WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(
            -20002,
            '예상하지 못한 오류가 발생했습니다. (' || SQLCODE || ') ' || SQLERRM
        );
END;
*/