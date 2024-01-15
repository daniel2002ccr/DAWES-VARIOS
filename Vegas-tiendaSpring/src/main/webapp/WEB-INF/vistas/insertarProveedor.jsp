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
				action="http://localhost:8080/tienda/proveedores/insertarproveedor"
				method="post" id="formulario">
				<label for = "nombre">Nombre</label>
			<input type="text" id="nombre" name="nombre">
			<label for = "contacto">Contacto</label>
			<input type="text" id="contacto" name="contacto">
			<label for = "telefono">Telefono</label>
			<input type="text" id="telefono" name="telefono">
			<label for = "correo">Correo Electronico</label>
			<input type="text" id="correo" name="correo">
			<label for = "direccion">Direccion</label>
			<input type="text" id="direccion" name="direccion">
			<label for="activo">Activo</label>
			<input type="checkbox" id ="activo" name="activo">
			
			<input type ="submit" value ="Insertar">


			</form>
		</div>

		<c:if test="${resultado == 1 }">

			<p>Categoria insertada correctamente.</p>
		</c:if>
	</div>
</body>
</html>