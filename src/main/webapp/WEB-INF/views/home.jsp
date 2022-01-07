<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
       <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
      <sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
</sec:authorize>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <link rel="stylesheet" href="/resources/css/style.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
	<body>
	<div class="container">
	<c:choose>
		<c:when test="${!empty principal}">
			
			<button id="toBoard" type="button" class="btn btn-primary">게시판..</button>
			<button id="logout" type="button" class="btn btn-primary">로그아웃..</button>
			<button id="mypage" type="button" class="btn btn-primary">마이페이지..</button>
			<button id="delete" type="button" class="btn btn-danger">회원탈퇴..</button>
			
			<script>
			
				$("#toBoard").on("click",function(){
					location.href="/board/list";
				})

				$("#logout").on("click",function(){
					location.href = "/logout";
				})
				
				$("#delete").on("click",function(){
					if(confirm("")){
						location.href="/member/deleteAccount";
					}
				})
				
				$("#mypage").on("click",function(){
					location.href ="/member/mypage";
				})
		
				$("#chat").on("click",function(){
					location.href ="/chat";
				})
   
			</script>
		</c:when>
		<c:otherwise>
					<form action="/login" method="post">
				<div class="form-group">
				  <label for="usr">ID:</label>
				  <input type="text" class="form-control" id="id" name="id">
			</div>
				<div class="form-group">
					<label for="pw">Password:</label>
					<input type="password" class="form-control" id="pw" name="pw">
				</div>
				<button type="submit" class="btn btn-primary" id="login">Login</button>
				<button type="button" class="btn btn-primary" id="join">Sign Up</button>
				</form>
		</c:otherwise>
	</c:choose>
	</div>
	<br>
	<div class="card">
  		<div class="card-body"><img src="resources/img/1.jpeg"><img src="resources/img/오일남.jpeg"></div>
	</div>
	<script type="text/javascript">
		$("#join").on("click",function(){
			location.href = "/member/join";
		})
		
		
	</script>
	</body>
</html>