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
import java.sql.SQLException;

import com.util.DBConn;

import days05.board.domain.BoardDTO;
import days05.board.persistence.BoardDAO;
import days05.board.persistence.BoardDAOImpl;


@WebServlet("/cstvsboard/write.htm")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Write() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("> Write.doGet()...");
		
		String path = "/days05/board/write.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
	    System.out.println("> Write.doPost()...");

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

	    Connection conn = DBConn.getConnection();
	    BoardDAO dao = new BoardDAOImpl(conn);
	    int rowCount = 0;

	    try {
	    	int newSeq = dao.getNextSeq();
	        bDto.setSeq(newSeq);
	         
	    	rowCount = dao.insert(bDto);

	        if (rowCount == 1) {
	        	
				/*
				 * request.getSession().setAttribute( "message", "글 작성이 완료되었습니다." );
				 */
	        	
				/*
				 * String location = "/cstvsboard/list.htm"; response.sendRedirect(location);
				 */
	        	
	        	// [2]
	            String location = "/cstvsboard/list.htm";
	            PrintWriter out = response.getWriter();

	            out.println("<script>");
	            out.println("alert('"+ newSeq+"번 글쓰기가 완료되었습니다.');");
	            out.println("location.href='" + location + "';");
	            out.println("</script>");
			
	        } else {
	            System.out.println("> 2. Write.doPost() 글쓰기 실패...");
	        }

	    } catch (SQLException e) {
	        System.out.println("> 2. Write.doPost() Exception...");
	        e.printStackTrace();

	    } finally {
	        DBConn.close();
	    }
	}
}


