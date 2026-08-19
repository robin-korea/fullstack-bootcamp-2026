<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 스크립트릿(Scriptlet) - 자바코딩
	Date now = new Date();
	String pattern = "yyyy-MM-dd hh:mm:ss";
	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	String strNow = sdf.format(now);
	
	System.out.printf("😊 strNow: %s\n",strNow);
	// jsp 페이지에 출력 : JSP 제공하는 기본객체 9개 중에 - out 객체
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 8. 4. 오전 10:45:44</title>
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
   	ex01.jsp - 동적 페이지
   	[JSP]
   	  ㄴ JavaServer Pages
   	  ㄴ HTML 안에 Java 코드를 삽입하여 동적인 웹 페이지를 만들기 위한 [Java 웹 기술] 이다
	  
	  - JSP 구성요소 중 스크립트 3가지 종류
	    1) 스크립트릿(Scriptlet)
	    2) 표현식(Expression)
	    3) 선언문(Declaration)
  </xmp>
  
  <!-- out 객체  -->
  <h3> out 현재 날짜 + 시간: <% out.println(strNow); %></h3>
  <!-- 표현식 --> 
  <h3> 표현식 현재 날짜 + 시간: <%= strNow %></h3>
  <!-- js로 나타내기 -->   
  <h3> js 현재 날짜 + 시간: <span id="now"></span></h3>   
  
</div>
<script>
	let now = '<%= strNow %>';
	$("#now").html(now);
</script>
</body>
</html>