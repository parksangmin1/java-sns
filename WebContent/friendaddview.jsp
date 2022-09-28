<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>friendaddview.jsp</title>
</head>
<body>
<%@ include file="./fix/Header.jsp" %>
	<form action="friendsaddlist" method="post">
		<h3>유저 아이디</h3>
		<c:forEach items="${requestScope.id}" var="friend">
				  <tr>
			  		<td><input name = "userId" type="checkbox" value="${friend}">친구 아이디 :${friend}<br><td/>
			   	<tr/>
		</c:forEach>
			<input type="submit" name = "add" value="친구 추가">
	</form>
	<%@ include file="./fix/Footer.jsp" %>	
</body>
</html>