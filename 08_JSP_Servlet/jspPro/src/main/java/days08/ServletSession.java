package days08;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/days08/session.do")
public class ServletSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletSession() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// AuthUser  로그인한 사용자 정보 -> 서블릿에서 -> 세션에 저장.
		String loginUser = "hong";
		String loginUserRole = "MANAGER";
		AuthUser authUser = AuthUser.builder()
				.loginUser(loginUser)
				.loginUserRole(loginUserRole)
				.build();
	
		HttpSession session =  request.getSession();
		session.setAttribute("authUser", authUser);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
