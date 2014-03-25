<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<title>ProposalStatus</title>
</head>
<body>
<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Status</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${psList}" var="ps">
			<tr>
				<td>${ps.id}</td>
				<td>${ps.status}</td>
			</tr>
		</c:forEach>
		
		
	</tbody>
</table>

</body>
</html>