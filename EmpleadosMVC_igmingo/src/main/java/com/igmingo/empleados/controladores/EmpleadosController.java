package com.igmingo.empleados.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.igmingo.empleados.modelo.Empleado;
import com.igmingo.empleados.repositorios.RepositorioEmpleados;

@Controller
public class EmpleadosController {
	
	// Es la autoconexion
	// Le pide a Spring un objeto del tipo RepositorioEmpleados según el root-context.xml
	@Autowired
	RepositorioEmpleados daoEmpleado;

	@RequestMapping(value="/listado.html")
	public String listado(Model modelo) {
		
		// Una lista con la lista empleados
		List<Empleado> l=daoEmpleado.get(Empleado.class);
		
		// Modelo guarda los datos para pasarle los datos a la vista
		modelo.addAttribute("empleados", l);
		
		//devuelte listado, que gracias a Spring llama a la vista listado.jsp
		return "listado";
	}
	
	@RequestMapping(value="detalle.html", method=RequestMethod.GET)
	public String detalle(Model modelo,HttpServletRequest request) {
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		Empleado e=daoEmpleado.get(Empleado.class, id);
				
		modelo.addAttribute("empleado", e);
		
		return "detalle";
	}
}
