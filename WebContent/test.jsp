<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="board" method="post">
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
								<button type="submit" class="btn btn-info" name="like" onclick="likeClick()" value="1">좋아요</button>
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
				axios.response.get("localhost:8080/project/boardlist")
			
			}
		</script>
		
		
		
	</c:forEach>	
		
		
	</form>
</body>
</html>