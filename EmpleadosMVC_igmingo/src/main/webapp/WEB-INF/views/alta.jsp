<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alta de </title>
</head>
<body>

Datos del empleado<br/>
<!-- es una etiqueta de Spring, en vez de un action es un commandName (un objeto que enviamos de vuelta) -->
	<form:form method="post" commandName="empleado">
<!-- 	En vez de un name, se usa el path (la ruta de la propiedad) (igual que en la clase) -->
	Nombre: <form:input path="nombre" /><br />
	Salario: <form:input path="salario" /><br />
	Puesto: <form:select path="puesto">
				<form:options items="${op_puestos}" />
			</form:select><br />

	Departamento: <form:select path="departamento">
				<form:options items="${op_departamentos}" />
			</form:select><br />
	Idiomas: <form:select path="idIdioma" multiple="true">
				<form:options items="${op_idiomas}" />
			</form:select><br />
			<input type="submit" value="Guardar"/>
			
	</form:form>

</body>
</html>