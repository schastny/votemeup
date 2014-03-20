<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>List of users</title>
	
	<style>
		table,th,td {
			border:2px solid black;
			border-collapse:collapse;
		}
		th,td {
		padding:5px;
		}
	</style>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	
	<script>
		$(document).ready(function(){
  			$("tr").hover(
  				function(){
  					$(this).addClass("important");
  		    	},
  		    	function(){
  		    		$(this).removeClass("important");
  		  		}
  		    ); 
		});
	</script>

	<style>
		.important
		{
			font-weight: bold;
			background-color: #FFFFCC;
		}
		.center
		{
			text-align:center;
		}
	
	</style>

	
</head>
 
<body>
    <h1 class="center">List of users</h1>     

    <table>
        <tr class="center">
            <th>Id</th>
            <th>Login</th>
            <th>Password</th>
            <th>E-mail</th>
            <th>Registration date</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Sex</th>            
            <th>Birth year</th>            
        </tr>
         
        <c:forEach items="${users}" var="user">
         
        <tr class="center">
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>${user.registrationDate}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td> 
            <td>${user.sex}</td>
            <td>${user.birthYear}</td> 
                   
        </tr>
         
        </c:forEach>
         
    </table>
        
	
 
</body>
</html>

