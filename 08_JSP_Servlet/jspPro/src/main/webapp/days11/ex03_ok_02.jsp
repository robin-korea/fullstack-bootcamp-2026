<%@page import="java.io.DataInputStream"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 8. 19. 오전 10:30:22</title>
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
   ex03_ok_02
   
   자바의 스트림은 읽기, 쓰기
  </xmp>
  <%
  /*
  	// 개발자가 직접 스트림을 다뤄서 처리해야 한다.
  	ServletInputStream sis = request.getInputStream();
    int b = -1;
    while ( (b = sis.read()) != -1 ){
    	System.out.printf("[%d]",b);
    }
    */
  %>
  <%
  	out.print("> 전송된 스크림 정보 출력<br>");
  	// 개발자가 직접 스트림을 다뤄서 처리해야 한다.
  	ServletInputStream sis = request.getInputStream();
  	DataInputStream dis = new DataInputStream(sis);
  	String line = null;
  	
    while ( (line = dis.readLine()) != null ){
    	out.print(line + "<br>");
    }
  %>
</div>
<script>
</script>
</body>
</html>