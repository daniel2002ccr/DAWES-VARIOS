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
<%@include file="menu.html" %>



<div class = "container">

	<div class = "form">
		<form action="http://localhost:8080/tienda/clientes/listadoclientes" method = "post" id="formulario">
		
			<label for = "id">ID Cliente</label>
			<input type="text" id="id" name="id">  <br><br>
			<label for = "nombre">Nombre</label>
			<input type="text" id="nombre" name="nombre">  <br><br>
			<label for = "correo">Correo Electrónico</label>
			<input type="text" id="correo" name="correo">  <br><br>
			<select name="poblacion" id="poblacion">
				<option value="" selected>Escoja una poblacion</option>
				<c:forEach items="${comboPoblacion}" var="poblacion">
					<option value="${poblacion.id}">${poblacion.nombre}</option>
				</c:forEach>
			</select> <br><br>
			<label for = "activo">Activo</label>
			<input type="checkbox" id ="activo" name="activo"> <br><br>
			<input type ="submit" value ="Enviar">
		
		</form>
	</div>
	
	<c:if test="${not empty lista }">
	<table>
		<tr>
		<th>ID</th>
		<th>Nombre</th>
		<th>Correo Electrónico</th>
		<th>Poblacion</th>
		</tr>
		
		<c:forEach items="${lista}" var="cliente">
			<tr>
				<td>${cliente.id}</td>
				<td>${cliente.nombre}</td>
				<td>${cliente.correo}</td>
				<td>${cliente.poblacion}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
</div>

</body>
</html>
