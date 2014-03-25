<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
   <head>
      <title>Общественная инициатива</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Bootstrap -->
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" >

	<style media="screen" type="text/css">
		.spacer{margin-bottom: 6px; }
	</style>

   </head>
  <body>

    <div class="container">
	<div class="row page-header">
			<div class="pull-left">
				<h1> Общественная инициатива<br><small>Всего инициатив: ${amount} </small></h1>
				
			</div>
			<div class="pull-right">
				<p><a class="pull-right" href="#" >Помощь</a></p>
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
	       <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	         <span class="sr-only">Toggle navigation</span>
	         <span class="icon-bar"></span>
	         <span class="icon-bar"></span>
	         <span class="icon-bar"></span>
	       </button>
	       <a class="navbar-brand" href="#">Главная</a>
	     </div>
	 
	     <!-- Collect the nav links, forms, and other content for toggling -->
	     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	       <ul class="nav navbar-nav">
	 		 <li class="active"><a href="#">Все</a></li>
	         <li><a href="#">Популярные</a></li>
	         <li><a href="#">Последние</a></li>
	         <li class="active"><a href="#">Показывать по 10</a></li> 
	         <li class=""><a href="#">Показывать по 25</a></li> 

	       
	        </ul>
	       <form class="navbar-form navbar-right" role="search">
	         <div class="form-group">
	           <input type="text" class="form-control" placeholder="Поиск инициатив...">
	         </div>
	         <button type="submit" class="btn btn-default">Поиск</button>
	       </form>
	       
	     </div><!-- /.navbar-collapse -->
	   </div><!-- /.container-fluid -->
	 </nav>





      <div class="row">




        <div class="col-sm-9">
            <div class="row">
            	<c:forEach items="${proposalList}" var="tmpVar" >
		            <div  class="panel panel-default col-md-6 spacer" >
		            	<div class="panel-body">
			              <p>${tmpVar.proposalName} </p>
			              <p>	
							<a class="pull-right" href="#" role="button">Подробнее»</a>
							<em class="pull-left">Количество голосов: ${fn:length(tmpVar.votes)} </em>
					      </p>
						</div>
		            </div><!--/span-->
				</c:forEach>
           </div><!--/row-->
		<!-- Pagination -->
			<div >
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
        </div><!--/span-->

        <div class="col-sm-3" role="navigation">
	   
           <div class="well sidebar-nav">
           		<p>${tMes}</p>
				<form role="form" method="POST" action="login">
				  <div class="form-group">
				    <label for="inputName">Имя</label>
				    <input type="text" class="form-control" id="inputName" name="name" placeholder="Введите имя">
				  </div>
				  <div class="form-group">
				    <label for="InputPassword">Пароль</label>
				    <input type="password" class="form-control" name="password" id="InputPassword" placeholder="Пароль">
				  </div>
			<!-- 	  <div class="checkbox">
				    <label>
				      <input type="checkbox"> Запомнить меня
				    </label>
			  		</div>
			   -->	
				  <button type="submit" class="btn btn-default" >Войти</button>
				  <a class="pull-right" href="#" role="button">Регистрация</a>
				</form>
          </div><!--/.well -->
	  <div class="well sidebar-nav">
		<form role="form">
		  Фильтрация запроса.
		  <div class="checkbox">
		    <label>
		      <input type="checkbox"> Федеральный
		    </label>
		  </div>
		  <div class="checkbox">
		    <label>
		      <input type="checkbox"> Региональный
		    </label>
		  </div>
		  <div class="checkbox">
		    <label>
		      <input type="checkbox"> Муниципальный
		    </label>
		  </div>
		  <div class="checkbox">
		    <label>
		      <input type="checkbox"> Что-то еще
		    </label>
		  </div>
		  <button type="submit" class="btn btn-default">Применить</button>
		</form>           
              
            
          </div><!--/.well -->
        </div><!--/span-->
      </div><!--/row-->

      <hr>

	

      <footer>
        <p>© BArygaCompany 2014</p>
      </footer>

    </div><!--/.container-->



    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<c:url value="/resources/js/jquery-2.1.0.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
  

</body></html>
