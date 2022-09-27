<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.DBUtil, board.*, java.util.ArrayList" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList</title>
<link href="BoardList.css" rel="stylesheet" type="text/css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
		<input type="button" value="글쓰기" onclick="location.href='boardwrite'">
		<input type="button" value="친구 추가" onclick="location.href='friendfindlist.jsp'">
		<input type="button"" value="친구 리스트" onclick="location.href='friendfindlist.jsp'">
	<c:forEach items="${boardList}" var="board">
		<div class="container">
		  <div class="post-card">
		    <div class="post-card__content">
		      <div class="post-card__info">
		        <h1>${board.title}</h1>
		        <p>${board.userId}</p>
		        <p>${board.text}</p>
		        <form action="boarddelete" method="post">
		        	<button type="submit" class="btn btn-info">삭제</button>
					<input type="hidden" value="${board.boardId}" name="boardId">   
					<input type="hidden" value="${board.userId}" name="userId">   
				</form>
		      </div>
		    </div>
		    <div class="post-card__img" id="post-card__img">
		      <div class="post-card__social">
		        <ul>
		          <li>
		            <a href="#"><i class="ion ion-chatbox"></i>
			            <span>
				            <form action="boardupdate" method="post">
				            <button type="submit" class="btn btn-info">수정</button>
							<input type="hidden" value="${board.boardId}" name="boardId">   
							<input type="hidden" value="${board.userId}" name="userId">
							<input type="hidden" value="${board.title}" name="title">
							<input type="hidden" value="${board.text}" name="text">
						</form>
						</span></a>
		          </li>
		          <li>
		            <a><i class="ion ion-heart"></i>
		            	<span>
							<form action="boardlike" method="post" name="requestForm">
							<script>
							function like(){
							      document.requestForm.like.value ="false";
							      document.requestForm.submit();
							}
					          </script>
								<button type="button" class="btn btn-info" name="like" onclick="likeClick()">좋아요</button>
								<input type="hidden" value="${board.boardId}" name="boardId">
								<input type="hidden" value="${board.userId}" name="userId">
							</form>
						</span>
					</a>
		          </li>
		        </ul>
		      </div>
		    </div>
		  </div>
		</div>
		<script type="text/javascript">
			function likeClick(){
				alert("좋아요! 기능은 없습니다~");
				axios.get("http://localhost:8080/sns_project/boardlist");
				.then(res => console.log(res));
			}
		</script>
		
		
		
	</c:forEach>	
</body>
</html>