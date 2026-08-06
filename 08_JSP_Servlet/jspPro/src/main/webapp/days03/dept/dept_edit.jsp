<%@page import="java.sql.SQLException"%>
<%@page import="com.util.DBConn"%>
<%@page import="org.doit.domain.DeptVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%
	int deptno = Integer.parseInt(request.getParameter("deptno"));	

	Connection conn = null;
	PreparedStatement  pstmt = null;  
	ResultSet  rs   = null;
	DeptVO vo = null;
	String dname = null, loc = null;
	
	conn = DBConn.getConnection();
	
	String sql = """
	       SELECT *
	       FROM dept
	       WHERE deptno = ?
	      """;
	
	try {
	   pstmt = conn.prepareStatement(sql);
	   pstmt.setInt(1, deptno);
	   rs = pstmt.executeQuery();
	   
	   if ( rs.next()  ) {  // 첫 번째 레코드는 존재한다.
	         deptno = rs.getInt("deptno");
	         dname = rs.getString("dname");
	         loc = rs.getString("loc");  
	   } else{
		   %>
		   <script>
		   		alert("존재하지 않는 부서번호입니다.");
		   		location.href="dept_list.jsp";
		   </script>
		   <%
		  return ; 
	   }
	
	} catch (SQLException e) {
	   e.printStackTrace();
	} finally {
	   try {
	      rs.close();
	      pstmt.close();
	      DBConn.close();
	   } catch (SQLException e) { 
	      e.printStackTrace();
	   }
	}

%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 8. 6. 오후 3:34:33</title>
<link rel="shortcut icon" type="image/x-icon" href="/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
<style>
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
<div class="container">
  <xmp class="code">
   	부서 수정하기(dept_edit.jsp)
  </xmp>
  
  <h2>부서 수정</h2>
  
  <form action="dept_edit_ok.jsp" method="post" onsubmit="return checkForm();">
	  <table class="vertical">
	  		<caption>
  				<p class="validateTips">All form fields are required.</p>
  			</caption>
  			<tr>
  				<th>부서번호</th>
  				<td><input type="text" id="deptno" name="deptno" value="<%= deptno %>" readonly="readonly"></td>
  			</tr>
  			<tr>
  				<th>부서명</th>
  				<td><input type="text" id="dname" name="dname" class="long" value="<%= dname %>"></td>
  			</tr>
  			<tr>
  				<th>지역명</th>
  				<td><input type="text" id="loc" name="loc" class="long" value="<%= loc %>"></td>
  			</tr>
	  		<tr>
	  			<th></th>
	  			<td>
				  	<div class="btn-area group">
				  		<button class="add">저장</button>
				  		<button type="button" class="cancle">취소</button>
				  	</div>		
	  			</td>
	  		</tr>
	  	</table>
  	</form>
</div>
<script>
  $(".btn-area button.cancle").on("click", function (){
    location.href = "dept_list.jsp";  
  });
</script>
</body>
</html>