<%@page import="java.net.URLEncoder"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	String name; // 인증받은 사용자의 이름을 저장할 변수 선언
	boolean auth; // 권한 ture/false
	// DB 연동: id + passwd 체크
	String location;
	if(id.equals("admin")&& passwd.equals("1234")){
		name = "관리자";
		auth = true;
		location = "ex03.jsp?name=" + URLEncoder.encode(name) + "&auth="+auth;
	}else if(id.equals("hong")&& passwd.equals("1234")){
		name = "홍길동";
		auth = false;
		location = "ex03.jsp?name=" + URLEncoder.encode(name) + "&auth="+auth;
	}else if(id.equals("kim")&& passwd.equals("1234")){
		name = "김도훈";
		auth = false;
		location = "ex03.jsp?name=" + URLEncoder.encode(name) + "&auth="+auth;
	}else{
		location = "ex03.jsp?error";
	}
	
	// [1] 리다이렉트
	response.sendRedirect(location);
	
	/* // [2] 포워딩
	RequestDispatcher dispatcher = request.getRequestDispatcher(location);
	dispatcher.forward(request, response); */
%>