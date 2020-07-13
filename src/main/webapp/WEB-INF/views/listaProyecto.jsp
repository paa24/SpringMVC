<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Proyectos</title>
</head>
<body>
	<div class="usuario">Usuario: ${spring_user.usuario}</div>
	<div class="Encabezado">
	<a href="altaProyecto">Alta Proyecto</a>
	<a href="retornoGestion">Panel de Gestión</a>
	</div>
	<c:if test="${!empty mensajeok}">
		<div class="mesaje">${mensajeok}</div>
	</c:if>

	<form action="buscarProyecto">
		<label for="text">Codigo:</label> <input name="text" type="text">
		<input value="Filtrar" type="submit">
		<input value="Limpiar" type="button" onclick="location='listaProyecto'" >
	</form>

	<table border=1>
		<tr>
			<td>Código</td>
			<td>Descripción</td>
			<td>Coste</td>
			<td>Usuario</td>
			<td>Fecha</td>
			<td>Eliminar</td>
			<td>Editar</td>
			<td>Ver</td>

		</tr>
		<c:forEach items="${listProyectos}" var="proyectos">

			<tr>
				<td>${proyectos.codigo}</td>
				<td>${proyectos.descripcion}</td>
				<td>${proyectos.coste}</td>
				<td>${proyectos.usuario.usuario}</td>
				<td>${proyectos.fecha}</td>
				<td><a href="bajaProyecto?id=${proyectos.proyectoId}"><img
						src="resources/img/eliminar.jpg" /></a></td>
				<td><a href="editProyecto?id=${proyectos.proyectoId}"><img
						src="resources/img/editar.jpg" /></a></td>
						<td><a href="verProyecto?id=${proyectos.proyectoId}"><img
						src="resources/img/ver.png" /></a></td>

			</tr>
		</c:forEach></table>


</body>
</html>