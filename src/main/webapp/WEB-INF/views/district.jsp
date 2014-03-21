<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List of district</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("tr").mouseenter(function(){
			$(this).fadeTo('fast', 1);
	        $(this).css('font-weight', 'bold');
	        $(this).css('color', 'red');
		});
		
		$("tr").mouseleave(function(){
			$(this).fadeTo('fast', 1);
	        $(this).css('font-weight', 'normal');
	        $(this).css('color', 'black');
		});	
		
		
		$("h1").mouseenter(function(){
	        $(this).css('font-weight', 'bold');
	        $(this).css('color', 'red');
		});
		
		$("h1").mouseleave(function(){
	        $(this).css('font-weight', 'normal');
	        $(this).css('color', 'black');
		});	
		
		$("#div").mouseenter(function(){
			$(this).fadeTo('fast', 0.5);
		});	
		$("#div").mouseleave(function(){
			$(this).fadeTo('fast', 1);
		});	
   
	});
</script>

<style>
h1 {
	text-align: center;
}
div{
width: 300px; 
position: relative; 
left: 500px; 
}
</style>

</head>

<body>
<div id ="div">
	<h1>List of district</h1>

		<table border="1" align="center">
			<tr>
				<th>Id</th>
				<th>District</th>
			</tr>

			<c:forEach items="${district}" var="district">
				<tr>
					<td>${district.districtId}</td>
					<td>${district.districtName}</td>
				</tr>
			</c:forEach>

		</table>
		</div>
		
</body>
</html>


