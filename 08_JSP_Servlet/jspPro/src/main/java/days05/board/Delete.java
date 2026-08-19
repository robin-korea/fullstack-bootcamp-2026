package days05.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.doit.domain.DeptVO;

import com.util.DBConn;

import days05.board.domain.BoardDTO;
import days05.board.domain.PageDTO;
import days05.board.persistence.BoardDAO;
import days05.board.persistence.BoardDAOImpl;

@WebServlet("/cstvsboard/delete.htm")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Delete() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("> Delete.doGet()...");
		
		
		// 2. delete.jsp 포워딩
		String path = "/days05/board/delete.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
	    System.out.println("> Delete.doPost()...");
	    
	    long seq = Integer.parseInt(request.getParameter("seq"));
	    String pwd = request.getParameter("pwd");
	    
	    Connection conn = DBConn.getConnection();
	    BoardDAO dao = new BoardDAOImpl(conn);
	    int rowCount = 0;
	    
	    String currentPage = request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage");
	    String searchCondition = request.getParameter("searchCondition") == null ? "" : request.getParameter("searchCondition");
	    String searchKeyword = request.getParameter("searchKeyword") == null ? "" : request.getParameter("searchKeyword");

	    try {
	    
	    	rowCount = dao.delete(seq, pwd);
	    	PrintWriter out = response.getWriter();

	        if (rowCount == 1) {
	        	
	        	String location = request.getContextPath() + "/cstvsboard/list.htm?currentPage=" + currentPage 
                        + "&searchCondition=" + searchCondition 
                        + "&searchKeyword=" + searchKeyword;

	            out.println("<script>");
	            out.println("alert('"+ seq +"번 글 삭제되었습니다.');");
	            out.println("location.href='" + location + "';");
	            out.println("</script>");
			
	        } else {
	            System.out.println("> 5. Delete.doPost() 삭제 실패...");
	            out.println("<script>");
	            out.println("alert('"+ seq +"번 글 삭제 실패되었습니다.');");
	            out.println("javscript:history.back();");
	            out.println("</script>");
	        }

	    } catch (SQLException e) {
	        System.out.println("> 5. Delete.doPost() Exception...");
	        e.printStackTrace();

	    } finally {
	        DBConn.close();
	    }
	}

}
