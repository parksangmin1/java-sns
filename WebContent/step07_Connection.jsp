<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.DBUtil, user.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ConnectionTest</title>
</head>
<body>
	
	<%-- DB 연결 테스트 --%>
	<%
		out.println(DBUtil.getConnection());
		out.println(user.UserDAO.getAllUser());
	%>



</body>
</html>