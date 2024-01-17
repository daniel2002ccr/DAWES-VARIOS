<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" href="/tienda/css/index.css">
<link rel="stylesheet" href="/tienda/css/formularios.css">
<link rel="stylesheet" href="/tienda/css/tablas.css">
</head>
<body>
	<header>
		<h2>Gestión de Tiendas</h2>
	</header>
	<%@include file="menu.html"%>

	<div class="container">

		<div class="form">
			<form
				action="http://localhost:8080/tienda/proveedores/formularioactualizarproveedor"
				method="POST">
				<label for="id"> ID Proveedor </label> <br> <input type="text"
					id="id" name="id"> <br> <label for="nombre">
					Nombre Proveedor </label> <br> <input type="text" id="nombre"
					name="nombre"> <br> <label for="contacto">
					Contacto </label> <br> <input type="text" id="contacto"
					name="contacto"> <br> <label for="telefono">
					Teléfono </label> <br> <input type="text" id="telefono"
					name="telefono"> <br> <label for="correo">
					Correo Electrónico </label> <br> <input type="text"
					id="correo" name="correo"> <br>
				<label for="direccion"> Dirección </label> <br> <input
					type="text" id="direccion" name="direccion"> <br> <label
					for="activo"> Activo </label> <br> <input type="checkbox"
					id="activo" name="activo"> <br> <input type="submit"
					id="boton" value="Enviar">
			</form>
		</div>

		<c:forEach items="${lista}" var="proveedor">
			<div class="form">
				<form
					action="http://localhost:8080/tienda/proveedores/actualizarproveedor"
					method="POST">

					<label for="id"> ID Proveedor </label> <br> <input type="text"
						id="id" name="id" value="${proveedor.id}" readonly> <br>
					<label for="nombre"> Nombre Proveedor </label> <br> <input
						type="text" id="nombre" name="nombre" value="${proveedor.nombre}">
					<br> <label for="contacto"> Contacto </label> <br> <input
						type="text" id="contacto" name="contacto"
						value="${proveedor.contacto}"> <br> <label
						for="telefono"> Teléfono </label> <br> <input type="text"
						id="telefono" name="telefono" value="${proveedor.telefono}">
					<br> <label for="correo"> Correo
						Electrónico </label> <br> <input type="text" id="correo"
						name="correo" value="${proveedor.correo}">
					<br> <label for="direccion"> Dirección </label> <br> <input
						type="text" id="direccion" name="direccion"
						value="${proveedor.direccion}"> <br> <label
						for="activo"> Activo </label> <br>
					<c:if test="${proveedor.activo == 1}">
						<input type="checkbox" id="activo" name="activo" checked>
					</c:if>
					<c:if test="${proveedor.activo == 0}">
						<input type="checkbox" id="activo" name="activo">
					</c:if>
					<br> <input type="submit" id="boton" value="Modificar">
				</form>
			</div>
		</c:forEach>
		<c:if test="${resultado == 1}">
			<h3>Proveedor modificado con éxito</h3>
		</c:if>
	</div>
</body>
</html>