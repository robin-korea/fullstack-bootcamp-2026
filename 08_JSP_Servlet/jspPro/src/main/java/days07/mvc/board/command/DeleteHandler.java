package days07.mvc.board.command;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import com.util.ConnectionProvider;

import days07.mvc.board.persistence.BoardDAO;
import days07.mvc.board.persistence.BoardDAOImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String requestMethod = request.getMethod();
		// System.out.println(requestMethod);
		if(requestMethod.equals("GET")) {
			return "/WEB-INF/views/days07/board/delete.jsp";
		}else {
			response.setContentType("text/html; charset=UTF-8");

			long seq = Integer.parseInt(request.getParameter("seq"));
		    String pwd = request.getParameter("pwd");
		    
		    Connection conn = ConnectionProvider.getConnection();
		    BoardDAO dao = new BoardDAOImpl(conn);
		    int rowCount = 0;

		    try {
		    
		    	rowCount = dao.delete(seq, pwd);
		    	PrintWriter out = response.getWriter();

		        if (rowCount == 1) {
		        	
		        	String location = "redirect:" + request.getContextPath() + "/mvc/board/list.htm?del="+seq;
		            return location;
		        	
		        	/*
		            out.println("<script>");
		            out.println("alert('"+ seq +"번 글 삭제되었습니다.');");
		            out.println("location.href='" + location + "';");
		            out.println("</script>");
		            */
				
		        } else {
		            System.out.println("> DeleteHandler 글 삭제 실패...");
		            
		            // return "redirect:" + request.getContextPath() + "/mvc/board/delete.htm?seq=" + seq + "&del=fail";
		            return "redirect:" + request.getContextPath() + "/mvc/board/view.htm?seq=" + seq + "&del=fail";
		            
		            /*
		            out.println("<script>");
		            out.println("alert('"+ seq +"번 글 삭제 실패되었습니다.');");
		            out.println("javscript:history.back();");
		            out.println("</script>");
		            */
		        }

		    } catch (SQLException e) {
		        System.out.println("> DeleteHandler Exception...");
		        e.printStackTrace();

		    } finally {
		    	conn.close();
		    }
		}
		
		// 글쓰기 실패 또는 GET, POST 이외의 요청
		return null;
		
	}

}
