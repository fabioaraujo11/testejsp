<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Cadastrar evento</title>
<link
	href='<spring:url value="https://fonts.googleapis.com/icon?family=Material+Icons"/>'
	rel="stylesheet" />
<link
	href='<spring:url value="/public/materialize/css/materialize.min.css"/>'
	rel="stylesheet" />
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript"
	src='<spring:url value="/public/materialize/js/materialize.min.js" />'></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8"/>
</head>
<body>
	<jsp:include page="comum/header.jsp"></jsp:include>
	<div class="container">

		<h1>Cadastro de eventos:</h1>

		<br>
		<form method="post" accept-charset="UTF-8">
			Nome: <input type="text" value="" name="nome" required />
			<div class="row">
				<div class="input-field col s6">
					Local: <input type="text" value="" name="local" required />
				</div>
				<div class="input-field col s3">
					Data: <input type="date" value="" name="data" required />
				</div>
				<div class="input-field col s3">
					Horário: <input type="time" value="" name="horario" required />
				</div>
			</div>


			<button type="submit" class="btn waves-effect waves-light">
				Salvar <i class="material-icons right">send</i>
			</button>
		</form>
	</div>
</body>
</html>