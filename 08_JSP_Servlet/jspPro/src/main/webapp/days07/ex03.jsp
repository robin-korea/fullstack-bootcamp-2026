<%@page import="com.util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 8. 12. 오후 2:02:13</title>
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
  	include 지시자: 중복..코딩 처리
  	WEB-INF > inc 폴더 추가
  	             ㄴ cookieInc.jspf
  	             	공통 자바 코딩
  	             
  	       ex02_default.jsp   공통 자바 코딩
  	       board/list.jsp     공통 자바 코딩
  	       board/writer.jsp   공통 자바 코딩
  	            
  	             
   	커넥션 풀(Connection Pool)
   	
   	META-INF 폴더 안에 context.xml 넣어도 되는 이유는
   		ㄴ 톰캣에서 META-INF/context.xml을 자동으로 인식.
   		ㄴ 웹 어플리케이션의 표준 디렉토리
   		ㄴ context 의미: 톰캣에서 실행되는 하나의 웹 어플리케이션
   		
   		com.util.ConnectionProvider.java
  </xmp>
  
  <%
	  /* Context initContext = new InitialContext();
	  Context envContext  = (Context)initContext.lookup("java:/comp/env");
	  DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
	  Connection conn = ds.getConnection(); */
	  
	  Connection conn = ConnectionProvider.getConnection();
	  
  //etc.
  %>
  
  > conn : <%= conn %>
  
<%
	conn.close(); // 커넥션 풀에 반환
%>
</div>
<script>
</script>
</body>
</html>