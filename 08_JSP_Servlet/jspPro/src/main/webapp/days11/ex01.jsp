<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2026. 8. 19. 오전 9:02:47</title>
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
   	Ajax 예제, 파일업로드 + Ajax
  </xmp>
  
    <h2>회원 가입 페이지</h2>
  
  <form>
    deptno : <input type="text" name="deptno" value="10" /><br>
    empno(id) : <input type="text" name="empno" value="7369" />
    <input type="button" id="btnEmpnoCheck" value="ID 중복체크 - jquery ajax">
    <p id="notice"></p>
    <br>
    ename : <input type="text" name="ename" /><br>
    job : <input type="text" name="job" value="" /><br>   
    :
    <br>
    <input type="submit" value="회원(emp) 가입">
  </form>
  
</div>
<script>
	$(function(){
		
		let idcheck;
		$("#btnEmpnoCheck").on("click",function(){
			
			// let params = $("form").serialize();
			
			const empno = $("input[name=empno]").val();
			$.ajax({
				url: "ex01_idcheck.jsp"
					, type: "GET"
					, data: {empno: empno }
					// , data: params 많은 파라미터를 가지고 요청
					, cache: false
					, dataType: "json"	
					, success: function (data, textStatus, jqXHR){
						// alert(data);
						if(data.count == 1){
							$("#notice").css("color","red").text("이미 사용 중인 ID 입니다.");
						} else{
							$("#notice").css("color","green").text("사용 가능한 ID 입니다.");
							idcheck = true;
						}
					}, error: function(){
						alert("Ajax 에러 발생~");
					}
			});
		});
	});
</script>
</body>
</html>