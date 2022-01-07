<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

$(function(){
    $("#id").on("blur",function(){
       $.ajax({
          url:"/member/idDuplCheck",
          data:{id:$("#id").val()}
       }).done(function(resp){
            if(resp == 1){
                $("#checkResult").css("color","pink");
               $("#checkResult").text($("#id").val() + " 는 이미 사용중인 ID 입니다.");
               $("#id").val("");
               $("#id").focus();
            }else{
               $("#checkResult").css("color","dodgerblue");
               $("#checkResult").text("사용 가능한 ID 입니다.");
            }   
       });
     })
 })
</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
 <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <link rel="stylesheet" href="/resources/css/style.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="/member/joinProc" method=post>
  <div class="form-group">
    <label for="uname">ID:</label>
    <input type="text" class="form-control" id="id" placeholder="Enter id" name="id" required><button type="button" id ="checkResult" class="btn btn-primary">중복확인</button>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  
  <div class="form-group">
    <label for="pw">Password:</label>
    <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw" required>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  
  <div class="form-group">
    <label for="name">Name:</label>
    <input type="text" class="form-control" id="pwd" placeholder="Enter name" name="name" required>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  
  <div class="form-group">
    <label for="phone">Phone Number:</label>
    <input type="text" class="form-control" id="phone" placeholder="Enter phone number" name="phone" required>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  
  <div class="form-group">
    <label for="email">Email:</label>
    <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" required>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  
  <div class="form-group">
    <label for="zipcode">Zipcode:</label>
    <input type="text" class="form-control" id="zipcode" placeholder="Enter zipcode" name="zipcode" required>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  
  
  
  <div class="form-group">
    <label for="address1">Address1:</label>
    <input type="text" class="form-control" id="address1" placeholder="Enter address" name="address1" required>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  
  <div class="form-group">
    <label for="address2">Address2:</label>
    <input type="text" class="form-control" id="address2" placeholder="Enter address" name="address2" required>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</body>
</html>