<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<div class="errorLine">${error}</div>
	<div id="formularioLogeo">
	<sf:form action="login" modelAttribute="usuario" method="POST">
		<sf:label path="usuario">Usuario</sf:label>
		<sf:input path="usuario" />
		<sf:errors path="usuario" />
		<sf:label path="password">Password</sf:label>
		<sf:input path="password" />
		<sf:errors path="password"></sf:errors>
		<input type="submit" value="Enviar">
	</sf:form>
	</div>
</body>
</html>
