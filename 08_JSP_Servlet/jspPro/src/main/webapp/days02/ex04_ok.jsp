<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
	String [] empnos = request.getParameterValues("empno");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 8. 6. 오전 9:17:01</title>
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
   
  </xmp>
  <ul>
  	<% 
  		for(int i = 0; i< empnos.length; i++){
  	%><li><%= empnos[i] %></li><%		
  		
  		}
  	%>
  </ul>
  
  <h3>JSTL 사용 처리</h3>
  
  	<ol>
  		<c:forEach items="<%= empnos %>" var="eno">
  			<li>${eno}</li>
  		</c:forEach>
  	</ol>
  
</div>
<script>
</script>
</body>
</html>


<!-- 파일명   역할   필요 여부
https://mvnrepository.com/artifact/jakarta.servlet.jsp.jstl/jakarta.servlet.jsp.jstl-api/3.0.2?utm_source=chatgpt.com
 ㄴ jakarta.servlet.jsp.jstl-api-3.0.2.jar   JSTL API (인터페이스)   필수

https://repo1.maven.org/maven2/org/glassfish/web/jakarta.servlet.jsp.jstl/3.0.1/?utm_source=chatgpt.com 
 ㄴ jakarta.servlet.jsp.jstl-3.0.1.jar   JSTL 구현체(Implementation)   필수 -->