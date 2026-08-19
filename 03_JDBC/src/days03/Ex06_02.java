package days03;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.util.DBConn;

/**
 * @author AN
 * @date 2026. 7. 7. 오후 3:26:26
 * @subject
 * @content
 */
public class Ex06_02 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("> 로그인 체크할 ID(empno), PWD(ename)를 입력 ? ");
		int id = scanner.nextInt();
		String pwd = scanner.next();
		
		
		Connection conn = null;
		CallableStatement cstmt = null;

		String sql = "{ CALL UP_LOGIN(?,?) }";

		try {
			conn = DBConn.getConnection();
			cstmt = conn.prepareCall(sql);
			// IN ?
			cstmt.setInt(1, id);
			cstmt.setString(2, pwd);
				
			cstmt.execute();

			System.out.println("로그인 성공 !!");
			

		} catch (SQLException e) {
			if (e.getErrorCode() == 20001) {
				System.out.println("아이디가 존재하지 않습니다.");
			}else if (e.getErrorCode() == 20002) {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}else {
				// 그 외 예외처리 구문 추가
				e.printStackTrace();
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
CREATE OR REPLACE PROCEDURE up_login
(
    pid    IN  emp.empno%TYPE,
    ppwd   IN  emp.ename%TYPE
)
IS
    vcnt NUMBER;
    
    ex_invalid_id EXCEPTION;
    ex_invalid_pwd EXCEPTION;
BEGIN
    -- 1. 아이디 존재 여부 확인
    SELECT COUNT(*)
    INTO vcnt
    FROM emp
    WHERE empno = pid;

    IF vcnt = 0 THEN
        RAISE ex_invalid_id;
    ELSE
        -- 2. 비밀번호 확인
        SELECT COUNT(*)
        INTO vcnt
        FROM emp
        WHERE empno = pid
          AND ename = ppwd;

        IF vcnt = 0 THEN
            RAISE ex_invalid_pwd;
        END IF;
    END IF;
EXCEPTION
    WHEN ex_invalid_id THEN
        RAISE_APPLICATION_ERROR(
            -20001,
            '존재하지 않는 아이디입니다.'
        );
    WHEN ex_invalid_pwd THEN
        RAISE_APPLICATION_ERROR(
            -20002,
            '비밀번호가 일치하지 않습니다.'
        );
    WHEN OTHERS THEN
        RAISE;
END;
 */