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

				action="http://localhost:8080/tienda/clientes/formularioactualizarcliente"

				method="POST" id="formulario">

				<label for="id">ID Cliente</label> 
				<input type="text" id="id" name="id"> 
				<label for="nombre"> Nombre</label> 
				<input type="text" id="nombre" name="nombre"> 
				<label for="correo"> Correo </label>
				<input type="text" id="correo" name="correo">
				<select name="poblacion" id ="poblacion" form ="formulario">
				<option value="" selected>Escoja una poblacion</option>  
				<c:forEach items="${combosPoblacion}" var="poblacion">
				<option value="${poblacion.id}">${poblacion.nombre}</option>
				</c:forEach>
				</select> <br> 
				<label for="activo"> Activo </label> <input type="checkbox" id="activo" name="activo"> 
				<input type="submit" value="Enviar">

			</form>

		</div>

<h3>Resultados de la busqueda</h3>
		<c:forEach items="${lista}" var="cliente">

			<div class="form">

				<form

					action="http://localhost:8080/tienda/clientes/actualizarcliente"

					method="POST">

					
					<label for="id">ID Cliente</label> 
					<input type="text" id="id" name="id" value="${cliente.id}" readonly> 
					<label for="nombre"> Nombre</label> 
					<input type="text" id="nombre" name="nombre" value="${cliente.nombre}"> 
					<label for="correo"> Correo </label>
					<input type="text" id="correo" name="correo" value="${cliente.correo}">
					<select name="poblacion" id ="poblacion">  
					<c:forEach items="${combosPoblacion}" var="poblacion">
					<option value="${poblacion.id}">${poblacion.nombre}</option>
					</c:forEach>
					<option value="${cliente.id}" selected>${cliente.poblacion}</option>
					</select> <br> 

					<label for="activo"> Activo </label>

					<c:if test="${cliente.activo == 1}">
						<input type="checkbox" id="activo" name="activo" checked>
					</c:if>
					<c:if test="${cliente.activo == 0}">
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