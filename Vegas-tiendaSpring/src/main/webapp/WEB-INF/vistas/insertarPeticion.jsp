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
				action="http://localhost:8080/tienda/peticiones/insertarpeticion"
				method="post" id="formulario">
				<label for = "cliente">Cliente</label>
			<select name="cliente" id ="cliente" form ="formulario"> 
			<c:forEach items="${combosCliente}" var="cliente">
			<option value="${cliente.id}">${cliente.nombre}</option>
			</c:forEach>
			</select>
			<label for = "producto">Producto</label>
			<select name="producto" id ="producto" form ="formulario">
			<c:forEach items="${combosProducto}" var="producto">
			<option value="${producto.id}">${producto.nombre}</option>
			</c:forEach>
			</select>
			<label for = "cantidad">Cantidad</label>
			<input type="text" id="cantidad" name="cantidad">
			<label for = "estado">Estado</label>
			<select name="estado" id ="estado" form ="formulario">
			<c:forEach items="${combosEstado}" var="estado">
			<option value="${estado.id}">${estado.nombre}</option>
			</c:forEach>
			</select>
			
			<input type ="submit" value ="Insertar">


			</form>
		</div>

		<c:if test="${resultado == 1 }">

			<p>Peticion insertada correctamente.</p>
		</c:if>
	</div>
</body>
</html>