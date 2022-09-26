<%@page import="user.UserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="user.User"%>
<%@page import="util.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Friends List</title>
</head>
<body>
	<form action="friendslist" method="post" >
		<h3>친구추가 리스트</h3>
		<%ArrayList<User> users = UserDAO.getAllUser();
			session.setAttribute("users", users);
		%>
		<c:forEach items="${sessionScope.users}" var="friend">
			  	<tr>
		  			<td><input name = "test" type="checkbox" value="${friend.id}">ID : ${friend.id}<br><td/>
		   		<tr/>
		</c:forEach>
		<input type="submit" name = "add" value="친구 추가">
		<input type="button" value="되돌아가기" onclick="boardList.jsp'">
	</form>
</body>
</html>