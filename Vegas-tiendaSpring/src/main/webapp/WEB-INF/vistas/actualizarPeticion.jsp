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
				action="http://localhost:8080/tienda/peticiones/formularioactualizarpeticiones"
				method="POST">
			<label for = "id">ID Peticion</label>
			<input type="text" id="id" name="id">
			<label for = "cliente">Cliente</label>
			<select name="cliente" id ="cliente">
			<option value="" selected>Escoja un cliente</option> 
			<c:forEach items="${combosCliente}" var="cliente">
			<option value="${cliente.id}">${cliente.nombre}</option>
			</c:forEach>
			</select>
			<label for = "producto">Producto</label>
			<select name="producto" id ="producto">
			<option value="" selected>Escoja un producto</option> 
			<c:forEach items="${combosProducto}" var="producto">
			<option value="${producto.id}">${producto.nombre}</option>
			</c:forEach>
			</select>
			<label for = "cantidad">Cantidad</label>
			<input type="text" id="cantidad" name="cantidad">
			<label for = "estado">Estado</label>
			<select name="estado" id ="estado">
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

<h3>Resultados de la busqueda</h3>
		<c:forEach items="${lista}" var="peticion">
			<div class="form">
				<form
					action="http://localhost:8080/tienda/peticiones/actualizarpeticiones"
					method="POST">

			<label for = "id">ID Peticion</label>
			<input type="text" id="id" name="id" value="${peticion.id}">
			<label for = "cliente">Cliente</label>
			<select name="cliente" id ="cliente"> 
			<c:forEach items="${combosCliente}" var="cliente">
			<option value="${cliente.id}">${cliente.nombre}</option>
			</c:forEach>
			<option value="${peticion.id_cliente}" selected>${peticion.nombre_cliente}</option>
			</select>
			<label for = "producto">Producto</label>
			<select name="producto" id ="producto">
			<c:forEach items="${combosProducto}" var="producto">
			<option value="${producto.id}">${producto.nombre}</option>
			</c:forEach>
			<option value="${peticion.id_producto}" selected>${peticion.nombre_producto}</option>
			</select>
			<label for = "cantidad">Cantidad</label>
			<input type="text" id="cantidad" name="cantidad" value="${peticion.cantidad}">
			<label for = "estado">Estado</label>
			<select name="estado" id ="estado"> 
			<c:forEach items="${combosEstado}" var="estado">
			<option value="${estado.id}">${estado.nombre}</option>
			</c:forEach>
			<option value="${peticion.id_estado}" selected>${peticion.nombre_estado}</option>
			</select>
			<br> <input type="submit" id="boton" value="Modificar">
			</form>
			</div>
		</c:forEach>
		<c:if test="${resultado == 1}">
			<h3>Peticion modificada con éxito</h3>
		</c:if>
	</div>
</body>
</html>