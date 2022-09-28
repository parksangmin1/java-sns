<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="./fix/Header.jsp" %>
	좋아요 누른 사용자
	<c:forEach items="${likeList}" var="like" >
		${like.userId}
	</c:forEach>
	<%@ include file="./fix/Footer.jsp" %>		
</body>
</html>