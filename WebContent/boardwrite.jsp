<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="./fix/Header.jsp" %>
	<br><br><br><br>
	<form action="boardwrite" method="post">
	<div style="margin-left:100px;">
		<div class="xs-3">
		  <label for="exampleFormControlInput1" class="form-label">제목을 입력하세요.</label>
		  <input type="text" name="title" style="width:500px;" class="form-control" id="exampleFormControlInput1" placeholder="title">
		</div>
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">내용을 입력하세요.</label>
		  <textarea class="form-control" style="width:500px;" name="text" id="exampleFormControlTextarea1" rows="3"></textarea>
		</div>
		<button type="submit" class="btn btn-outline-success">작성</button>
	</form>
	</div>
	<%@ include file="./fix/Footer.jsp" %>	
</body>
</html>