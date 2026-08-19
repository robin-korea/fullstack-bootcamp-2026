package days14;

/**
 * @author An
 * @date 2026. 5. 29. 오후 4:38:31 
 * @subject 
 * @content 
 *
 */
public class Ex10 {

	public static void main(String[] args) {
		
		// JDBCDriver     인터페이스
		// MySQLDriver    클래스
		// OracleDriver   클래스
		// MSSQLDriver    클래스
		
		// 자식 객체만 변경해서 사용 가능
		JDBCDriver con = new OracleDriver();
		con.open();
		
		con.select();
		con.insert();
		con.insert();
		con.insert();
		con.delete();
		con.update();
		
		con.close();
		
	}

}
