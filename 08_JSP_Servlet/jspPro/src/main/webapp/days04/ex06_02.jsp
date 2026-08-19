<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 8. 7. 오후 2:40:48</title>
<link rel="shortcut icon" type="image/x-icon" href="/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
</head>
<body>
<header>
  <h1 class="main"><a href="#" style="position: absolute;top:30px;">My Home</a></h1>
  <ul>
    <li><a href="#">로그인</a></li>
    <li><a href="#">회원가입</a></li>
  </ul>
</header>
<div>
  <xmp class="code">
   	ex06_02.jsp
  </xmp>
  
  <%
  	String name = request.getParameter("name");
  %>	
  <%-- <form action="ex06_03.jsp?name=<%= name %>&age=${param.age}" method="post"> --%>
  <form action="ex06_03.jsp">
  	<%-- <input type="hidden" name="name" value="${param.name}">
  	<input type="hidden" name="age" value="${param.age}"> --%>
  	
    address : <input type="text" name="address" value="서울 역삼동"><br>
    tel : <input type="text" name="tel" value="010-1111-1111"><br>
    <input type="button" value="Prev" onclick="history.back();">
    <input type="submit" value="Next">  
  </form>  
</div>
<script>
	let hiddenElement;
	<%
		Enumeration<String> en =request.getParameterNames();
		while(en.hasMoreElements()){
			String pName = en.nextElement();
			String pValue = request.getParameter(pName);
	%>
		hiddenElement = `<input type="hidden" name="<%= pName %>" value="<%= pValue%>">`;
		$("form").append(hiddenElement)
	<%
		}
	%>
</script>
</body>
</html>




