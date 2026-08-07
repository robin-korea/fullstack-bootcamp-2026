<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	// DB 연동: id + passwd 체크
	String location;
	if(id.equals("admin")&& passwd.equals("1234")){
		location = "ex02_main.jsp";
	}else if(id.equals("hong")&& passwd.equals("1234")){
		location = "ex02_main.jsp";
	}else if(id.equals("kim")&& passwd.equals("1234")){
		location = "ex02_main.jsp";
	}else{
		location = "ex02.jsp?error";
	}
	
	// [1] 리다이렉트
	/* response.sendRedirect(location); */
	
	// [2] 포워딩
	RequestDispatcher dispatcher = request.getRequestDispatcher(location);
	dispatcher.forward(request, response);
%>