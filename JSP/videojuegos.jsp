<!DOCTYPE html >
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="es">
<head>

<title>Gestión de Videojuegos</title>
<link href="${jstlCss}" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/4.1.0/css/bootstrap.min.css" />


</head>
<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1>Gestión de Videojuegos</h1>
			<p>Aquí podrá consultar el listado de videojuegos, modificarlos,
				insertarlos y eliminarlos</p>
		</div>
	</div>
	<nav class="navbar navbar-expand-sm bg-light navbar-light fixed-top">
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
		<form method="get" class="form-inline" action="/buscaVideojuegos">
			<input class="form-control mr-sm-2" name="b" type="text"
				placeholder="Buscar">
		</form>
		<div style="position: relative;">
			<form method="post" action="archivoVideojuego"
				enctype="multipart/form-data">
				<input class="btn btn-light" value="Input Button" type="file"
					name="csv" id="fileChooser" /><input type="submit" value="Subir"
					class="btn btn-light" name="csv" />
			</form>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="table-responsive">
			<table class="table">

				<tr>
					<th>Codigo</th>
					<th>Título</th>
					<th>Plataforma</th>
					<th>Desarrolladora</th>
					<th>Publisher</th>
					<th>Precio</th>
					<th>Stock</th>
				</tr>

				<form method="post" action="altaVideojuego">
					<tr>
						<td></td>
						<td><input type="text" name="Titulo" size="12"></td>
						<td><input type="text" name="Plataforma" size="7"></td>
						<td><input type="text" name="Desarrolladora" size="5"
							required></td>
						<td><input type="text" name="Publisher" size="7" required></td>
						<td><input type="number" name="Precio" size="3" required></td>
						<td><input type="number" name="Stock" size="3" required></td>
						<td><button type="submit" value="Añadir"
								class="btn btn-primary">Añadir</button> <span
							class="glyphicon glyphicon-plus"></span></td>
					</tr>

				</form>



				<c:forEach items="${tabla}" var="videojuegos">
					<tr>
						<td>${videojuegos.codVideojuegos}</td>
						<td>${videojuegos.titulo}</td>
						<td>${videojuegos.plataforma}</td>
						<td>${videojuegos.desarrolladora}</td>
						<td>${videojuegos.publisher}</td>
						<td>${videojuegos.precio}</td>
						<td>${videojuegos.stock}</td>
						<td>
							<form method="get" action="borraVideojuego">
								<input type="hidden" name="CodVideojuegos"
									value="${videojuegos.codVideojuegos}" />
								<button type="submit" class="btn btn-danger">
									<span class="glyphicon glyphicon-remove"></span> Eliminar
								</button>
							</form>



							<form method="get" action="editaVideojuego">
								<input type="hidden" name="CodVideojuegos"
									value="${videojuegos.codVideojuegos}" />
								<button type="submit" class="btn btn-info">
									<span class="glyphicon glyphicon-pencil"></span> Editar
								</button>

							</form>
					</tr>

				</c:forEach>

				<c:forEach items="${buscaVi}" var="busca">
					<tr>
						<td>${busca.codVideojuegos}</td>
						<td>${busca.titulo}</td>
						<td>${busca.plataforma}</td>
						<td>${busca.desarrolladora}</td>
						<td>${busca.publisher}</td>
						<td>${busca.precio}</td>
						<td>${busca.stock}</td>
						<td>
							<form method="get" action="borraVideojuego">
								<input type="hidden" name="CodVideojuegos"
									value="${busca.codVideojuegos}" />
								<button type="submit" class="btn btn-danger">
									<span class="glyphicon glyphicon-remove"></span> Eliminar
								</button>
							</form>

							<form method="get" action="editaVideojuego">
								<input type="hidden" name="CodVideojuegos"
									value="${busca.codVideojuegos}" />
								<button type="submit" class="btn btn-info">
									<span class="glyphicon glyphicon-pencil"></span> Editar
								</button>

							</form>
					</tr>

				</c:forEach>

			</table>
		</div>
	</div>
	<script type="text/javascript"
		src="webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<script>
		function openFileDialog(event) {
			$('#file').click();
		}
	</script>
</body>
</html>