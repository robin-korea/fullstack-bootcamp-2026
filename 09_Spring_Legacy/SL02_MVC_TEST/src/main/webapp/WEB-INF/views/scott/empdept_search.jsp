<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 9. 8. 오후 3:21:18</title>
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
     empdept_search.jsp
  </xmp>
  
    <form action="/scott/empdept" method="get">
    
	    <div style="margin-bottom: 15px; margin-left : 15px;">
	        <select name="deptno" id="dept-select" style="padding: 5px; width: 150px;">
	            <c:forEach items="${deptList}" var="dept">
	                <option value="${dept.deptno}" <c:if test="${param.deptno eq dept.deptno}">selected</c:if>>
	                    ${dept.dname}
	                </option>
	            </c:forEach>
	        </select>
	    </div>
	    
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
      <c:choose>
          <c:when test="${empty empList}">
              <tr>
                  <td colspan="9" style="text-align: center; padding: 20px;">
                      해당 부서에 소속된 사원이 없습니다.
                  </td>
              </tr>
          </c:when>

          <c:otherwise>
              <c:forEach items="${empList}" var="dto">
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
          </c:otherwise>
      </c:choose>
    </tbody>
    <tfoot>
      <tr>
        <td colspan="9">
          <button id="home" class="home">HOme</button>
        </td>
      </tr>
    </tfoot>
    </table>
  </form>
  
</div>
<script>
$(function(){
    
    $("#dept-select").on("change", function(){
        $("form").submit();
    });
    
    $("#home").on("click", function(e){
        e.preventDefault();
        location.href = "/scott/empdept";
    });
    
});
</script>
</body>
</html>