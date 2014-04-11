<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page session="true"%>
<div class="well sidebar-nav">
	<c:if test="${not empty user}">
					   Вы вошли как ${user.userLogin}
					   <a class="pull-right"
			href="<c:url value="/j_spring_security_logout"/>">Выход</a>
	</c:if>
	<c:if test="${empty user}">
		<form role="form" method="POST" action="j_spring_security_check">
			<h4 class="text-danger text-center">${gpModel.loginMes}</h4>
			<div class="form-group">
				<label for="j_username">Имя ${fNameMes}</label> <input type="text"
					name="j_username" class="form-control" id="j_username"
					placeholder="Введите имя">
			</div>
			<div class="form-group">
				<label for="j_password">Пароль ${fPassMes}</label> <input
					type="password" name="j_password" class="form-control"
					id="j_password" placeholder="Пароль">
			</div>
			<div class="checkbox">
				<label> Запомнить меня <input type='checkbox'
					name='_spring_security_remember_me' />
				</label>
			</div>
			<button type="submit" class="btn btn-default" value="Login">Войти</button>
			<a class="pull-right" href="#" role="button">Регистрация</a>
		</form>
	</c:if>

</div>