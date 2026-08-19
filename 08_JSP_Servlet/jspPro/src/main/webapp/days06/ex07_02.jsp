<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 8. 11. 오후 4:08:08</title>
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
   	ex07_02.jsp
  </xmp>
  
  <form action="ex07_05.jsp">
 	<table style="width: 400px" border="1">
 		<tr>
 			<td>아이디</td>
 			<td><input type="text" name="id" values="admin"></td>
 		</tr>
 		<tr>
 			<td>이름</td>
 			<td><input type="text" name="name" values="관리자"></td>
 		</tr>
 		<tr>
 			<td>비밀번호</td>
 			<td><input type="password" name="passwd" values="1234"></td>
 		</tr>
 		<tr>
 			<td>이메일</td>
 			<td><input type="text" name="email" values="admin@naver.com"></td>
 		</tr>
 		<tr>
 			<td colspan="2">
 				<input type="submit">
 				<input type="reset">
 			</td>
 		</tr>
 	</table>
  </form>
</div>
<script>
</script>
</body>
</html>