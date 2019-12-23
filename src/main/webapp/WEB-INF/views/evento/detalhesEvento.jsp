<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Detalhe do evento</title>
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
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8" />

<style type="text/css">
.button {
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
}

</style>
</head>


<body>
	<jsp:include page="comum/header.jsp"></jsp:include>
	<div class="container">

		<h1>Evento:</h1>

		<div class="row">
			<div class="input-field col s3">Nome: ${evento.nome}</div>
			<div class="input-field col s3">Local: ${evento.local}</div>
			<div class="input-field col s3">Data: ${evento.data}</div>
			<div class="input-field col s3">Horário: ${evento.horario}</div>
		</div>

		<hr />

		<form method="post" enctype="multipart/form-data" accept-charset="UTF-8">
			<p class="center">Adicionar convidados:</p>
			<div class="row">
				<div class="input-field col s4">
					<input class="button teal lighten-2" type="file" name="files"
						accept="image/png, image/jpeg" value="Upload imagem">

				</div>
				<div class="input-field col s3">
					<input type="text" value="" name="nomeConvidado"
						placeholder="Nome do Convidado" required />
				</div>
				<div class="input-field col s3">
					<input type="text" value="" name="rg" placeholder="RG do Convidado"
						required />
				</div>
				<div class="input-field col s2">
					<button class="waves-effect waves-light btn" type="submit">Adicionar</button>
				</div>
			</div>
		</form>

		<c:if test="${not empty convidados}">
			<h5>Convidados:</h5>
			<div class="row">
				<c:forEach var="convidado" items="${convidados}">
					<div class="col s3">
						<div class="card">
							<div class="card-image">
								<img src="${convidado.pathImgPerfil}${convidado.nameImgPerfil}">
								<a class="btn-floating halfway-fab waves-effect waves-light red"
									href="<c:url value='/deletarConvidado/${convidado.rg}'/>"><i
									class="material-icons">delete</i></a>
							</div>
							<div class="card-content">
								<p class="title">${convidado.nomeConvidado}</p>
								<p>${convidado.rg}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:if>




	</div>
</body>
</html>