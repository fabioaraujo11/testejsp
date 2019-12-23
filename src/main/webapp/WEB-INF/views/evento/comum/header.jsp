<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<nav>
		<div class="nav-wrapper black">
			<a href="/" class="brand-logo center"><i class="material-icons">cloud</i>EVENTOS</a>
			<ul id="nav-mobile" class="left hide-on-med-and-down">

				<li><a href="/cadastrarEvento"><i
						class="material-icons left">add_circle_outline</i>Cadastrar Evento</a></li>
				<li><a href="/eventos"><i class="material-icons left">format_list_bulleted</i>Lista
						de Eventos</a></li>

			</ul>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a>${user}</a></li>
				<li><a class="waves-effect waves-light btn red darken-4"
					href="/logout"><i class="material-icons">logout</i></a></li>

			</ul>
		</div>
	</nav>
</body>
</html>