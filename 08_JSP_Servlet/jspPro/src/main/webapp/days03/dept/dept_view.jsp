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
   	부서 상세보기(dept_view.jsp)
  </xmp>
  
  <h2>부서 상세보기</h2>
  
  <table class="vertical">
  		<caption>
  			
  		</caption>
  		<tr>
  			<th>부서번호</th>
  			<td><%= deptno %></td>
  		</tr>
  		<tr>
  			<th>부서명</th>
  			<td><%= dname %></td>
  		</tr>
  		<tr>
  			<th>지역명</th>
  			<td><%= loc %></td>
  		</tr>
  		<tr>
  			<th></th>
  			<td>
			  	<div class="btn-area group">
			  		<button class="list">목록</button>
			  		<button class="edit">수정</button>
			  		<button class="delete">삭제</button>
			  	</div>		
  			</td>
  		</tr>
  	</table>
</div>
<script>
  $(".btn-area button.edit").on("click", function (){
   	 location.href = `dept_edit.jsp?deptno=<%=deptno%>`;  
  });
</script>
<script>
  $(".btn-area button.list").on("click", function (){
    location.href = "dept_list.jsp";  
  });
</script>
<script>
  $(".btn-area button.delete").on("click", function (){
    if(confirm("정말 삭제하시겠습니까?")){
   		location.href = `dept_delete.jsp?deptno=<%=deptno%>`;  
    }
  });
</script>
</body>
</html>