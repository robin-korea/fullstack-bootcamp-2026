<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 8. 12. 오후 5:35:01</title>
<link rel="shortcut icon" type="image/x-icon" href="/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
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
    list.jsp
  </xmp>
  	
<h3><a href="${pageContext.request.contextPath}/mvc/board/list.htm">Board 목록</a></h3>
  
  <table>
  	<caption style="text-align: right">
  		<a href="${pageContext.request.contextPath}${empty sessionScope.authUser ? '/mvc/member/login.htm' : '/mvc/board/write.htm'}">글쓰기</a>
  	</caption>
  	<thead>
  		<tr>
	  		<th width="10%">번호</th>
	  		<th width="45%">제목</th>
	  		<th width="17%">작성자</th>
	  		<th width="20%">등록일</th>
	  		<th width="10%">조회</th>
  		</tr>
  	</thead>
  	<tbody>
  		<c:choose>
  			<c:when test="${empty list}">
  				<tr>
  					<td colspan="5">
  						등록된 게시글이 없습니다.
  					</td>
  				</tr>
  			</c:when>
  			<c:otherwise>
  				<c:forEach items="${ list }" var="dto">
	  				<tr>
	  					<td>${ dto.seq }</td>
	  					<td>
	  						<a href="${pageContext.request.contextPath}/mvc/board/view.htm?seq=${dto.seq}&currentPage=${empty param.currentPage ? 1 : param.currentPage}&searchCondition=${param.searchCondition}&searchKeyword=${param.searchKeyword}">${ dto.title }</a>
	  					</td>
	  					<td>${ dto.writer }</td>
	  					<td>${ dto.writedate }</td>
	  					<td>${ dto.readed }</td>
	  				</tr>
  				</c:forEach>
  			</c:otherwise>
  		</c:choose>
  	</tbody>
  	<tfoot>
  		<tr>
  			<td colspan="5" align="center">
  				<div class = "pagination">
  					<c:if test="${ pDto.prev }">
  						<a href="${ pDto.startPage-1 }">&lt;</a>
  					</c:if>
  					<c:forEach begin="${ pDto.startPage }" end="${ pDto.endPage }" step="1" var="i">
  						<a href="${i}" class="${ i == (empty param.currentPage ? 1 : param.currentPage)?'active':''}">${i}</a>
  					</c:forEach> 
  					<c:if test="${ pDto.next }">
  						<a href="${ pDto.endPage+1 }">&gt;</a>
  					</c:if>
  				</div>
  			</td>
  		</tr>
  		<tr>
  			<td colspan="5" align="center">
  				<form>
  					<select name="searchCondition" id="searchCondition">
  						
  						<option value="t">Title</option>
  						<option value="c">Content</option>
  						<option value="w">Writer</option>
  						<option value="tc">Title+Content</option>
  						
  					</select>
  					<script>
  						$("#searchCondition").val("${empty param.searchCondition ? 't' : param.searchCondition}")
  					</script>
  					<input type="text" name="searchKeyword" id="searchKeyword" value="${param.searchKeyword}">
  					<input type="submit" value="검색">
  				</form>
  			</td>
  		</tr>
  	</tfoot>
  </table>
</div>
<script>
	$(".pagination a:not(.active)").attr("href", function(index, oldHref){
		return `${pageContext.request.contextPath}/mvc/board/list.htm?currentPage=\${oldHref}&numberPerPage=${empty param.numberPerPage ? 10 : param.numberPerPage}&searchCondition=${param.searchCondition}&searchKeyword=${param.searchKeyword}`;      
	});
	
	$(".pagination a.active").removeAttr("href");
</script>
</body>
</html>