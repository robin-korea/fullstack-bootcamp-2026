<%@page import="java.sql.SQLException"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.doit.domain.DeptVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
   Connection conn = null;
   PreparedStatement pstmt = null; 
   ResultSet  rs   = null; 
   ArrayList<DeptVO> list = null;
   DeptVO vo = null;
   Iterator<DeptVO> ir = null;
      
   conn = DBConn.getConnection();
   
   // 3. sql작성->stmt sql실행-> rs -> ArrayList 저장 -> 출력
   //String sql = "SELECT * "
   //        + " FROM dept "
   //        + " ORDER BY deptno ASC";
   // Java 15 이상: 텍스트블럭 
   String sql = """
               SELECT *
               FROM dept
               ORDER BY deptno ASC
              """;
   try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      
      int deptno;
      String dname, loc;
      
      if ( rs.next()  ) {   
         list = new ArrayList<DeptVO>();
         do {
            deptno = rs.getInt("deptno");
            dname = rs.getString("dname");
            loc = rs.getString("loc");
            
            vo = DeptVO.builder()
                     .deptno(deptno)
                     .dname(dname)
                     .loc(loc)
                     .build();
   
            list.add(vo);
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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 8. 4. 오후 2:20:50</title>
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
   	ex03_02.jsp
  </xmp>
  <select id="deptno" name="deptno">
  	<option>부서 선택...</option>
  	<%
  		if(list != null){
  			
  			for(DeptVO dvo : list) {
  				int deptno = dvo.getDeptno();
  				String dname = dvo.getDname();
  	%><option value='<%= deptno %>'><%= dname %></option><%
  			}
  			
  		}
  	%>
  </select>
  
  <%-- <select id="deptno" name="deptno">
  	<option>부서 선택...</option>
  	<%
  		if(list != null){
  			
  			list.forEach((dvo) -> {
  				int deptno = dvo.getDeptno();
  				String dname = dvo.getDname();
  	%><option value='<%= deptno %>'><%= dname %></option><%
  				/*
				System.out.printf("<option value='%d'>%s</option>\n",
				dvo.getDeptno(), dvo.getDname());
  				*/
  			});
  			
  			
  		} else{
  			
  		}
  	%>
  </select> --%>
 
</div>
<script>
</script>
</body>
</html>