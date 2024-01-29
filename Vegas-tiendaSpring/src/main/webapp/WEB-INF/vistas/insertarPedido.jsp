<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page isELIgnored="false"%>


<html>
<head>
	<meta charset="UTF-8">
    <title>Carrito de Compras</title>
     <link rel="stylesheet" href="/tienda/css/index.css">
	 <link rel="stylesheet" href="/tienda/css/formularios.css">
	 <link rel="stylesheet" href="/tienda/css/tablas.css">
</head>
<body>
    <h1>Carrito de Compras</h1>

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
			<label for="cantidad">Cantidad:</label>
    		<input type="text" id="cantidad">
    <br><br>
        <label for="precio">Precio:</label>
    	<input type="number" id="precio" >
   <br><br>
    <button onclick="agregarAlCarrito()">Agregar al carrito</button>
    <button onclick="realizarVenta()">Realizar Venta</button>

    <h2>Carrito</h2>
    <ul id="listaCarrito">
    </ul>

 <script src="/tienda/js/scripts.js"></script>
</body>
</html>
