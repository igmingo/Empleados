<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src='<c:url value="/resources/js/jquery-1.11.1.js"/>'></script>
<title>Listado de Empleados y Salario</title>
</head>
<body>
	Buscar:
	<input type="text" id="txtBuscar" placeholder="Pon tu búsqueda">
	<input type="button" id="btnBuscar" value="Buscar"  onclick="buscar()">
	<table id="tblDatos">
		<c:forEach items="${empleados }" var="empleado">
			<tr>
				<td>${empleado.nombre }</td>
				<td>${empleado.salario }</td>
				<td><a href="detalle.html?id=${empleado.idEmpleado }"> Ver
						detalles </a></td>
				<!--			se pone el # para que no recargue la página. -->
				<td><a href="#" id="lnkDetalle"
					onclick="evento(${empleado.idEmpleado})"> Ver detalles con Ajax
				</a></td>
								<td><a href="#" id="lnkBorrar"
					onclick="borrar(${empleado.idEmpleado})"> Borrar
				</a></td>
				
				
			</tr>
		</c:forEach>
	</table>
	<div id="divDetalle">
	</div>
<script type="text/javascript">

function borrar() {
	//Crea un objeto JSON del tipo atributo : valor
	var datos={idEmpleado:id};
	//Para convertir un objeto en string
	var datosPasar=JSON.stringify(datos);

	//$.get y $.post existen, para todo lo demás $.ajax para implementar otras
	$.ajax (
			//URL del metodo AJAX
			"empleado",{
			//OBJETO JSON con los parametros que vamos a pasar
				//el el JSON que quermos pasar en string
				data:datosPasar,
				// es el metodo que vamos a pasar en este caso DELETE
				method: "DELETE",
				// el tipo de contenido que pasamos es un JSON
				contentType: "application/json",
				//son funciones para el control de errores
				//si tiene exito vamo a hacer una alerta
				sucess: function(res) {
					alert("Empleado borrado correctamente");
					$("#txtBuscar").text("");
					},
					//si tiene error, decir el JSON
				error: function(res){
					alert(JSON.stringify(res));
					}
				}
			);
}


function buscar() {
	var tx=$("#txtBuscar").val();
	if(tx=="") {
		tx="NoBuscoNada";
	}

	
	var url="empleado/buscar/"+tx;

	$.get(url, function (res){

		var tabla=$("#tblDatos");

		//borramos las filas de la tabla
		for(var i=0;i<tabla.rows.lenght;i++){
			tabla.deleteRow(0);
			}
		//recorremos los datos devueltos con la búsqueda
		for (var i=0; i<res.lenght;i++){
			var h="<hr>"
			h+="<td>" + res[i].nombre+"</td>";
			h+="<td>" + res[i].salario+"</td>";
			h+="<td><a href='detalle.html?id="+res[i].idEmpleado+"'></a>";
			h+="<a href='#' onclick='evento("+res[i].idEmpleado+")'>Detalle Ajax</a></td>";
			h+="<a href='#' onclick='borrar("+res[i].idEmpleado+")'>Borrar</a></td>";
			h+="</tr>";
			tabla.append(h);			
			}
			
		});	
}

function evento(id){

	var url="empleado/"+id;
//HAcemos una llamada ajax usando el metodo get
//Le pasamos la url y la funcion que se ejecuta cuando nos 
//devuelve la informacion
	$.get(url,function(res){

		var resultado="<ul>";
		resultado+="<li>"+res.nombre+"</li>";
		resultado+="<li>"+res.salario+"</li>";
		resultado+="<li>"+res.puesto.nombre+"</li>";
		resultado+="<li>"+res.departamento.nombre+"</li></ul>";
	
		$("#divDetalle").html(resultado);

		});
	
}

</script>

</body>
</html>