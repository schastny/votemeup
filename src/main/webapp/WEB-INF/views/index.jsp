<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
   <head>
      <title>Общественная инициатива</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Bootstrap -->
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" >

	<style media="screen" type="text/css">
		.spacer{margin-bottom: 5px; }
	</style>

   </head>
  <body>


 


    <div class="container">
	<div class="row page-header">
			<div class="pull-left">
				<h1> Общественная инициатива<br><small>Всего инициатив: 666 </small></h1>
			</div>
			<div class="pull-right">
				<p><a class="pull-right" href="#" role="button">Помощь</a></p>
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
	 	<li><a href="#">О проекте</a></li>
	         <li><a href="#">Контакты</a></li>
	         <li><a href="#">Помощь</a></li>
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
			
			<ul class="nav nav-pills" >
	  		    <li><a href="#"><b>Все</b></a></li>
	  		    <li><a href="#">Популярные</a></li>
	  		    <li><a href="#">Последние</a></li>
			    <li class="pull-right disabled "><a href="#">Фильтр выкл.</a></li>
			 
			  <li class="dropdown pull-right">
			    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
			      Показывать по 10<span class="caret"></span>
			    </a>
			    <ul class="dropdown-menu">
				    <li><a href="#">Показывать по 10</a></li>
				    <li><a href="#">Показывать по 25</a></li>
				    <li><a href="#">Показывать по 50</a></li>
     			    </ul>
			  </li>
			</ul>

	
	            <div  class="panel panel-default spacer" >
		      <div class="panel-body">
		              <p>Donec id elit nollis euismod. Donec sed odio dui. </p>
	              <p>	
				<a class="pull-right" href="#" role="button">Подробнее»</a>
				<em class="pull-left">Количество голосов: 32 </em>
		      </p>
			</div>
	            </div><!--/span-->
	            <div  class="panel panel-default spacer" >
		      <div class="panel-body">
		              <p>Donec id elit non mi pota sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	              <p>	
				<a class="pull-right" href="#" role="button">Подробнее»</a>
				<em class="pull-left">Количество голосов: 32 </em>
		      </p>
			</div>
	            </div><!--/span-->
		    <div  class="panel panel-default  spacer" >
		      <div class="panel-body">
		              <p>Donec id elit non da magna mollis euismod. Donec sed odio dui. </p>
	              <p>	
				<a class="pull-right" href="#" role="button">Подробнее»</a>
				<em class="pull-left">Количество голосов: 32 </em>
		      </p>
			</div>
	            </div><!--/span-->
		    <div  class="panel panel-default spacer" >
		      <div class="panel-body">
		              <p>Donec id eliassa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	              <p>	
				<a class="pull-right" href="#" role="button">Подробнее»</a>
				<em class="pull-left">Количество голосов: 32 </em>
		      </p>
			</div>
	            </div><!--/span-->
		    <div  class="panel panel-default spacer" >
		      <div class="panel-body">
		              <p>Donec id elit non mi porta gcondimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	              <p>	
				<a class="pull-right" href="#" role="button">Подробнее»</a>
				<em class="pull-left">Количество голосов: 32 </em>
		      </p>
			</div>
	            </div><!--/span-->
		<div  class="panel panel-default spacer" >
		      <div class="panel-body">
		              <p>Donec id elit non mi porta gravidto sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	              <p>	
				<a class="pull-right" href="#" role="button">Подробнее»</a>
				<em class="pull-left">Количество голосов: 32 </em>
		      </p>
			</div>
	            </div><!--/span-->
		<div  class="panel panel-default spacer" >
		      <div class="panel-body">
		              <p>rtor maursem malesuada magna mollis euismod. Donec sed odio dui. </p>
	              <p>	
				<a class="pull-right" href="#" role="button">Подробнее»</a>
				<em class="pull-left">Количество голосов: 32 </em>
		      </p>
			</div>
	            </div><!--/span-->
		<div  class="panel panel-default spacer" >
		      <div class="panel-body">
		              <p>Donec id elit nonermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	              <p>	
				<a class="pull-right" href="#" role="button">Подробнее»</a>
				<em class="pull-left">Количество голосов: 32 </em>
		      </p>
			</div>
	            </div><!--/span-->

	

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
		<form role="form">
		  <div class="form-group">
		    <label for="exampleInputEmail1">Имя</label>
		    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Введите имя">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">Пароль</label>
		    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Пароль">
		  </div>
		  <div class="checkbox">
		    <label>
		      <input type="checkbox"> Запомнить меня
		    </label>
		  </div>
		  <button type="submit" class="btn btn-default">Войти</button>
		  <a class="pull-right" href="#" role="button">Регистрация</a>
		</form>
          </div><!--/.well -->
	  <div class="well sidebar-nav">
		<form role="form">
		     Статус инициативы
		     <div>
			<div class="radio">
			  <label>
			    <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
			    На голосовании
			  </label>
			</div>
			<div class="radio">
			  <label>
			    <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
			    Проверяется
			  </label>
			</div>
			<div class="radio">
			  <label>
			    <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
			    Голосование окончено
			  </label>
			</div>
		     </div>
		     Уровень
		     <div>
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
		  </div>
		     <p> Категория</p>		
		      <div >
		      		<select class="form-control">
				  <option>---Выберите категорию---</option>
				  <option>Транспорт</option>
				  <option>Здравоохранение</option>
				  <option>Общественная безопасность</option>
				  <option>5</option>
				</select>
		      </div><br>
			<p>Территориальное расположение  </p>
		      <div>
			
				<p>		
	  			    <select  class="form-control">
					<option>---Государство---</option>
	  			      <option>Россия</option>
	  			      <option>Украина</option>
	  			    </select>
				<select class="form-control">
				  <option>---Регион---</option>
				  <option>2</option>
				  <option>3</option>
				  <option>4</option>
				  <option>5</option>
				</select>
				<select class="form-control">
				  <option>---Населенный пункт---</option>
				  <option>2</option>
				  <option>3</option>
				  <option>4</option>
				  <option>5</option>
				</select>
			</p>
			</div>
		  <button type="submit" class="btn btn-default">Применить фильтр</button>
		</form>           
              
            
          </div><!--/.well -->
        </div><!--/span-->
      </div><!--/row-->

      <hr>

	

      <footer>
        <p>В© Company 2014</p>
      </footer>

    </div><!--/.container-->



    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>

</body></html>
  

