<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>
<body>
	<div class="container">
  <form action="/board/writeProc" method="post">
    <div class="form-group">
      <input type="text" name="title"  class="form-control" value= ${dto.title } id="title" readOnly>
    </div>
	<input type="text" name="writer" value="${loginID }">
    <div class="form-group">
      <textarea name="contents" class="form-control summernote" rows="5" id="content" readOnly>${dto.contents }</textarea>
    </div>
     <button type="submit" id="btn-save" class="btn btn-primary">submit</button>
  </form> 
  </div>
  
  <div>
  	 <c:forEach var="f" items="${files }">
  	 	<a href="/file/download?oriName=${f.oriname }&sysName=${f.sysname }">${f.oriname }</a>
  	 </c:forEach>
  </div>
  
  <div>
  	<c:if test="${loginID == dto.writer}">
  	<form action=/board/deleteDetail method="post">
  			<input type="hidden" value="${dto.seq }"/>
  		 <button type="submit" id="btn-delete" class="btn btn-primary">delete</button>
  		 </form>
  		 <a href="/board/toEdit?seq=${dto.seq }"><button class="btn btn-primary">Edit</button></a>
  	</c:if>
  	</div>



</body>
</html>