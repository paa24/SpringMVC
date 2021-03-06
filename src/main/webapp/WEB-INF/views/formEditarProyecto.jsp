<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">

<script>
	$(function() {
		$("#tabs").tabs();
	});

	$(function() {
		$(".datepicker").datepicker({
			dateFormat : "dd/mm/yy"
		});

		$("#tabs").tabs();
	});
	function addTarea() {
		$("#lstTareas")
				.append(
						'<div><input name="tareas" value="" /> <input type="button" value="eliminar" onclick="eliminarTarea(this);"><div>');
	}

	function eliminarTarea(boton) {
		$(boton).parent().remove();
	}
</script>

</head>
<body>
	<div class="usuario">Usuario: ${spring_user.usuario}</div>
	<div class="Encabezado">
		<a href="altaProyecto">Alta Proyecto</a> 
		<a href="listaProyecto">Listado Proyecto</a> 
			<a href="listaProyecto">Buscar Proyectos</a>
			<a href="listaProyecto">Borrar</a> 
			
	</div>
	<sf:form action="" method="POST" modelAttribute="proyecto">
		<sf:label path="codigo">C�digo</sf:label>
		<sf:input path="codigo" readonly="true" />
		<sf:errors path="codigo"></sf:errors>

		<sf:label path="descripcion">Descripci�n</sf:label>
		<sf:input path="descripcion" />
		<sf:errors path="descripcion"></sf:errors>

		<div id="tabs">
			<ul>
				<li><a href="#tabs-1">Datos Generales</a></li>
				<li><a href="#tabs-2">Lista de Tareas</a></li>
			</ul>
			<div id="tabs-1">
				<sf:label path="fecha">Fecha</sf:label>

				<sf:input path="fecha" cssClass="datepicker" />

				<sf:errors path="fecha"></sf:errors>

				<sf:label path="coste">Coste</sf:label>

				<sf:input path="coste" />

				<sf:errors path="coste"></sf:errors>
			</div>
			<div id="tabs-2">
				<div id="lstTareas">

					<input type="button" value="a�adir" onclick="addTarea();">

					<c:forEach items="${proyecto.tareas}" var="tarea">
						<div>

							<input name="tareas" value="${tarea}" /> <input type="button"
								value="eliminar" onclick="eliminarTarea(this);">

						</div>
					</c:forEach>
				</div>

			</div>

		</div>
		<c:if test="${!modovista}">
			<input type="submit" value="Guardar Los Cambios">
		</c:if>
		<button type="button" onclick="location.href='listaProyecto'">Cancelar</button>
	</sf:form>
</body>
</html>