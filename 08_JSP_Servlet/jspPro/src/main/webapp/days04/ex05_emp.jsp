<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 8. 7. 오후 1:35:20</title>
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
   
  </xmp>
  
  <table>
  	<thead>
  		<tr>
  			<th>사번</th>
  			<th>이름</th>
  			<th>직급</th>
  			<th>관리자</th>
  			<th>입사일</th>
  			<th>급여</th>
  			<th>성과급</th>
  			<th>부서번호</th>
  		</tr>
  	</thead>
  	<tbody>
  	<c:if test="${ empty list }">
  		<tr>
  			<td colspan="8">사원이 존재하지 않습니다.</td>
  		</tr>
  	</c:if>
  	<c:if test="${ not empty list }">
  		<c:forEach items="${list}" var="evo">
  			<tr>
  				<td>${evo.empno}</td>
  				<td>${evo.ename}</td>
  				<td>${evo.job}</td>
  				<td>${evo.mgr}</td>
  				<td>${evo.hiredate}</td>
  				<td>${evo.sal}</td>
  				<td>${evo.comm}</td>
  				<td>${evo.deptno}</td>
  			</tr>
  		</c:forEach>
  	</c:if>
  	</tbody>
  	<tfoot>
  		<tr>
  			<td colspan="8">
  				<%-- <span class="badge left red">${empty list ? 0 : list.size()}명</span> --%>
  				<span class="badge left red">${empty list ? 0 : fn:length(list)}명</span>
  				<a href="${pageContext.request.contextPath}/scott/dept">뒤로 가기</a>
  			</td>
  		</tr>
  	</tfoot>
  </table>
  
</div>
<script>
</script>
</body>
</html>