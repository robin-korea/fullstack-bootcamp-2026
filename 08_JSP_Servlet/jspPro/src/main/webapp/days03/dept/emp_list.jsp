<%@page import="java.util.Iterator"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.util.DBConn"%>
<%@page import="org.doit.domain.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int deptno = Integer.parseInt(request.getParameter("deptno"));	
	
	Connection conn = null;
	PreparedStatement pstmt = null; 
	ResultSet  rs   = null; 
	ArrayList<EmpVO> list = null;
	EmpVO vo = null;
	Iterator<EmpVO> ir = null;
	
	conn = DBConn.getConnection();
	
	String sql = """
			SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
			FROM emp
			WHERE deptno = %d
			ORDER BY deptno ASC
			""".formatted( deptno );
	try {
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        
        int empno, mgr;
        double sal, comm;
        String ename, job;
        LocalDateTime hiredate;
        
        if (rs.next()) { 
            list = new ArrayList<EmpVO>();
            do {
                empno = rs.getInt("empno");
                ename = rs.getString("ename");
                job = rs.getString("job");
                mgr = rs.getInt("mgr");
                hiredate = rs.getDate("hiredate").toLocalDate().atStartOfDay();
                sal = rs.getDouble("sal");
                comm = rs.getDouble("comm");
                deptno = rs.getInt("deptno");
                
                vo = EmpVO.builder()
                        .empno(empno)
                        .ename(ename)
                        .job(job)
                        .mgr(mgr)
                        .hiredate(hiredate)
                        .sal(sal)
                        .comm(comm)
                        .deptno(deptno)
                        .build();
                
                list.add(vo);
            } while (rs.next());
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
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
<title>2026. 8. 4. 오후 3:51:50</title>
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
  	<%
  		if(list!= null && !list.isEmpty()){
  			for (EmpVO evo : list){
  	%>
  	<tr>
  		<td><%= evo.getEmpno() %></td>
  		<td><%= evo.getEname() %></td>
  		<td><%= evo.getJob() %></td>
  		<td><%= evo.getMgr() %></td>
  		<td><%= evo.getHiredate().toLocalDate() %></td>
  		<td><%= evo.getSal() %></td>
  		<td><%= evo.getComm() %></td>
  		<td><%= evo.getDeptno() %></td>
  	</tr>
  	<% 
  			}
  		}
  	%>
  	</tbody>
  	<tfoot>
  		<tr>
  			<td colspan="8">
  				<span class="badge left red"><%= list == null ? 0 : list.size() %>명</span>
  				<a href="javascript:history.back()">뒤로 가기</a>
  			</td>
  		</tr>
  	</tfoot>
  </table>
</div>
<script>
</script>
</body>
</html>