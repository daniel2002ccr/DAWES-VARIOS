<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


   <%@ page isELIgnored="false"%>
<html>
<head>
	 <link rel="stylesheet" href="../css/index.css">
	 <link rel="stylesheet" href="../css/formularios.css">
	 <link rel="stylesheet" href="../css/tablas.css">
	 
</head>
<body>
<header>
<h2>Gestión de Tienda</h2>
</header>
<%@include file="/menu.html" %>



<div class = "container">

	<div class = "form">
		<form action="http://localhost:8080/tienda/proveedores/listadoproveedores" method = "post">
		
			<label for = "id">ID proveedor</label>
			<input type="text" id="id" name="id">
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
			
			<input type ="submit" value ="Enviar">
		
		</form>
	</div>
	
	<c:if test="${not empty lista }">
	<table>
		<tr>
		<th>ID</th>
		<th>Nombre</th>
		<th>Contacto</th>
		<th>Telefono</th>
		<th>Correo electrónico</th>
		<th>Dirección</th>
		</tr>
		
		<c:forEach items="${lista}" var="tienda">
			<tr>
				<td>${tienda.id}</td>
				<td>${tienda.nombre}</td>
				<td>${tienda.contacto}</td>
				<td>${tienda.telefono}</td>
				<td>${tienda.correo}</td>
				<td>${tienda.direccion}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
</div>

</body>
</html>
