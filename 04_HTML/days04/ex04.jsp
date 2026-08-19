<!-- %@ page 지시자 -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!-- 스크립트릿: 자바 코딩 -->    
<%
   String id = request.getParameter("id");
   String password = request.getParameter("pwd");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>days04/ex04.jsp</title>
</head>
<body>

<h3>days04/ex04.jsp</h3>
전송된 아이디 : <%= id %><br>
전송된 비밀번호 : <%= password %><br>

</body>
</html>





