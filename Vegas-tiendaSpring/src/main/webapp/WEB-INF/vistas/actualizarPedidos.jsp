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
				action="http://localhost:8080/tienda/pedidos/formularioactualizarpedidos"
				method="POST">
				<label for = "id">ID Pedido</label>
			<input type="text" id="id" name="id">
			<label for = "cliente">Cliente</label>
			<select name="cliente" id ="cliente">
			<option value="" selected>Escoja un cliente</option> 
			<c:forEach items="${combosCliente}" var="cliente">
			<option value="${cliente.id}">${cliente.nombre}</option>
			</c:forEach>
			</select>
			<label for = "fecha">Fecha desde:</label>
			<input type="date" id ="fecha" name="fecha">
			<label for = "estado">Estado</label>
			<select name="estado" id ="estado">
			<option value="" selected>Escoja un estado</option> 
			<c:forEach items="${combosEstado}" var="estado">
			<option value="${estado.id}">${estado.nombre}</option>
			</c:forEach>
			</select>
			<input type ="submit" value ="Enviar">
			</form>
		</div>

<h3>Resultados de la busqueda</h3>
		<c:forEach items="${lista}" var="pedidos">
			<div class="form">
				<form
					action="http://localhost:8080/tienda/pedidos/actualizarpedidos"
					method="POST">

			<label for = "id">ID Pedidos</label>
			<input type="text" id="id" name="id" value="${pedidos.id}" readonly>
			<label for = "id_detalle">ID del detalle del pedido</label>
			<input type="text" id="id_detalle" name="id_detalle" value="${pedidos.id_detalle}" readonly>
			<label for = "cliente">Cliente</label>
			<select name="cliente" id ="cliente"> 
			<c:forEach items="${combosCliente}" var="cliente">
			<option value="${cliente.id}">${cliente.nombre}</option>
			</c:forEach>
			<option value="${pedidos.id_cliente}" selected>${pedidos.nombre_cliente}</option>
			</select>
			<label for = "producto">Producto</label>
			<select name="producto" id ="producto">
			<c:forEach items="${combosProducto}" var="producto">
			<option value="${producto.id}">${producto.nombre}</option>
			</c:forEach>
			<option value="${pedidos.id_producto}" selected>${pedidos.nombre_producto}</option>
			</select>
			<label for = "estado">Estado</label>
			<select name="estado" id ="estado">
			<c:forEach items="${combosEstado}" var="estado">
			<option value="${estado.id}">${estado.nombre}</option>
			</c:forEach>
			</select>
			<label for = "cantidad">Cantidad</label>
			<input type="text" id="cantidad" name="cantidad" value="${pedidos.cantidad}">
			<label for = "estado">Precio</label>
			<input type="text" id="estado" name="precio" value="${pedidos.precio}">
			
			<br> <input type="submit" id="boton" value="Modificar">
			</form>
			</div>
		</c:forEach>
		<c:if test="${resultado == 2}">
			<h3>Peticion modificada con éxito</h3>
		</c:if>
	</div>
</body>
</html>