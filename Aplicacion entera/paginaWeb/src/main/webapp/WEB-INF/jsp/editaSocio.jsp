
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Modificacion socios</title>
<link href="${jstlCss}" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/4.1.0/css/bootstrap.min.css" />
</head>
<div class="container-fluid">
	<br> <br>
	<div class="panel panel-info">
		<div class="panel-heading text-center">Editar Socio</div>
		<form method="get" action="editaSocioModificado">
			<!-- ATENCION AQU� -->


			<div class="form-group">
				<label>&nbsp;&nbsp;DNI&nbsp;</label><input type="text"
					class="form-control" size="7" name="DNI" value=${socio.dni}>
				<!-- ATENCION AQU� -->

			</div>
			<div class="form-group">
				<label>Nombre</label> <input class="form-control" name="Nombre"
					value=${socio.nombre}>
				<!-- ATENCION AQU� -->
			</div>
		
			<div class="form-group">
				<label>Apellidos</label> <input type="text" class="form-control"
					name="Apellidos" value=${socio.apellidos}>
				<!-- ATENCION AQU� -->
			</div>

			<div class="form-group">
				<label>&nbsp;&nbsp;Tel�fono&nbsp;</label><input type="text"
					class="form-control" name="Telefono" size="7" value=${socio.telefono}>
				<!-- ATENCION AQU� -->
			</div>
			<div class="form-group">
				<label>&nbsp;&nbsp;Email&nbsp;</label><input type="email"
					class="form-control" name="Email" size="20" value=${socio.email}>
				<!-- ATENCION AQU� -->
			</div>
			<div class="form-group">
				<label>&nbsp;&nbsp;G�nero&nbsp;</label><input type="text"
					class="form-control" name="Genero" size="1" value=${socio.genero}>
				<!-- ATENCION AQU� -->
			</div>
			<div class="form-group">
				<label>&nbsp;&nbsp;Direcci�n&nbsp;</label><input type="text"
					class="form-control" name="Direccion" size="7" value=${socio.direccion}>
				<!-- ATENCION AQU� -->
			</div>
			<div class="form-group">
				<label>&nbsp;&nbsp;Asociado&nbsp;</label><input type="text"
					class="form-control" name="Asociado" size="7" value=${socio.asociado}>
				<!-- ATENCION AQU� -->
			</div>
			<hr>


			&nbsp;&nbsp;<a href="socios" class="btn btn-danger"><span
				class="glyphicon glyphicon-remove"></span>Cancelar</a>
			<button type="submit" class="btn btn-success"
				onclick="location.href = 'editaSocioModificado';">
				<!-- ATENCION AQU� -->
				<span class="glyphicon glyphicon-ok"></span>Aceptar
			</button>
			<input type="hidden" class="form-control" name="CodSocios"
				value=${socio.codSocios}>
			<!-- ATENCION AQU� -->
		</form>

	</div>
	<div class="text-center">&copy;Adrian Chamorro Silva</div>
</div>
</body>
</html>