package days03;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConn;

/**
 * @author AN
 * @date 2026. 7. 7. 오후 4:16:47
 * @subject 
 * @content up_insertdept
 */
public class Ex07_02 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String dname, loc;
		
		System.out.print("> 부서명 입력 ? ");
		dname = scanner.nextLine();
		
		System.out.print("> 지역명 입력 ? ");
		loc = scanner.nextLine();
		
		Connection conn = null;
		CallableStatement cstmt = null;
		
		String sql = "{ CALL UP_INSERTDEPT(?,?) }";
		
		try {
			conn = DBConn.getConnection();
			cstmt = conn.prepareCall(sql);
			// IN ?
			cstmt.setString(1, dname);
			cstmt.setString(2, loc);
				
			cstmt.execute();

			System.out.printf("등록 성공입니다. 부서명: %s, 부서 지역: %s\n",dname,loc);
			
		} catch (SQLException e) {
			if (e.getErrorCode() == 20001) {
				System.out.println("등록실패. 동일한 부서명이 있습니다.");
			}else {
				// 그 외 예외처리 구문 추가
				System.out.println("다시 시도해주세요.");
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
 CREATE OR REPLACE PROCEDURE up_insertdept
(
    pdname IN dept.dname%TYPE := null,
    ploc IN dept.loc%TYPE := null
)
IS
    vcnt NUMBER;
    ex_dname_dup EXCEPTION;
BEGIN
    
    SELECT COUNT(*)
    INTO vcnt
    FROM dept
    WHERE dname = pdname;
    
    IF vcnt > 0 THEN
        RAISE ex_dname_dup;
    END IF;

    INSERT INTO dept(deptno,dname,loc)
    VALUES(seq_dept.NEXTVAL,pdname,ploc);
    
    COMMIT;
    
EXCEPTION
    WHEN ex_dname_dup THEN
        RAISE_APPLICATION_ERROR(
            -20001,
            '부서명이 중복되었습니다.'
        );
    WHEN OTHERS THEN
    RAISE;
END;
 */
