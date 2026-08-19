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
public class Ex06 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("> 로그인 체크할 ID(empno), PWD(ename)를 입력 ? ");
		int id = scanner.nextInt();
		String pwd = scanner.next();
		
		
		Connection conn = null;
		CallableStatement cstmt = null;

		String sql = "{ CALL UP_LOGIN(?,?,?) }";

		try {
			conn = DBConn.getConnection();
			cstmt = conn.prepareCall(sql);
			// IN ?
			cstmt.setInt(1, id);
			cstmt.setString(2, pwd);
			// OUT ?
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.executeQuery();

			int check = cstmt.getInt(3); // 실행 후에 출력용 파라미터 값을 얻어와서 변수에 저장

			if (check == 0) {
				System.out.println("로그인 성공 !!");
			} else if(check == -1){
				System.out.println("로그인 실패!!!\n아이디는 존재하지만 비밀번호가 일치하지 않습니다.");
			} else if(check == 1){
				System.out.println("로그인 실패!!!\n존재하지 않는 아이디입니다.");
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
CREATE OR REPLACE PROCEDURE up_login
(
    pid    IN  emp.empno%TYPE,
    ppwd   IN  emp.ename%TYPE,
    pcheck OUT NUMBER
)
IS
    vcnt NUMBER;
BEGIN
    -- 1. 아이디 존재 여부 확인
    SELECT COUNT(*)
    INTO vcnt
    FROM emp
    WHERE empno = pid;

    IF vcnt = 0 THEN
        pcheck := 1;       -- 아이디 없음, 로그인 실패
    ELSE
        -- 2. 비밀번호 확인
        SELECT COUNT(*)
        INTO vcnt
        FROM emp
        WHERE empno = pid
          AND ename = ppwd;

        IF vcnt = 1 THEN
            pcheck := 0;   -- 로그인 성공
        ELSE
            pcheck := -1;  -- 아이디는 존재하지만 비밀번호 틀림
        END IF;
    END IF;
END;
 */