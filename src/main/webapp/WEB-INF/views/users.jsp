<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>List of users</title>
</head>
 
<body>
    <h1>List of users</h1>     
     
    <table>
        <tr>
            <th>ID</th>
            <th>Username</th>
        </tr>
         
        <c:forEach items="${users}" var="userVar">
         
        <tr>
            <td>${userVar.userdId}</td>
            <td>${userVar.firstName}</td>
        </tr>
         
        </c:forEach>
         
    </table>
 
</body>
</html>
