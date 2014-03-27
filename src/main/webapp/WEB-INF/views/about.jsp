<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<title>Insert title here</title>
</head>
<body>
<h2>${controllerMessage}</h2>

Это страница About !!!!

<br/>
<a href="home">Страница HOME!!!</a>
<br/>

<br/>
<a href="ps">Страница ProposalStatus!!!</a>
<br/>


<h2>Список Регионов</h2>
<table>
	<tr>
		<th>ID</th>
		<th>Text</th>
	</tr>
	<c:forEach items="${regList}" var="userVar" >
	<tr>
		<td>${userVar.regionId}</td>
		<td>${userVar.regionName}</td>
	</tr>
	</c:forEach>
</table><br><br>


</body>
</html>