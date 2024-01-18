<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


   <%@ page isELIgnored="false"%>
<html>
<head>
	 <link rel="stylesheet" href="/tienda/css/index.css">
	 <link rel="stylesheet" href="/tienda/css/formularios.css">
	 <link rel="stylesheet" href="/tienda/css/tablas.css">
	 
</head>
<body>
<header>
<h2>Gestión de Tienda</h2>
</header>
<%@include file="menu.html" %>



<div class = "container">

	<div class = "form">
		<form action="http://localhost:8080/tienda/peticiones/listadopeticiones" method = "post" id="formulario">
		
			<label for = "id">ID Peticion</label>
			<input type="text" id="id" name="id">
			<label for = "cliente">Cliente</label>
			<select name="cliente" id ="cliente" form ="formulario">
			<option value="" selected>Escoja un cliente</option> 
			<c:forEach items="${combosCliente}" var="cliente">
			<option value="${cliente.id}">${cliente.nombre}</option>
			</c:forEach>
			</select>
			<label for = "producto">Producto</label>
			<select name="producto" id ="producto" form ="formulario">
			<option value="" selected>Escoja un producto</option> 
			<c:forEach items="${combosProducto}" var="producto">
			<option value="${producto.id}">${producto.nombre}</option>
			</c:forEach>
			</select>
			<label for = "cantidad">Cantidad</label>
			<input type="text" id="cantidad" name="cantidad">
			<label for = "estado">Estado</label>
			<select name="estado" id ="estado" form ="formulario">
			<option value="" selected>Escoja un estado</option> 
			<c:forEach items="${combosEstado}" var="estado">
			<option value="${estado.id}">${estado.nombre}</option>
			</c:forEach>
			</select>
			<label for = "fecha">Fecha desde:</label>
			<input type="date" id ="fecha" name="fecha">
			<input type ="submit" value ="Enviar">
		
		</form>
	</div>
	
	<c:if test="${not empty lista }">
	<table>
		<tr>
		<th>ID Peticion</th>
		<th>Cliente</th>
		<th>Producto</th>
		<th>Fecha peticion</th>
		</tr>
		
		<c:forEach items="${lista}" var="peticion">
			<tr>
				<td>${peticion.id}</td>
				<td>${peticion.nombre_cliente}</td>
				<td>${peticion.nombre_producto}</td>
				<td>${peticion.fecha}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
</div>

</body>
</html>
