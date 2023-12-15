<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<form action="http://localhost:8080/tienda/producto/insertarproducto"
				method="post" id="formulario">
				 <label for="nombre">Nombre</label> <input
					type="text" id="nombre" name="nombre"> <label
					for="descripcion">Descripcion</label> <input type="text"
					id="descripcion" name="descripcion"> <label for="precio">Precio</label>
				<input type="text" id="precio" name="precio"> <label
					for="cantidadStock">Cantidad en stock</label> <input type="text"
					id="cantidadStock" name="cantidadStock"> <select
					name="categorias" id="categorias" form="formulario">
					<c:forEach items="${combosCategoria}" var="categoria">
						<option value="${categoria.id}">${categoria.nombre}</option>
					</c:forEach>
				</select> <select name="proveedores" id="proveedores" form="formulario">
					<c:forEach items="${combosProveedor}" var="proveedor">
						<option value="${proveedor.id}">${proveedor.nombre}</option>
					</c:forEach>
				</select> <input type="submit" value="Insertar">


			</form>
		</div>

		<c:if test="${resultado == 1 }">

			<p>Categoria insertada correctamente.</p>
		</c:if>
	</div>
</body>
</html>