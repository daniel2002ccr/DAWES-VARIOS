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

	<%@include file="/menu.html"%>



	<div class="container">

		<div class="form">

			<form

				action="http://localhost:8080/tienda/categoria/formularioactualizarcategoria"

				method="POST">

				<label for="id">ID</label> 
				<input type="text" id="id" name="id"> 
				<label for="nombre"> Nombre</label> 
				<input type="text" id="nombre" name="nombre"> 
				<label for="descripcion"> Descripcion </label>
				<input type="text" id="descripcion" name="descripcion"> 
				<label for="activo"> Activo </label> <input type="checkbox" id="activo" name="activo"> 
				<input type="submit" value="Enviar">

			</form>

		</div>

<h3>Resultados de la busqueda</h3>
		<c:forEach items="${lista}" var="categoria">

			<div class="form">

				<form

					action="http://localhost:8080/tienda/categoria/actualizarcategoria"

					method="POST">

					
					<label for="id">ID</label> 
				<input type="text" id="id" name="id" value="${categoria.id}"> 
				<label for="nombre"> Nombre</label> 
				<input type="text" id="nombre" name="nombre" value="${categoria.nombre}"> 
				<label for="descripcion"> Descripcion </label>
				<input type="text" id="descripcion" name="descripcion" value="${categoria.descripcion}"> 
				

					<label for="activo"> Activo </label>

					<c:if test="${categoria.activo == 1}">
						<input type="checkbox" id="activo" name="activo" checked>
					</c:if>
					<c:if test="${categoria.activo == 0}">
						<input type="checkbox" id="activo" name="activo">
					</c:if>
					<input type="submit" value="Modificar">
				</form>
			</div>

		</c:forEach>

<c:if test="${resultado == 1 }">

<p>Categoria actualizada correctamente.</p>
</c:if>
	</div>

</body>

</html>