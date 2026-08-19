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

@WebServlet("/cstvsboard/edit.htm")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Edit() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("> Edit.doGet()...");
		
		long seq = Long.parseLong(request.getParameter("seq"));
		Connection conn = DBConn.getConnection(); 
		BoardDTO dto = null;
		BoardDAO dao = new BoardDAOImpl(conn);
		
		try {
			dto = dao.view(seq);
		} catch (SQLException e) {
			System.out.println("> 4 Edit.doGet() Exception... ");
			e.printStackTrace();
		} finally {
			DBConn.close();
		}
		
		// System.out.println(list.size());
		request.setAttribute("dto", dto);
		
		String path = "/days05/board/edit.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
	    // System.out.println("> Edit.doPost()...");
	    
	    long seq = Integer.parseInt(request.getParameter("seq"));
	    String pwd = request.getParameter("pwd");
	    String email = request.getParameter("email");
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");
	    int tag = Integer.parseInt(request.getParameter("tag"));
	    
	    String currentPage = request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage");
	    String searchCondition = request.getParameter("searchCondition") == null ? "" : request.getParameter("searchCondition");
	    String searchKeyword = request.getParameter("searchKeyword") == null ? "" : request.getParameter("searchKeyword");

	    BoardDTO bDto = BoardDTO.builder()
	            .seq(seq)
	    		.pwd(pwd)
	            .email(email)
	            .title(title)
	            .content(content)
	            .tag(tag)
	            .build();

	    Connection conn = DBConn.getConnection();
	    BoardDAO dao = new BoardDAOImpl(conn);
	    int rowCount = 0;

	    try {
	    
	    	rowCount = dao.update(bDto);
	    	PrintWriter out = response.getWriter();

	        if (rowCount == 1) {
	        	
	        	String location = request.getContextPath() + "/cstvsboard/view.htm?seq=" + seq 
                        + "&currentPage=" + currentPage 
                        + "&searchCondition=" + searchCondition 
                        + "&searchKeyword=" + searchKeyword;

	            out.println("<script>");
	            out.println("alert('"+ seq +"번 글 수정 완료되었습니다.');");
	            out.println("location.href='" + location + "';");
	            out.println("</script>");
			
	        } else {
	            System.out.println("> 4. Edit.doPost() 수정 실패...");
	            out.println("<script>");
	            out.println("alert('"+ seq +"번 글 수정 실패되었습니다.');");
	            out.println("javascript:history.back();");
	            out.println("</script>");
	        }

	    } catch (SQLException e) {
	        System.out.println("> 4. Edit.doPost() Exception...");
	        e.printStackTrace();

	    } finally {
	        DBConn.close();
	    }
	}

}
