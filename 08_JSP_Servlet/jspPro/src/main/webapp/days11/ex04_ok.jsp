<%@page import="com.oreilly.servlet.multipart.FileRenamePolicy"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 8. 19. 오전 11:07:47</title>
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
    ex04_ok.jsp
  </xmp>
  <%
  /*
  	String saveDir = pageContext.getServletContext().getRealPath("/days11/ex04");
  	System.out.println(saveDir);
  	
  	File f = new File(saveDir);
  	if(!f.exists()) f.mkdirs();
  	
  	int maxSize = 5*1024*1024;
  	
  	FileRenamePolicy policy = new DefaultFileRenamePolicy();
  	
  	MultipartRequest mrequest = new MultipartRequest(
  			request
  			,saveDir
  			,maxSize
  			,"URF-8"
  			,policy
  			);
  	 톰캣 버전이 달라 패키지 명 이 달라 사용 불가
  	*/
  %>
</div>
<script>
</script>
</body>
</html>