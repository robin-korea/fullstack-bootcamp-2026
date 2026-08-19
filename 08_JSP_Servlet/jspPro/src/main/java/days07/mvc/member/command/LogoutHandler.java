package days07.mvc.member.command;

import days07.mvc.board.command.CommandHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(false);
        
        if (session != null) {
            session.invalidate();
        }

        return "redirect:" + request.getContextPath() + "/mvc/board/list.htm";
    }

}
