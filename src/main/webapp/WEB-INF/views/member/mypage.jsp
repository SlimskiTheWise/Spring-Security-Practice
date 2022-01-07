<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

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
	<form action="/member/updateProc" method=post>
	<c:forEach var="m" items="${member }">
  <div class="form-group">
    <label for="uname">ID:</label>
    <input type="text" class="form-control" id="id" value=${m.id } name="id" readOnly>
  </div>
  
  <div class="form-group">
    <label for="pw">Password:</label>
    <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw" required>
   
  </div>
  
  <div class="form-group">
    <label for="name">Name:</label>
    <input type="text" class="form-control" id="pwd"  value=${m.name } name="name" required>
   
  </div>
  
  <div class="form-group">
    <label for="phone">Phone Number:</label>
    <input type="text" class="form-control" id="phone"  value=${m.phone } name="phone" required>
    
  </div>
  
  <div class="form-group">
    <label for="email">Email:</label>
    <input type="text" class="form-control" id="email"  value=${m.email } name="email" required>
    
  </div>
  
  <div class="form-group">
    <label for="zipcode">Zipcode:</label>
    <input type="text" class="form-control" id="zipcode"  value=${m.zipcode } name="zipcode" required>
    
  </div>
  
  
  
  <div class="form-group">
    <label for="address1">Address1:</label>
    <input type="text" class="form-control" id="address1"  value=${m.address1 } name="address1" required>
    
  </div>
  
  <div class="form-group">
    <label for="address2">Address2:</label>
    <input type="text" class="form-control" id="address2"  value=${m.address2 } name="address2" required>
    
  </div>
  </c:forEach>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</body>
</html>