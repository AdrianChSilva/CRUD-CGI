<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="es">
<head>

<!-- Access the bootstrap Css like this, 
		Spring boot will handle the resource mapping automcatically -->
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/4.1.0/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<title>Gestion - Pag Principal</title>
</head>
<body>
<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1>Gestión de socios, videojuegos y facturas</h1>
			<p>Pinche en algun boton según la acción deseada</p>
		</div>
	</div>


	<div class="container-fluid">
		<br></br>

		<button type="button" class="btn btn-primary btn-lg btn-block"
			onclick="location.href = 'socios';">Socios</button>
		<br></br>
		<button type="button" class="btn btn-success btn-lg btn-block"
			onclick="location.href = 'videojuegos';">Videojuegos</button>
		<br></br>
		<button type="button" class="btn btn-warning btn-lg btn-block"
			onclick="location.href = 'facturas';">Facturas</button>
		<br></br>


	</div>

	<script type="text/javascript"
		src="webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>

</body>

</html>
