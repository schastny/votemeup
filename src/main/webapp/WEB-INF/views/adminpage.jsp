<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1> 
	Hello, this is AdminPage.
</h1>
<p>Пользователь: ${user.firstName} ${user.lastName}</p>
<p>Логин: ${user.userLogin}</p>
<p>Роль: ${user.role.roleName}</p>
<p><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></p>
<p><a href="<c:url value="/"/>">Назад</a></p>
</body>
</html>