
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
<meta http-equiv="Content-type" content="text/html;charset=UTF-8" />
<!-- Bootstrap -->


<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css" />">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/bootstrapValidator.css" />">


<style media="screen" type="text/css">
.spacer {
	margin-bottom: 5px;
}

#loginError,#emailError {
	font-size: 12px;
}

.help-block {
	font-size: 12px;
	color: red;
}
</style>

<script type="text/javascript"
	src="<c:url value="/resources/js/lib/jquery-2.1.0.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/lib/bootstrap.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/lib/bootstrapValidator.js" />"></script>
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
				<h3>Регистрация нового пользователя:</h3>
				<br />
				<form role="form" id="contact-form" class="form-horizontal"
					method="POST" action="save">
					<div class="form-group">
						<div class="col-md-3">
							<label for="lastname">Имя :</label>
						</div>
						<div class="col-md-8">
							<input type="text" class="form-control" id="lastname"
								name="lastName" placeholder="Введите  имя...">
							<div>
								<p class="help-block">${lastNameError}</p>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-3">
							<label for="firstname">Фамилия :</label>
						</div>
						<div class="col-md-8">
							<input type="text" class="form-control" id="firstName"
								name="firstName" placeholder="Введите  фамилию...">
							<div>
								<p class="help-block">${firstNameError}</p>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-3">
							<label for="birth"> Год рождения : </label>
						</div>
						<div class="col-md-8">
							<!--  <div class="form-control">-->
							<select name="birthdate" id="birthdate" class="form-control">
								<option value="">--Выберите год рождения--</option>
								<c:forEach items="${yearList}" var="item">
									<option value="${item}">${item}</option>
								</c:forEach>
							</select>
							<div>
								<p class="help-block">${birthdateError}</p>
							</div>
						</div>

					</div>
					<div class="form-group">
						<div class="col-md-3">
							<label for="gender"> Укажите свой пол : </label>
						</div>
						<div class="col-md-8">
							<label class="radio"> <input type="radio" name="gender"
								id="gender" value="муж"> Мужской
							</label> <label class="radio"> <input type="radio" name="gender"
								id="gender" value="жен"> Женский
							</label>
							<div>
								<p class="help-block">${genderError}</p>
							</div>
						</div>

					</div>

					<div class="form-group">
						<div class="col-md-3">
							<label for="country"> Страна : </label>
						</div>
						<div class="col-md-8">
							<select name="country" id="country" class="form-control">
								<option value="">--Выберите страну--</option>
								<c:forEach items="${gpModel.countryList}" var="item">
									<option value="${item.countryId}"
										${item.countryId == regModel.selectedCountryId ? 'selected="selected"' : ''}>${item.countryName}</option>
								</c:forEach>
							</select>
							<div>
								<p class="help-block">${countryError}</p>
							</div>
						</div>
					</div>
					<!--  	<br /> <br /> -->
					<div class="form-group">
						<div class="col-md-3">
							<label for="userlogin">Логин :</label>
						</div>
						<div class="col-md-8">

							<input type="text" class="form-control" id="userLogin"
								name="userLogin" placeholder="Введите  логин..." /> <span
								id="span"></span>
							<div>
								<p id="loginError" class="help-block">${loginError}</p>
							</div>

						</div>
					</div>
					<div class="form-group">
						<div class="col-md-3">
							<label for="email">Е-mail :</label>
						</div>
						<div class="col-md-8">
							<input type="text" class="form-control" id="userEmail"
								name="userEmail" placeholder="Введите  e-mail адрес...">
							<!-- <span id="span2" class="glyphicon glyphicon-remove form-control-feedback"></span>-->
							<span id="span2"></span>
							<div>
								<p id="emailError" class="help-block">${emailError}</p>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-3">
							<label for="password">Пароль :</label>
						</div>
						<div class="col-md-8">
							<input type="password" class="form-control" id="password"
								name="password" name="password" placeholder="Введите  пароль...">
							<div>
								<p class="help-block">${passwordError}</p>
							</div>
						</div>
					</div>
					<!--  	<br /> <br />-->
					<div class="form-group">
						<div class="col-md-3">
							<label for="confirmPassword">Подтвердите пароль :</label>
						</div>
						<div class="col-md-8">
							<input type="password" class="form-control" id="confirmPassword"
								name="confirmPassword" placeholder="Подтвердите пароль...">
							<div>
								<p class="help-block">${confirmPasswordError}</p>
							</div>
						</div>
					</div>
					<br /> <br />
					<div class="row">
						<div class="col-md-10">
							<button type="submit" class="btn btn-default" id="validateBtn">Зарегистрироваться</button>
							<button type="reset" class="btn btn-default" id="resetBtn">Очистить
								форму</button>
						</div>
					</div>
				</form>

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
			<p>© Sv-051 Company 2014</p>
		</footer>
	</div>

	<!--/.container-->
	<script type="text/javascript"
		src="<c:url value="/resources/js/validate.js" />"></script>
</body>
</html>
