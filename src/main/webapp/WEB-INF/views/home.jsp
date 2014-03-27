%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1> 
	Hello world!
</h1>
${controllerMessage}

<br/>
<a href="about">Страница ABOUT!!!</a>

<h2>List of Categories</h2>
<table>
	<tr>
		<th>ID</th>
		<th>Text</th>
	</tr>
	<c:forEach items="${catList}" var="userVar" >
	<tr>
		<td>${userVar.categId}</td>
		<td>${userVar.categName}</td>
	</tr>
	</c:forEach>
</table><br><br>

<h2>List of Cities</h2>
<table>
	<tr>
		<th>ID</th>
		<th>Text</th>
	</tr>
	<c:forEach items="${cityList}" var="userVar" >
	<tr>
		<td>${userVar.cityId}</td>
		<td>${userVar.cityName}</td>
	</tr>
	</c:forEach>
</table>




</body>
</html>
