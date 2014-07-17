<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalles de ${empleado.nombre }</title>
</head>
<body>
	<table>
			<tr><td>Nombre:</td><td>${empleado.nombre }</td></tr>
 				<tr><td>Departamento:</td><td>${empleado.departamento.nombre }</td></tr>
 				<tr><td>Puesto:</td><td>${empleado.puesto.nombre }</td></tr>
				<tr><td>Salario:</td><td>${empleado.salario }</td></tr>
				<tr><td>Fecha de Alta:</td><td>${empleado.fechaAlta }</td></tr>
	</table>
</body>
</html>