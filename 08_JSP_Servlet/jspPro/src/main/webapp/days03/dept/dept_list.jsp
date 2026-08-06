<%@page import="java.util.function.Consumer"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.doit.domain.DeptVO"%>
<%@page import="org.doit.domain.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.time.LocalDateTime"%>
<%
   Connection conn = null;
   PreparedStatement pstmt = null; 
   ResultSet  rs   = null; 
   ArrayList<DeptVO> dlist = null;
   DeptVO dvo = null;
   Iterator<DeptVO> dir = null;
      
   conn = DBConn.getConnection();
 
   String dsql = """
               SELECT *
               FROM dept
               ORDER BY deptno ASC
           """;
       
   try {
      pstmt = conn.prepareStatement(dsql);
      rs = pstmt.executeQuery();
      
      String dname, loc;
      
      if ( rs.next()  ) {   
         dlist = new ArrayList<DeptVO>();
         do {
            int dno = rs.getInt("deptno");
            dname = rs.getString("dname");
            loc = rs.getString("loc");
            
            dvo = DeptVO.builder()
                     .deptno(dno)
                     .dname(dname)
                     .loc(loc)
                     .build();
   
            dlist.add(dvo);
         } while (rs.next() );
      } // if
      
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
<title>2026. 8. 6. 오후 2:04:57</title>
<link rel="shortcut icon" type="image/x-icon" href="/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
<style>
   .btn-area{
       text-align:right;       
   }
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
   부서 목록( dept_list.jsp )
  </xmp>
  
  <h2>부서 목록</h2>
  
  <table>
    <thead>
      <tr>
        <th>부서번호</th>
        <th>부서명</th>
        <th>지역명</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="<%= dlist%>" var="dvo">
       <tr>
         <td>${ dvo.deptno }</td>
         <td><a href="dept_view.jsp?deptno=${ dvo.deptno }">${ dvo.dname }</a></td>
         <td>${ dvo.loc }</td>
       </tr>
      </c:forEach>
    </tbody>
    <tfoot>
      <tr>
        <td colspan="3">
          <!-- 부서 추가 버튼 -->
        <div class="btn-area">
          <button class="add">부서 추가</button>
        </div>
        </td>
      </tr>
    </tfoot>
  </table>
  
  
</div>
<script>
  $(".btn-area button.add").on("click", function (){
    location.href = "dept_add.jsp";  
  });
</script>
</body>
</html>
