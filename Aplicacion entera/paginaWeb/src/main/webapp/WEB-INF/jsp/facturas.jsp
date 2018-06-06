<!DOCTYPE html >
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="es">
<head>

<title>Gestión de Facturas</title>
<link href="${jstlCss}" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/4.1.0/css/bootstrap.min.css" />


</head>
<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1>Gestión de Facturas</h1>
			<p>Aquí podrá consultar el listado de facturas, crear y eliminar</p>
		</div>
	</div>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="/">Home</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="videojuegos">Videojuegos</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="facturas">Facturas</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="socios">Socios</a>
			</li>
		</ul>
		<form method="get" class="form-inline" action="/buscaFacturas">
			<input class="form-control mr-sm-2" name="b" type="text"
				placeholder="Buscar">
		</form>
		<div style="position: relative;">
			<a class='btn btn-primary' href='javascript:;'> Examinar archivos
				<input type="file"
				style='position: absolute; z-index: 2; top: 0; left: 0; filter: alpha(opacity = 0); -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)"; opacity: 0; background-color: transparent; color: transparent;'
				name="file_source" size="40"
				onchange='$("#upload-file-info").html($(this).val());'>
			</a> &nbsp; <span class='label label-info' id="upload-file-info"></span>
		</div>
		<form method="post" action="" enctype="multipart/form-data">
			<button type="submit" value="Subir" class="btn btn-primary">
				<span class="glyphicon glyphicon-plus"></span>Subir
			</button>

		</form>

	</nav>
	<div class="container-fluid">
		<div class="table-responsive">
			<table class="table">
				<tr>
					<th>CodDetFact</th>
					<th>CodVideojuegos</th>
					<th>Título</th>
					<th>Cantidad</th>
					<th>Precio</th>
					<th>Factura_idFactura</th>
				</tr>
				<form method="post" action="/altaFacturas">
					<tr>
						<td></td>
						<td><input type="number" name="CodVideojuegos" size="3"></td>
						<td></td>
						<td><input type="number" name="Cantidad" size="3"></td>
						<td><input type="number" name="Precio" size="4"></td>
						<td><input type="number" name="Factura_idFactura" size="3"></td>

						<td><button type="submit" value="Añadir"
								class="btn btn-primary">
								<span class="glyphicon glyphicon-plus"
									onclick="location.href = 'altaFacturas';"></span> Añadir
							</button></td>
						<td></td>
					</tr>
				</form>

				<c:forEach items="${tablaFa}" var="facturas">
					<tr>
						<td>${facturas.codDetFact}</td>
						<td>${facturas.codVideojuegos}</td>
						<td>${facturas.titulo}</td>
						<td>${facturas.cantidad}</td>
						<td>${facturas.precio}</td>
						<td>${facturas.facturaIdFactura}</td>
						<td>
							<form method="get" action="borraFacturas">
								<input type="hidden" name="CodDetFact"
									value="${facturas.codDetFact}" />
								<button type="submit" class="btn btn-danger">
									<span class="glyphicon glyphicon-remove"></span> Eliminar
								</button>
							</form>
					</tr>

				</c:forEach>

				<c:forEach items="${buscaFa}" var="busca">
					<tr>
						<td>${busca.codDetFact}</td>
						<td>${busca.codVideojuegos}</td>
						<td>${busca.titulo}</td>
						<td>${busca.cantidad}</td>
						<td>${busca.precio}</td>
						<td>${busca.facturaIdFactura}</td>
						<td>
							<form method="get" action="borraFacturas">
								<input type="hidden" name="CodDetFact"
									value="${busca.codDetFact}" />
								<button type="submit" class="btn btn-danger">
									<span class="glyphicon glyphicon-remove"></span> Eliminar
								</button>
							</form>
					</tr>

				</c:forEach>

			</table>
		</div>
	</div>

</body>
</html>