package days07.mvc.board.command;

import java.sql.Connection;
import java.sql.SQLException;

import com.util.ConnectionProvider;

import days07.mvc.board.domain.BoardDTO;
import days07.mvc.board.persistence.BoardDAO;
import days07.mvc.board.persistence.BoardDAOImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WriteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String requestMethod = request.getMethod();
		// System.out.println(requestMethod);
		if(requestMethod.equals("GET")) {
			return "/WEB-INF/views/days07/board/write.jsp";
		}else {
			response.setContentType("text/html; charset=UTF-8");

		    String writer = request.getParameter("writer");
		    String pwd = request.getParameter("pwd");
		    String email = request.getParameter("email");
		    String title = request.getParameter("title");
		    String content = request.getParameter("content");
		    int tag = Integer.parseInt(request.getParameter("tag"));

		    BoardDTO bDto = BoardDTO.builder()
		            .writer(writer)
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
		    	int newSeq = dao.getNextSeq();
		        bDto.setSeq(newSeq);
		         
		    	rowCount = dao.insert(bDto);

		        if (rowCount == 1) {
		        	
		            String location = "redirect:" + request.getContextPath() + "/mvc/board/list.htm";
		            return location;
		            
		            /*
		            PrintWriter out = response.getWriter();
		            out.println("<script>");
		            out.println("alert('"+ newSeq+"번 글쓰기가 완료되었습니다.');");
		            out.println("location.href='" + location + "';");
		            out.println("</script>");
		            */
				
		        } else {
		            System.out.println("> WriteHandler.doPost() 글쓰기 실패...");
		        }

		    } catch (SQLException e) {
		        System.out.println("> WriteHandler.doPost() Exception...");
		        e.printStackTrace();

		    } finally {
		        conn.close();
		    }
		}
		
		// 글쓰기 실패 또는 GET, POST 이외의 요청
		return null;
		
	}

}
