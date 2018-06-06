
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Modificacion</title>
<link href="${jstlCss}" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/4.1.0/css/bootstrap.min.css" />
</head>
<div class="container-fluid">
	<br> <br>
	<div class="panel panel-info">
		<div class="panel-heading text-center">Editar Videojuego</div>
		<form method="get" action="editaVideojuegoModificado">


			<div class="form-group">
				<label>&nbsp;&nbsp;Título&nbsp;</label><input type="text"
					class="form-control" size="7" name="Titulo"
					value=${videojuego.titulo}>

			</div>
			<div class="form-group">
				<label>Plataforma</label> <input class="form-control"
					name="Plataforma" value=${videojuego.plataforma}>
			</div>
			<!-- Me gustaría añadir un arrayList -->
			<div class="form-group">
				<label>Desarrolladora</label> <input type="text"
					class="form-control" name="Desarrolladora"
					value=${videojuego.desarrolladora}>
			</div>

			<div class="form-group">
				<label>&nbsp;&nbsp;Publisher&nbsp;</label><input type="text"
					class="form-control" name="Publisher" size="7"
					value=${videojuego.publisher}>
			</div>
			<div class="form-group">
				<label>&nbsp;&nbsp;Precio&nbsp;</label><input type="number"
					class="form-control" name="Precio" size="20"
					value=${videojuego.precio}>
			</div>
			<div class="form-group">
				<label>&nbsp;&nbsp;Stock&nbsp;</label><input type="number"
					class="form-control" name="Stock" size="1" value=${videojuego.stock}>
			</div>
			<hr>


			&nbsp;&nbsp;<a href="videojuegos" class="btn btn-danger"><span
				class="glyphicon glyphicon-remove"></span>Cancelar</a>
			<button type="submit" class="btn btn-success"
				onclick="location.href = 'editaVideojuegoModificado';">
				<span class="glyphicon glyphicon-ok"></span>Aceptar
			</button>
			<input type="hidden" class="form-control" name="CodVideojuegos"
				value=${videojuego.codVideojuegos}>
		</form>

	</div>
	<div class="text-center">&copy;Adrian Chamorro Silva</div>
</div>
</body>
</html>