<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="//cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="//cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
</head>
<body>
	
	<table id="myTable" class="display" style="width:100%">
        <thead>
            <tr>
            	<th></th>
                <th>Title</th>
                <th>Writer</th>
                <th>작성일..</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
           <c:forEach var="i" items="${list }">
            <tr>
               <td>${i.seq }</td>
                <td><a href="/board/detail?seq=${i.seq }">${i.writer }</a></td>
                <td>${i.writer }</td>
                <td>${i.write_date }</td>
                <th>${i.view_content }</th>
            </tr>
            </c:forEach>
          	
        </tbody>
       
    </table>
    <button id="write">글쓰기..</button>
    <script>
    /* $("#myTable").ready(function() {
        $('table.display').DataTable();
    } ); */
    $(document).ready( function () {
        $('#myTable').DataTable();
    } );
    $("#write").on("click",function(){
    	location.href="/board/toWrite";
    });
    
</script>
    
   
</body>
</html>