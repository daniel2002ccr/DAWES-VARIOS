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
		<form action="http://localhost:8080/tienda/categoria/listadocategorias" method = "post">
		
			<label for = "id">ID categoria</label>
			<input type="text" id="id" name="id">
			<label for = "nombre">Nombre</label>
			<input type="text" id="nombre" name="nombre">
			<label for = "descripcion">Descripcion</label>
			<input type="text" id="descripcion" name="descripcion">
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
		<th>Descripcion</th>
		<th>Activo</th>
		</tr>
		
		<c:forEach items="${lista}" var="tienda">
			<tr>
				<td>${tienda.id}</td>
				<td>${tienda.nombre}</td>
				<td>${tienda.descripcion}</td>
				<td>${tienda.activo}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
</div>

</body>
</html>