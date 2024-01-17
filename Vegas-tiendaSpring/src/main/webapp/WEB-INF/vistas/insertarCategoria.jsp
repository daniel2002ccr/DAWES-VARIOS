<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" href="../css/index.css">
<link rel="stylesheet" href="../css/formularios.css">
<link rel="stylesheet" href="../css/tablas.css">
</head>
<body>
	<header>
		<h2>Gestión de Tiendas</h2>
	</header>
	<%@include file="menu.html"%>

	<div class="container">

		<div class="form">
			<form
				action="http://localhost:8080/tienda/categoria/insertarcategoria"
				method="post" id="formulario">
				<label for="nombre">Nombre</label> <input type="text" id="nombre"
					name="nombre"> <label for="descripcion">Descripcion</label>
				<input type="text" id="descripcion" name="descripcion"> <br>
				<label for="activo">Activo</label> <input type="checkbox"
					id="activo" name="activo"> <input type="submit"
					value="Insertar">


			</form>
		</div>

		<c:if test="${resultado == 1 }">

			<p>Categoria insertada correctamente.</p>
		</c:if>
	</div>
</body>
</html>