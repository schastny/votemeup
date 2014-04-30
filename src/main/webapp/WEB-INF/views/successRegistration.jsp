
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="true"%>


<!DOCTYPE html>
<html>
<head>
<title>Регистрация</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">

<style media="screen" type="text/css">
.spacer {
	margin-bottom: 5px;
}
</style>

</head>
<body>

	<div class="container">

		<jsp:include page="header.jsp" />

		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="/voteme/">Главная</a></li>
						<li><a href="/voteme/about">О проекте</a></li>
						<li><a href="/voteme/contact">Контакты</a></li>
						<li><a href="/voteme/help">Помощь</a></li>
					</ul>
					<form class="navbar-form navbar-right" role="search">
						<div class="form-group">
							<input type="text" class="form-control"
								placeholder="Поиск инициатив...">
						</div>
						<button type="submit" class="btn btn-default">Поиск</button>
					</form>

				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		<!-- Inform from contacts -->
		<div class="row">
			<div class="col-sm-9">
				<div class="row">

					<h3>
						<p>Поздравляем!Вы успешно прошли регистрацию.</p>
						<p>Используйте свой логин и пароль для входа в систему.</p>
					</h3>

				</div>
			</div>
			<!--/span-->
			<div class="col-sm-3" role="navigation">
				<jsp:include page="loginForm.jsp" />
			</div>
			<!--/span-->
		</div>
		<!--/row-->
		<hr>
		<footer>
			<p>© Sv-051Company 2014</p>
		</footer>

	</div>
	<!--/.container-->



	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<c:url value="/resources/js/jquery-2.1.0.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>
