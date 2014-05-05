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

		<div class="row">
			<div class="col-sm-9">
				<c:set var="sizeComment" scope="session" value="${countComment}" />

				<h3>${proposalMore.proposalName}</h3>

				<div>
					<p>Инициатива № ${proposalMore.proposalId}</p>
				</div>

				<div>
					Уровень инициативы: <b>${proposalMore.proposalLevel.level}</b>
				</div>
				<div>
					Статус инициативы: <b>${proposalMore.proposalStatus.status}</b>
				</div>
				<div>
					Автор инициативы: <b>${proposalMore.userd.lastName}
						${proposalMore.userd.firstName}</b>
				</div>
				<div>
					<p>
						Дата создания инициативы:<b></b>
						<fmt:formatDate pattern="dd-MM-yyyy"
							value="${proposalMore.creationDate}" />
						</b>
					</p>
				</div>
				<div>
					<c:if test="${countCat > 0}">
						<b>Категории:</b>
						<c:forEach items="${categoryProposal}" var="tmpVar">
							<div>- ${tmpVar.categName}</div>
						</c:forEach>
					</c:if>
				</div>
				<br>

				<div>
					За инициативу подано: <b>${proposalMoreVoteYes}</b> голос(ов)
				</div>
				<div>
					Против инициативы подано: <b>${proposalMoreVoteNo}</b> голос(ов)
				</div>
				<div>
					<p>
						Количество комментариев: <b>${sizeComment}</b>
					</p>
				</div>


				<div>
					Страна: <b>${proposalMore.country.countryName}</b>
				</div>
				<div>
					Регион: <b>${proposalMore.region.regionName}</b>
				</div>
				<div>
					Город: <b>${proposalMore.city.cityName}</b>
				</div>
				<div>
					<p>
						Район: <b>${proposalMore.district.districtName}</b>
					</p>
				</div>

				<div>
					Количество документов: <b>${countDoc}</b>
				</div>

				<br>

				<div>

					<div class="proposal_text">${proposalMore.proposalText}</div>


					<h3>Практический результат</h3>

					<div class="proposal_text">${proposalMore.proposalResult}</div>

				<br>
				</div>

				<!-- Голосование starts here-->
				<c:choose>
					<c:when test="${user.role.roleName == 'ROLE_USER'}">
						<form id="voteForm" method="POST">
						<div class="span" style="text-align:right">
						<p>
						  <h3>Проголосовать:&nbsp;
							<button id="voteYesBtn" class="btn btn-vote btn-success btn-lg" 
									type="submit" name="voteNo" action="voteYes">
								<i class="glyphicon glyphicon-thumbs-up"></i>&nbsp; За 
							</button>
							&nbsp;
							<button id="voteNoBtn" class="btn btn-vote btn-danger btn-lg" 
									type="submit" name="voteNo" action="voteNo">
								<i class="glyphicon glyphicon-thumbs-down"></i>&nbsp; Против 
							</button>
					  	  </h3>
						</p>
						</div>
						</form>
					</c:when>

					<c:otherwise>
						<div class="alert bg-danger">
							Для голосования вы должны быть <a href="/voteme/">авторизованы</a>
						</div>
					</c:otherwise>
				</c:choose>

				<!-- Голосование ends here-->

				<!-- Page comment -->
				<div>
					<div class="alert bg-info">
						<h4>Комментарии:
						<!-- Появление кнопки "AddComment" -->
							<c:if test="${user.role.roleName == 'ROLE_USER'}">
								<button id="addCommentBtn" class="btn btn-primary pull-right" 
								   onclick="document.getElementById('commentForm').style.display = 'block'">
									Добавить комментарий &nbsp;
									<i class="glyphicon  glyphicon-comment"></i>
								</button>	
    						</c:if>
						</h4>
						<!-- Появилась кнопка "AddComment" -->
					</div>

					<form id="commentForm" style="display:none" method="POST" action="addcomment">
					<fieldset>
    						<legend>Добавление комментария:</legend>
    						<textarea class="form-control" rows="3" style="resize:none"	
    							name="commentText" placeholder="Ваш комментарий..."></textarea>
							<br>

							<input type="hidden" name="propID" value="${proposalMore.proposalId}">
							</input>
    				
    						<button type="submit" class="btn pull-right"> Отправить
    						</button>
    				</fieldset>
    				</form>

					<br>
					<c:if test="${sizeComment > 0}">
						<c:forEach items="${commentProposal}" var="tmpVar">

							<div class="panel panel-default spacer">
								<div class="panel-body">
									<div>${tmpVar.userd.lastName}</div>
									<div>
										<fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss"
											value="${tmpVar.commentDate}" />
									</div>
									<br>
									<div>${tmpVar.commentText}</div>


								</div>
							</div>
							<!--/span-->
						</c:forEach>
					</c:if>


				</div>

				<div>
					<c:if test="${countDoc > 0}">
						<div class="alert bg-info">
							<h4>Список документов:</h4>
						</div>
						<c:forEach items="${documentProposal}" var="tmpVar">

							<div class="panel panel-default spacer">
								<div class="panel-body">
									<div>${tmpVar.docId}</div>
									<div>${tmpVar.docName}</div>
									<div>${tmpVar.docUrl}</div>
									<div>
										<img src=${tmpVar.docUrl } class="img-rounded img-responsive"
											alt="xa">
									</div>


								</div>
							</div>
							<!--/span-->
						</c:forEach>
					</c:if>


				</div>


				<div>
					<br>


					<p>Для рассмотрения варианта решения на
						${proposalMore.proposalLevel.level} уровне осталось
						${proposalMore.requiredVotes-proposalMoreVoteYes} (из:
						${proposalMore.requiredVotes}) голосов.</p>


				</div>

				<p>
					&larr; <a
						href="/voteme/?sortBy=${gpModel.sortBy}&pageQuant=${gpModel.pageQuant}&pageNum=${gpModel.pageNum}&filtrOn=${gpModel.filtrOn}">Вернуться
						к списку инициатив</a>
				</p>


			</div>

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
	<script src="<c:url value="/resources/js/lib/jquery-2.1.0.min.js" />"></script>
	<script src="<c:url value="/resources/js/lib/bootstrap.min.js" />"></script>

</body>
</html>