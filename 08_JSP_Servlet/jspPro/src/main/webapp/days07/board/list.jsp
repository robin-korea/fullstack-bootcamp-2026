<%@page import="com.util.Cookies"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file="/WEB-INF/inc/cookieInc.jspf" %>
<%-- <%
	Cookies cookies = new Cookies(request);
	
	String loginUser = cookies.getValue("loginUser");
	request.setAttribute("loginUser", loginUser);
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 8. 12. 오전 11:46:04</title>
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
   	list.jsp
  </xmp>
  
  <h3>게시판 목록</h3>
  <!-- 첫 번째 방법: 글쓰기 버튼 X -->
  <%-- <c:if test="${not empty loginUSer }">
  	<a href="write.jsp" id="write">글쓰기</a>
  </c:if> --%>
  
  <a href="write.jsp">글쓰기</a>
  
  
</div>
<%--
<script>
	$("#write").on("click",function(e) {
		e.preventDefault();
		let loginUser = "${loginUser}";
		
		if(!loginUser){
			alert("로그인 후 이용 가능합니다.");
			location.href = "${pageContext.request.contextPath}/days07/ex02_default.jsp";
		} else{
			location.href = $(this).attr("href");
		}
	});
</script>
--%>
<script>
	
</script>
</body>
</html>