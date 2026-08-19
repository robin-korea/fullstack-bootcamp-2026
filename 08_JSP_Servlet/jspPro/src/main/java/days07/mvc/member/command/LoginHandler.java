package days07.mvc.member.command;

import java.sql.Connection;
import java.sql.SQLException;

import com.util.ConnectionProvider;

import days07.mvc.board.command.CommandHandler;
import days07.mvc.member.domain.MemberDTO;
import days07.mvc.member.persistence.MemberDAO;
import days07.mvc.member.persistence.MemberDAOImpl;
import days08.AuthUser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String requestMethod = request.getMethod();
		// System.out.println(requestMethod);
		if(requestMethod.equals("GET")) {
			return "/WEB-INF/views/days07/login.jsp";
		}else if (requestMethod.equals("POST")){
			response.setContentType("text/html; charset=UTF-8");
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");

			Connection conn = ConnectionProvider.getConnection();
			MemberDAO dao = new MemberDAOImpl(conn);
			
			try {
				
				MemberDTO dto = dao.login(id, pwd);
				
				if(dto != null) {
					AuthUser authUser = AuthUser.builder()
							.loginUser(dto.getId())
							.loginUserRole(dto.getRole())
							.build();
					
					HttpSession session = request.getSession();
					session.setAttribute("authUser", authUser);
					
					String location = "redirect:" + request.getContextPath() + "/mvc/board/list.htm";
					return location;
				}else {
					System.out.println("> LoginHandler 로그인 실패...");
					
					return "redirect:" + request.getContextPath() + "/mvc/login.htm?login=fail";
				}
				
		
			} catch (SQLException e) {
				System.out.println("> LoginHandler Exception...");
				e.printStackTrace();

			} finally {
				conn.close();
			}

		    
		}
		
		// 글쓰기 실패 또는 GET, POST 이외의 요청
		return null;
		
	}

}
