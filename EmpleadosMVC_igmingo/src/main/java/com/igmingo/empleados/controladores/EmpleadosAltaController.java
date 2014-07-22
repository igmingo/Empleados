package com.igmingo.empleados.controladores;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.igmingo.empleados.modelo.Departamento;
import com.igmingo.empleados.modelo.Empleado;
import com.igmingo.empleados.modelo.Puesto;
import com.igmingo.empleados.modelo.viewforms.EmpleadoViewForm;
import com.igmingo.empleados.repositorios.RepositorioDepartamento;
import com.igmingo.empleados.repositorios.RepositorioEmpleados;
import com.igmingo.empleados.repositorios.RepositorioIdiomas;
import com.igmingo.empleados.repositorios.RepositorioPuesto;

@Controller
@RequestMapping(value="/altaEmpleado.html")
public class EmpleadosAltaController {

	// inyecta automáticamente el repositorio de empleados, puestos y departamentos, en la clase
	@Autowired
	RepositorioEmpleados daoEmpleado;
	@Autowired
	RepositorioPuesto daoPuesto;
	@Autowired
	RepositorioDepartamento daoDepartamento;
	@Autowired
	RepositorioIdiomas daoIdiomas;
	
	@RequestMapping (method=RequestMethod.GET)
	//usamos mejor el ModelMap
	public String alta(ModelMap modelo) {
		//es el empleado vacio que va ha rellenar el usuario
		EmpleadoViewForm empleado = new EmpleadoViewForm();
		modelo.addAttribute("empleado", empleado);
		
		//hemos creado un método getMapaOptions, que devuelve todos los puestos y departamentos
		
		//añado al modelo la lista de puestos
		Map<Integer, String> lpuestos=daoPuesto.getMapaOptions();
		modelo.addAttribute("op_puestos", lpuestos);
		
		//añado al modelo la lista de departamentos
		Map<Integer, String> ldep=daoDepartamento.getMapaOptions();
		modelo.addAttribute("op_departamentos", ldep);
		
		//añado al modelo la lista de idiomas
		Map<Integer, String> lidiomas=daoIdiomas.getMapaOptions();

				
		//llamamos a alta.jsp
		return "alta";
	}

	//Cuando el ususario haga clic en submit se enviará una petición por POST
	@RequestMapping (method=RequestMethod.POST)
	public String doAlta(@ModelAttribute("empleado") EmpleadoViewForm vistaemple, BindingResult resultado, HttpServletRequest request) {
		//si tiene errores, entonces volver a sacar el formulario de alta con las listas de puestos y departamentos.
		if(resultado.hasErrors()) {
			Map<Integer, String> lpuestos=daoPuesto.getMapaOptions();
			Map<Integer, String> ldep=daoDepartamento.getMapaOptions();
			Map<Integer, String> lidiomas=daoIdiomas.getMapaOptions();
			request.setAttribute("op_puestos", lpuestos);
			request.setAttribute("op_departamentos", ldep);
			request.setAttribute("op_idiomas", lidiomas);
			return "alta";
		}
		//cojemos el empleado de la vistaempleado y le ponemos la fecha de creación
		Empleado emple=vistaemple.getEmpleado();
		emple.setFechaAlta(new Date());
		daoEmpleado.add(emple);
		return "redirect:/listado.html";
	}	
	
}
