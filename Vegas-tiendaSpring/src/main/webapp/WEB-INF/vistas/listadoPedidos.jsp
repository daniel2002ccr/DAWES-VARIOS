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
		<form action="http://localhost:8080/tienda/pedidos/listarpedidos" method = "post" id="formulario">
		
			<label for = "id">ID Pedido</label>
			<input type="text" id="id" name="id">
			<label for = "cliente">Cliente</label>
			<select name="cliente" id ="cliente" form ="formulario">
			<option value="" selected>Escoja un cliente</option> 
			<c:forEach items="${combosCliente}" var="cliente">
			<option value="${cliente.id}">${cliente.nombre}</option>
			</c:forEach>
			</select>
			<label for = "fecha">Fecha desde:</label>
			<input type="date" id ="fecha" name="fecha">
			<label for = "estado">Estado</label>
			<select name="estado" id ="estado" form ="formulario">
			<option value="" selected>Escoja un estado</option> 
			<c:forEach items="${combosEstado}" var="estado">
			<option value="${estado.id}">${estado.nombre}</option>
			</c:forEach>
			</select>
			<input type ="submit" value ="Enviar">
		
		</form>
	</div>
	
	<c:if test="${not empty lista }">
	<table>
		<tr>
		<th>ID Pedido</th>
		<th>Nombre Cliente</th>
		<th>Nombre Producto</th>
		<th>Cantidad</th>
		<th>Precio del pedido</th>
		</tr>
		
		<c:forEach items="${lista}" var="pedido">
			<tr>
				<td>${pedido.id}</td>
				<td>${pedido.nombre_cliente}</td>
				<td>${pedido.nombre_producto}</td>
				<td>${pedido.cantidad}</td>
				<td>${pedido.precio}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
</div>

</body>
</html>
