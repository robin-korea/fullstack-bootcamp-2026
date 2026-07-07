package days03;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConn;

/**
 * @author AN
 * @date 2026. 7. 7. 오후 4:17:12
 * @subject 
 * @content up_updatedept
 */
public class Ex07_03 {

	 public static void main(String[] args) {
		 
	      Scanner scanner = new Scanner(System.in);
	      
	      System.out.print("> 수정할 부서id(deptno)를 입력? ");
	      int deptno = Integer.parseInt(scanner.nextLine());
	      
	      System.out.print("> 수정할 부서명 입력? ");
	      String dname = scanner.nextLine();
	      
	      System.out.print("> 수정할 지역명 입력? ");
	      String loc = scanner.nextLine();

	      
	      Connection conn = null;
	      CallableStatement cstmt = null;

	      String sql = "{Call UP_UPDATEDEPT(?,?,?)";
	      
	      try {
	         conn = DBConn.getConnection();
	         cstmt = conn.prepareCall(sql);
	         
	         cstmt.setInt(1, deptno);      
	         cstmt.setString(2, dname);      
	         cstmt.setString(3, loc);   
	         
	         cstmt.execute();
	         
	         System.out.println("수정되었습니다.");
	         
	      } catch (SQLException e) {
	         if(e.getErrorCode() == 20001) {
	            System.out.println("존재하지 않는 부서입니다.");
	         } else if(e.getErrorCode() == 20002) {
	               System.out.println("수정할값이 없습니다.");
	         } else {
	            e.printStackTrace();
	         }         
	      }   
	   }
}
/*
CREATE OR REPLACE PROCEDURE up_updatedept 
(
    pdeptno dept.deptno%TYPE, 
    pdname  dept.dname%TYPE  DEFAULT NULL,
    ploc    dept.loc%TYPE  DEFAULT NULL
)
IS
    vcnt NUMBER;
    ex_invalid_deptno EXCEPTION;
    ex_invalid_dname_loc EXCEPTION;
BEGIN
    
    SELECT COUNT(*) INTO vcnt
    FROM dept 
    WHERE deptno = pdeptno;
    
    IF vcnt = 0 THEN
        RAISE ex_invalid_deptno;
    ELSE 
        UPDATE dept 
        SET dname = NVL(pdname, dname), 
            loc   = NVL(ploc, loc) 
        WHERE deptno = pdeptno;   
        COMMIT;
    END IF; 
EXCEPTION
    WHEN ex_invalid_deptno THEN
      RAISE_APPLICATION_ERROR(
            -20001,
            '존재하지 않는 부서입니다.'
        );        
    WHEN OTHERS THEN
        RAISE ;    
END; 
 */
