<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 8. 13. 오전 11:17:42</title>
<link rel="shortcut icon" type="image/x-icon" href="/images/SiSt.ico">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> -->
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>

<link rel="stylesheet" href="https://code.jquery.com/ui/1.14.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://jqueryui.com/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://code.jquery.com/ui/1.14.1/jquery-ui.js"></script>


</head>
<body>
<header>
  <h1 class="main"><a href="#" style="position: absolute;top:30px;">My Home</a></h1>
  <ul>
    <c:choose>
      <c:when test="${empty sessionScope.authUser}">
        <li><a href="${pageContext.request.contextPath}/mvc/member/login.htm">로그인</a></li>
        <li><a href="#">회원가입</a></li>
      </c:when>
      <c:otherwise>
        <li><b>[${sessionScope.authUser.loginUser}]</b>님 (${sessionScope.authUser.loginUserRole})</li>
        <li><a href="${pageContext.request.contextPath}/mvc/member/logout.htm">로그아웃</a></li>
      </c:otherwise>
    </c:choose>
  </ul>
</header>
<div>
  <xmp class="code">
   	view.jsp
  </xmp>
  
  <h3>Board 상세보기</h3>
  
  <table>
  	<thead></thead>
  	<tbody>
  		<tr>
  			<th>이름</th>
  			<td>${dto.writer }</td>
  			<th>등록일</th>
  			<td>${dto.writedate }</td>
  		</tr>
  		<tr>
  			<th>Email</th>
  			<td>${dto.email }</td>
  			<th>조회수</th>
  			<td>${dto.readed }</td>
  		</tr>
  		<tr>
  			<th>제목</th>
  			<td colspan="3">${dto.title }</td>
  		</tr>
  		<tr>
  			<th>내용</th>
  			<td colspan="3" class="full" style="height:200px; vertical-align: top">${dto.content}</td>
  		</tr>
  	</tbody>
  	<tfoot>
  		<tr>
  			<td colspan="4" align="center">
  				<c:if test = "${not empty sessionScope.authUser and (sessionScope.authUser.loginUser eq dto.writer or sessionScope.authUser.loginUserRole eq 'ADMIN')}">
  					<a href="${pageContext.request.contextPath}/mvc/board/edit.htm?seq=${dto.seq}&currentPage=${param.currentPage}&searchCondition=${param.searchCondition}&searchKeyword=${param.searchKeyword}">수정</a>
  					<a href="${pageContext.request.contextPath}/mvc/board/delete.htm?seq=${dto.seq}&currentPage=${param.currentPage}&searchCondition=${param.searchCondition}&searchKeyword=${param.searchKeyword}">삭제</a>
  					<input type="button" id = "btnModalDelete" value="모달창 삭제">
  				</c:if>
  				<a href="${pageContext.request.contextPath}/mvc/board/list.htm?currentPage=${param.currentPage}&searchCondition=${param.searchCondition}&searchKeyword=${param.searchKeyword}">목록</a>
  			</td>
  		</tr>
  	</tfoot>
  </table>
</div>

<!-- 삭제 모달창 -->
<div id="dialog-form" title="삭제 모달창">
  <h3>Board 삭제</h3>
  
  <form action="${pageContext.request.contextPath}/mvc/board/delete.htm?seq=${param.seq}" method="post">
  	<table>
  	  <tr>
         <td colspan="2" align="center"><b>글을 삭제합니다.</b></td>
      </tr>
      <tr>
         <td align="center">비밀번호</td>
         <td><input type="password" name="pwd" size="15" required="required"></td>
      </tr>
      <tr>
         <td colspan="2" align="center">
            <input type="submit" value="삭제"> &nbsp;&nbsp;&nbsp; 
            <input type="button" value="취소" id="cancel">
      </tr>
  	</table>
  	<span style="color:red; display:none" id="spn">비밀번호가 잘못되었습니다.</span>
  </form>
</div>

<script>
	var dialog, form;
	dialog = $( "#dialog-form" ).dialog({
    	autoOpen: false,
    	height: 400,
    	width: 350,
    	modal: true,
    	buttons: {
   	 	},
    	close: function() {
      	form[ 0 ].reset();
    	}
  	}); 
	
	form = dialog.find("form");
	
	$("#btnModalDelete").on("click",function(){
		dialog.dialog("open");
	});
	
	$("#cancel").on("click",function(){
		dialog.dialog("close");
	});
	
	// 모달창을 띄워서 삭제가 실패하고 온 경우
</script>
</body>
</html>