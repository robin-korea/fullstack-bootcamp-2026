<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 8. 11. 오후 2:39:49</title>
<link rel="shortcut icon" type="image/x-icon" href="/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
<style>
	.demo{
		border:1px solid gray;
		padding:5px;
		margin-top: 10px;
		max-height: 500px;
		overflow:auto;
	}
</style>
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
   	days06 폴더 안에 있는 jsp 파일 읽어와서 select 에 option 태그로 추가
  </xmp>
  <%
  	String path = application.getInitParameter("path");
  	// 실제 웹서버(톰캣)에 배포된 실제경로에서 파일을 읽어온다
  	String realPath = application.getRealPath(path);
  	
  	File dir = new File(realPath);
  	File [] files = dir.listFiles((file,name) -> name.toLowerCase().endsWith(".jsp"));
  	
  	pageContext.setAttribute("files", files);
  %>
  <%-- path = <%= path %><br>
  path = <%= realPath %><br> --%>
  
  <br>
  <h3><%= path %></h3>
  <%-- <form>
  	<select id="file" name="file">
  		<c:forEach items="<%= files %>" var="file">
  			<option>${file.name}</option>
  		</c:forEach>
  	</select>
  </form> --%>
  <form id="fileForm">
  	<select id="file" name="file">
  		<c:forEach items="${files}" var="file">
  			<option value="${file.name}" ${param.file eq file.name ? 'selected' : ''}>${file.name}</option>
  		</c:forEach>
  	</select>
  </form>
  <%
  	StringBuilder sb = new StringBuilder();
  	String fileName = request.getParameter("file");
  	
  	if(fileName == null || fileName.equals("")){
  		fileName = "ex01.jsp"; 
  	}
  	
  	fileName = String.format("%s\\%s",realPath, fileName);
  	try(
  		FileReader fr = new FileReader(fileName);
  		BufferedReader br = new BufferedReader(fr);
  			){
  		String line = null;
  		while((line = br.readLine()) != null){
  			
  			/* line = line.replaceAll("<","&lt;").replaceAll(">","&gt;") + "<br>";
  			sb.append(line); */
  			
  			sb.append(line.replace("<","&lt;").replace(">","&gt;")).append("<br>");
  		}
  	}catch(Exception e){
  		e.printStackTrace();
  	}
  %>
  <div class="demo">
  	<code><%= sb.toString() %></code>
  </div>
</div>
<script>
	$("#file").on("change", function(){
		$("#fileForm").submit();
	});
	
	/* $("#file").val("${param.file}") */
</script>
</body>
</html>