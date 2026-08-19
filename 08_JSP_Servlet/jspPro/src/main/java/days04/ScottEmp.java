package days04;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

import org.doit.domain.EmpVO;

import com.util.DBConn;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/scott/emp")
public class ScottEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ScottEmp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptno = Integer.parseInt(request.getParameter("deptno"));	
		
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet  rs   = null; 
		ArrayList<EmpVO> list = null;
		EmpVO vo = null;
		
		conn = DBConn.getConnection();
		
		String sql = """
				SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
				FROM emp
				WHERE deptno = ?
				ORDER BY deptno ASC
					""";
		try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, deptno);
	        rs = pstmt.executeQuery();
	        
	        int empno, mgr;
	        double sal, comm;
	        String ename, job;
	        LocalDateTime hiredate;
	        
	        if (rs.next()) { 
	            list = new ArrayList<EmpVO>();
	            do {
	                empno = rs.getInt("empno");
	                ename = rs.getString("ename");
	                job = rs.getString("job");
	                mgr = rs.getInt("mgr");
	                hiredate = rs.getDate("hiredate").toLocalDate().atStartOfDay();
	                sal = rs.getDouble("sal");
	                comm = rs.getDouble("comm");
	                deptno = rs.getInt("deptno");
	                
	                vo = EmpVO.builder()
	                        .empno(empno)
	                        .ename(ename)
	                        .job(job)
	                        .mgr(mgr)
	                        .hiredate(hiredate)
	                        .sal(sal)
	                        .comm(comm)
	                        .deptno(deptno)
	                        .build();
	                
	                list.add(vo);
	            } while (rs.next());
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if(rs != null) rs.close();
	            if(pstmt != null) pstmt.close();
	            DBConn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
		request.setAttribute("list", list);
		
		String path = "/days04/ex05_emp.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
	    dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
