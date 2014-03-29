
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true"%>


<!DOCTYPE html>
<html>
<head>
<title>Общественная инициатива</title>
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
		<div class="row page-header">
			<div class="pull-left">
				<h1>
					Общественная инициатива<br> <small>Всего инициатив:
						${gpModel.propCount} </small>
				</h1>
				Session created: ${gpModel.creationDate} ${welcomeMes}
			</div>
			<div class="pull-right">
				<p>
					<button type="button" class="btn btn-primary btn-lg ">
						Опубликовать<br>инициативу
					</button>
				</p>
			</div>
		</div>

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
					<a class="navbar-brand" href="/voteme/">Главная</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="#">О проекте</a></li>
						<li><a href="#">Контакты</a></li>
						<li><a href="#">Помощь</a></li>
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

		<div class="row">
			<div class="col-sm-9">
				<div class="row">
					  	<ul class="nav nav-tabs">
						<li class="<c:if test="${tab == 1}">active</c:if>"> <a href="/voteme/?showType=all"  >Все</a></li>
						<li class="<c:if test="${tab == 2}">active</c:if>"><a href="/voteme/?showType=popular" >Популярные</a></li>
						<li class="<c:if test="${tab == 3}">active</c:if>"><a href="/voteme/?showType=last" >Последние</a></li>
						<li class="<c:if test="${tab == 4}">active</c:if>"><a href="/voteme/?showType=commented" >Комментируемые</a></li>
						<li class="pull-right disabled "><a href="#">Фильтр выкл.</a></li>
						<li class="dropdown pull-right"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"> Показывать по 10<span
								class="caret"></span>
						</a>											
							<ul class="dropdown-menu">
								<li><a href="#">Показывать по 10</a></li>
								<li><a href="#">Показывать по 25</a></li>
								<li><a href="#">Показывать по 50</a></li>
							</ul></li>
					</ul>
					


					<c:forEach items="${gpModel.proposalList}" var="tmpVar">
						<div class="panel panel-default spacer">
							<div class="panel-body">
								<p>${tmpVar.proposalName}</p>
								<p>
									<a class="pull-right" href="#" role="button">Подробнее»</a> <em
										class="pull-left">Количество голосов:
										${fn:length(tmpVar.votes)} </em>
								</p>
							</div>
						</div>
						<!--/span-->
					</c:forEach>
				</div>
				<!--/row-->
				<!-- Pagination -->
				<div>
					<ul class="pagination ">
						<li><a href="#">&laquo;</a></li>
						<li class="active"><a href="#">1</a></li>
						<li class="disabled"><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">&raquo;</a></li>
					</ul>
				</div>
			</div>
			<!--/span-->

			<div class="col-sm-3" role="navigation">

				<div class="well sidebar-nav">
					<form role="form" method="POST" action="login">
						<div class="form-group">
							<label for="exampleInputEmail1">Имя ${fNameMes}</label> <input
								type="text" name="name" class="form-control"
								id="exampleInputEmail1" placeholder="Введите имя">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Пароль ${fPassMes}</label> <input
								type="password" name="password" class="form-control"
								id="exampleInputPassword1" placeholder="Пароль">
						</div>
						<div class="checkbox">
							<label> <input type="checkbox"> Запомнить меня
							</label>
						</div>
						<button type="submit" class="btn btn-default">Войти</button>
						<a class="pull-right" href="#" role="button">Регистрация</a>
					</form>
				</div>
				<!--/.well -->
				<div class="well sidebar-nav">
					<form role="form" method="GET" action="filtr">
						<div>
							<p>Статус инициативы</p>
							<div class="radio">
								 <input type="radio" name="status"
									 value="1" checked> На
									голосовании
								</label>
							</div>
							<div class="radio">
								<label> <input type="radio" name="status"
									value="1"> Проверяется
								</label>
							</div>
							<div class="radio">
								<label> <input type="radio" name="status"
									 value="3"> Голосование
									окончено
								</label>
							</div>
						</div>
						<div>
							<p>Уровень</p>
							<select name=level class="form-control">
								<option>---Выберите уровень---</option>
								<option>Федеральный</option>
								<option>Региональный</option>
								<option>Муниципальный</option>
							</select>
						</div><br>
						<div>
							<p>Категория</p>
							<select class="form-control" name=category onchange="document.location=this.options[this.selectedIndex].value">
								<option >---Выберите категорию---</option>
								<c:forEach items="${gpModel.categoryList}" var="item">
									<option value="${item.categId}" ${item.categId == gpModel.selectedCategoryId ? 'selected="selected"' : ''}>${item.categName}</option>
								</c:forEach>

							</select>
						</div><br>
						<div>
							<p>Территориальное расположение</p>
							<p>
								<select name=state class="form-control">
									<option>---Государство---</option>
									<option>Россия</option>
									<option>Украина</option>
								</select> 
								<select name=region class="form-control">
									<option>---Регион---</option>
								</select name=city> <select class="form-control">
									<option>---Город---</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select>
								</select name=district> <select class="form-control">
									<option>---Район---</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select>
							</p>
						</div>
						<button type="submit" class="btn btn-default">Применить
							фильтр</button>
					</form>
					
				


				</div>
				<!--/.well -->
			</div>
			<!--/span-->
		</div>
		<!--/row-->

		<hr>



		<footer>
			<p>© BArygaCompany 2014</p>
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
