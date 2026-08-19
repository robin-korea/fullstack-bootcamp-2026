<!-- %@ page 지시자 -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!-- 스크립트릿: 자바 코딩 -->    
<%
   // ex10.html(id,pwd)-> 서버에 get방식 submit(전송)-> ex10_ok.jsp 전달
   //              action속성uri?query string
   //              ex10_ok.jsp ? id=admin&pwd=1234
   // % 서버에서 실행되는 코딩.
   String id = request.getParameter("id");
   String password = request.getParameter("pwd");
   // DB 처리
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex10_ok.jsp</title>
</head>
<body>

<h3>ex10_ok.jsp</h3>
             <!-- %= 표현식 -->
전송된 아이디 : <%= id %><br>
전송된 비밀번호 : <%= password %><br>

</body>
</html>





