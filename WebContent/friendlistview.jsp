<%@page import="friendslist.FriendDAO"%>
<%@page import="friendslist.FriendsDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="util.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>friendlistview.jsp</title>
</head>
<body>
<%@ include file="./fix/Header.jsp" %>
		<h2>친구 리스트</h2>
		
		<c:forEach items="${friendList}" var="friend">
			  	<tr>
			  		<td>아이디 : ${friend}<td/>
			  		<br><br>
		   		<tr/>
		</c:forEach>
		
</body>
</html>