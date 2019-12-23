<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>INDEX</title>
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
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8" />

</head>


<body>

	<jsp:include page="evento/comum/header.jsp"></jsp:include>
	<div class="container">
		<h1>Lista de Eventos</h1>
		<table>
			<thead>
				<tr>
					<th>Nome</th>
					<th>Local</th>
					<th>Data</th>
					<th>Horário</th>
					<th>Ação</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach var="evento" items="${eventos}">

					<tr>
						<td><a class="waves-effect waves-light btn"
							href="<c:url value='/${evento.idEvento}'/>">${evento.nome}</a></td>
						<td>${evento.local}</td>
						<td>${evento.data}</td>
						<td>${evento.horario}</td>
						<td><a class="waves-effect waves-light btn-small"
							href="<c:url value='/deletarEvento/${evento.idEvento}'/>"><i
								class="material-icons center">delete</i></a></td>
					</tr>

				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>