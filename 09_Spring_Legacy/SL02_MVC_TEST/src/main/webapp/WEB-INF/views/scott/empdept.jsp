<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 9. 9. 오전 10:11:17</title>
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
    empdept.jsp
  </xmp>
  <div>
  	<form action="${pageContext.request.contextPath}/scott/empdept" method="get">
		  <select id="deptno" name="deptno" onchange="this.form.submit()">
		  	<c:forEach items="${dlist}" var="dto">
		  		<option value="${dto.deptno}">${empty dto.dname ? '부서없음' : dto.dname}</option>
		  	</c:forEach>
		  </select>
	</form>
  </div>
  <br>
  
  <div>
  	<table id="tbl-emp">
      <caption></caption>
      <thead>
      <tr>
        <th></th>
        <th>Empno</th>
        <th>Ename</th>
        <th>Job</th>
        <th>Mgr</th>
        <th>Hiredate</th>
        <th>Sal</th>
        <th>Comm</th>
        <th>Deptno</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${elist}" var="dto">
         <tr>
           <td><input type="checkbox" value="${ dto.empno }" name="empno"></td>
           <td>${ dto.empno }</td>
           <td>${ dto.ename }</td>
           <td>${ dto.job }</td>
           <td>${ dto.mgr }</td>
           <td>
    			<fmt:formatDate value="${dto.hiredate}" pattern="yyyy-MM-dd"/>
		   </td>
           <td>${ dto.sal }</td>
           <td>${ dto.comm }</td>
           <td>${ dto.deptno }</td> 
         </tr>
      </c:forEach>
    </tbody>
    <tfoot>
      <tr>
        <td colspan="9">
          <button id="home" class="home">HOme</button>
        </td>
      </tr>
    </tfoot>
    </table>
  
  </div>
</div>
<script>
	//상태관리
	$("#deptno").val('${empty param.deptno ? 10 : param.deptno}');
</script>
</body>
</html>