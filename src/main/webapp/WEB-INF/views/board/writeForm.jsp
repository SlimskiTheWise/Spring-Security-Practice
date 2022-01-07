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
  <form action="/board/writeProc" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <input type="text" name="title"  class="form-control" placeholder="Enter title" id="title">
    </div>
	<input type="hidden" name="writer" value="${loginID }">
    <div class="form-group">
      <textarea name="contents" class="form-control summernote" rows="5" id="content"></textarea>
    </div>
   <input class="form-control summernote" type="file" name="file" multiple>
     <button type="submit" id="btn-save" class="btn btn-primary">submit</button>
  </form> 
 
</div>

<script>
/*   $('.summernote').summernote({
    tabsize: 3,
    height: 300
  });
  
  var setting = {
          height : 300,
          minHeight : null,
          maxHeight : null,
          focus : true,
          lang : 'ko-KR',
          toolbar : toolbar,
          //콜백 함수
          callbacks : { 
          	onImageUpload : function(files, editor, welEditable) {
          // 파일 업로드(다중업로드를 위해 반복문 사용)
          for (var i = files.length - 1; i >= 0; i--) {
          uploadSummernoteImageFile(files[i],
          this);
          		}
          	}
          }
       };
      $('.summernote').summernote(setting);
      });
      
      function uploadSummernoteImageFile(file, el) {
			data = new FormData();
			data.append("file", file);
			$.ajax({
				data : data,
				type : "POST",
				url : "uploadSummernoteImageFile",
				contentType : false,
				enctype : 'multipart/form-data',
				processData : false,
				success : function(data) {
					$(el).summernote('editor.insertImage', data.url);
				}
			});
		} */
</script>

</body>
</html>