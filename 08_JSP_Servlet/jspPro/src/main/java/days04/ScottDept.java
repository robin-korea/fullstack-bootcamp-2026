package days04;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.doit.domain.DeptVO;
import com.util.DBConn;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/scott/dept")
public class ScottDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ScottDept() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("> ScottDept.doGet()...");
		// 1. 부서정보를 조회 로직 처리
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet  rs   = null; 
		ArrayList<DeptVO> list = null;
		DeptVO vo = null;
		Iterator<DeptVO> ir = null;

		conn = DBConn.getConnection();

		String sql = """
				 SELECT *
				 FROM dept
				 ORDER BY deptno ASC
				""";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int deptno;
			String dname, loc;

			if ( rs.next()  ) {   
				list = new ArrayList<DeptVO>();
				do {
					deptno = rs.getInt("deptno");
					dname = rs.getString("dname");
					loc = rs.getString("loc");

					vo = DeptVO.builder()
							.deptno(deptno)
							.dname(dname)
							.loc(loc)
							.build();

					list.add(vo);
				} while (rs.next() );
			} // if

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close(); 
				DBConn.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}
		
		request.setAttribute("list", list);
		
		// 2. 포워딩
		String path = "/days04/ex05_dept.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
