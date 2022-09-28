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
<%@ include file="./fix/Header.jsp" %>
	<form action="friendsfindlist" method="post" >
		<h3>친구추가 리스트</h3>
		<input type="text" name="names" placeholder="이름을 검색해 주세요">
		<input type="submit" value="검색">
		<br>
	</form>
	
	<form action="friendsaddlist" method="post">
		<%ArrayList<User> users = UserDAO.getAllUser();
			session.setAttribute("users", users);
		%>
		<c:forEach items="${sessionScope.users}" var="friend">
			  	<tr>
		  			<td><input name = "userId" type="checkbox" value="${friend.id}">이름 :${friend.name} - 아이디 : ${friend.id}<br><br><td/>
		   		<tr/>
		</c:forEach>
			<input type="submit" name = "add" value="친구 추가">
		<input type="button" value="되돌아가기" onclick="'boardList.jsp'">

	</form>
	<%@ include file="./fix/Footer.jsp" %>	
</body>
</html>