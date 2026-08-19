package days07.mvc.board.command;

import java.sql.Connection;
import java.sql.SQLException;

import com.util.ConnectionProvider;

import days07.mvc.board.domain.BoardDTO;
import days07.mvc.board.persistence.BoardDAO;
import days07.mvc.board.persistence.BoardDAOImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String requestMethod = request.getMethod();
		// System.out.println(requestMethod);
		if(requestMethod.equals("GET")) {
			
			long seq = Long.parseLong(request.getParameter("seq"));
			Connection conn = ConnectionProvider.getConnection();
			BoardDTO dto = null;
			BoardDAO dao = new BoardDAOImpl(conn);
			
			try {
				dto = dao.view(seq);
			} catch (SQLException e) {
				System.out.println("> EditHandler Exception... ");
				e.printStackTrace();
			} finally {
				conn.close();
			}
			
			// System.out.println(list.size());
			request.setAttribute("dto", dto);
			
			return "/WEB-INF/views/days07/board/edit.jsp";
		}else if (requestMethod.equals("POST")){
			response.setContentType("text/html; charset=UTF-8");
			
			long seq = Integer.parseInt(request.getParameter("seq"));
		    String pwd = request.getParameter("pwd");
		    String email = request.getParameter("email");
		    String title = request.getParameter("title");
		    String content = request.getParameter("content");
		    int tag = Integer.parseInt(request.getParameter("tag"));

		    BoardDTO bDto = BoardDTO.builder()
		            .seq(seq)
		    		.pwd(pwd)
		            .email(email)
		            .title(title)
		            .content(content)
		            .tag(tag)
		            .build();

		    Connection conn = ConnectionProvider.getConnection();
		    BoardDAO dao = new BoardDAOImpl(conn);
		    int rowCount = 0;

		    try {
		    
		    	rowCount = dao.update(bDto);

		        if (rowCount == 1) {
		        	
					
					 String location = "redirect:" + request.getContextPath() + "/mvc/board/list.htm?edit="+seq; 
					 return location;
					 
		            
		        	/*
		            out.println("<script>");
		            out.println("alert('"+ seq +"번 글 수정 완료되었습니다.');");
		            out.println("location.href='" + location + "';");
		            out.println("</script>");
		            */
		           
		        	
		        	
		        } else {
		        	
		            System.out.println("> 4. Edit.doPost() 수정 실패...");
		            
		            return "redirect:" + request.getContextPath() + "/mvc/board/edit.htm?seq=" + seq + "&edit=fail";
		            /*
		            out.println("<script>");
		            out.println("alert('"+ seq +"번 글 수정 실패되었습니다.');");
		            out.println("javascript:history.back();");
		            out.println("</script>");
		            */
		        }

		    } catch (SQLException e) {
		        System.out.println("> 4. Edit.doPost() Exception...");
		        e.printStackTrace();

		    } finally {
		        conn.close();
		    }
		}
		
		// 글쓰기 실패 또는 GET, POST 이외의 요청
		return null;
		
	}

}
