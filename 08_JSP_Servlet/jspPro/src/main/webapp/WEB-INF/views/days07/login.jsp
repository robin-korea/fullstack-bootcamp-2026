<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 8. 13. 오후 3:01:10</title>
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
   	login.jsp
  </xmp>
  
  <h3>로그인</h3>
  
  <form action="${pageContext.request.contextPath}/mvc/member/login.htm" method="post">
  	<table>
  	  <tr>
         <td align="center">아이디</td>
         <td><input type="text" name="id" size="15" required="required" autofocus="autofocus" value="${param.id}"></td>
      </tr>
      <tr>
         <td align="center">비밀번호</td>
         <td><input type="password" name="pwd" size="15" required="required"></td>
      </tr>
      <tr>
         <td colspan="2" align="center">
            <input type="submit" value="로그인"> &nbsp;&nbsp;&nbsp; 
            <input type="button" value="취소" onclick="location.href='${pageContext.request.contextPath}/mvc/board/list.htm'">
      </tr>
  	</table>
  </form>
</div>
<script>
</script>
</body>
</html>