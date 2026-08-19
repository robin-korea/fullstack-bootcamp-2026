<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 8. 13. 오후 2:45:46</title>
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
   	days08.ex01.jsp
   	
   	list.htm(목록보기): 인증X
   	view.htm(상세보기): 인증X        -> [삭제][수정] 인증O == 작성자
   	write.htm(글쓰기): 반드시 인증 O
   	
   	[ 세션(Session) ]
  </xmp>
  
  <%
  	String sid = session.getId();
  	long l = session.getCreationTime();
  	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  	Date d = new Date();
  	d.setTime(1);
  %>
  세션 ID = <%= sid %><br>
  세션 생성 날짜 = <%= sdf.format(d) %><br>
  <%
  	long last = session.getLastAccessedTime();
  	d.setTime(last);
  %>
  세션 마지막 접속 날짜 = <%= sdf.format(d) %><br>
  
  
</div>
<script>
</script>
</body>
</html>