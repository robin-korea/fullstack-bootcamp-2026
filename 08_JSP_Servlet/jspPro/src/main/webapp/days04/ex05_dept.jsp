<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 8. 7. 오후 12:13:48</title>
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
   	ex05_dept.jsp
  </xmp>
  
  <h3>dept list</h3>
  
  <select id="deptno" name="deptno">
  	<option>부서 선택...</option>
  	<c:if test="${not empty list}">
	  	<c:forEach var="dvo" items="${list}">
  			<option value='${dvo.deptno}'>${dvo.dname}</option>
  		</c:forEach>	
  	</c:if>
  </select>
  <br>
  <br>
  <a href="${pageContext.request.contextPath}/days04/ex05.jsp">뒤로가기</a>
  
</div>

<!-- <script>
	$("#deptno").on("change",function(){
		let deptno = $(this).val();
		if(deptno !== "부서 선택..." ){
			location.href="${pageContext.request.contextPath}/scott/emp?deptno=" + deptno
		}
	});
</script> -->

<script>
	$("#deptno").wrap("<form></form>")
	 .on("change",function(){
		$(this).parent()
		   .attr({
			   method:"get",
			   action:"${pageContext.request.contextPath}/scott/emp"
		   })
		   .submit();
	 });
</script>

</body>
</html>