<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page session="true"%>


<!DOCTYPE html>
<html>
<head>
<title>Общественная инициатива</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/style.css" />">


</head>
<body>
	<div class="container">

		<div class="row page-header">
			<div class="pull-left">
				<h1>
					Общественная инициатива<br> <small>Всего инициатив:
						${gpModel.propCount} </small>
				</h1>
			</div>
			<div class="pull-right">
				<p>
					
				</p>
			</div>
		</div> 
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="/voteme/">Главная</a></li>
						
						<li  class="active"><a href="/voteme/admin/">
									Пользователи</a></li>
						<li><a href="/voteme/about">О проекте</a></li>
						<li><a href="/voteme/contact">Контакты</a></li>
						<li><a href="/voteme/help">Помощь</a></li>
					</ul>
					<p class="navbar-text navbar-right">Вы вошли как ${user.userLogin}
						<a href="<c:url value="/j_spring_security_logout"/>" 
							class="navbar-link">Выход</a></p>
					
					

				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	 	<div class="row-fluid">
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th>ID</th>
						<th>Логин</th>
						<th>E-mail</th>
						<th>Страна</th>
						<th>Регион</th>
						<th>Роль</th>
						<th>Дата регистрации</th>
						<th>Предл-й</th>
						<th>Комм-в</th>
						<th>Статус</th>
						<th>Действия</th>
					</tr>
				</thead>
				<tbody>
				<tr class="list-users">
					<td>1</td>
					<td>Admin</td>
					<td>travis@provider.com</td>
					<td>Россия</td>
					<td>Крым</td>
					<td>ROLE_ADMIN</td>
					<td>2029.43.28.4320849</td>
					<td>2</td>
					<td>4</td>
					<td>Active</td>
					<td>
						<div class="btn-group btn-group-xs">
							<button type="button" class="btn btn-default">
								<span class="glyphicon glyphicon-eye-open"></span>
							</button>
  							<button type="button" class="btn btn-default">
  								<span class="glyphicon glyphicon-pencil"></span>
  							</button>
  							<button type="button" class="btn btn-default">
  								<span class="glyphicon glyphicon-trash"></span>
  							</button>
						</div>
					</td>
				 </tr>
				</tbody>
			</table>	
			
			
			
			
			<div id="sidebar"></div>

			<div id="content">
			    <h1>Welcome to Backbone</h1>
			</div>
			
			
			
			
<!-- 			<div >
				<ul class="pagination">
					<li><a href="#">Prev</a></li>
					<li class="active">
						<a href="#">1</a>
					</li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">Next</a></li>
				</ul>
			</div> -->
			<hr>
			<footer>
				<p>© Sv-051Company 2014</p>
			</footer>
		</div>
		<!--/row-->

	</div>
	<!--/.container-->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<script src="<c:url value="/resources/js/jquery-2.1.0.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/backbone-min.js" />"></script>
	<script src="<c:url value="/resources/js/underscore-min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/adminpage.js" />"></script>
</body>
</html>