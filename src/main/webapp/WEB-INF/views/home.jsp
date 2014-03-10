<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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




<h2>List of Proposals</h2>
	<table>
		<tr>
			<th>ID</th>
			<th>Text</th>
		</tr>
		<c:forEach items="${list}" var="userVar" >
		<tr>
			<td>${userVar.proposalId}</td>
			<td>${userVar.proposalName}</td>
		</tr>
		</c:forEach>
	</table>






</body>
</html>
