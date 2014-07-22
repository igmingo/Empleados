package com.igmingo.empleados.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.igmingo.empleados.modelo.Empleado;
import com.igmingo.empleados.repositorios.RepositorioEmpleados;

// ESTA ES NUESTRA API REST
@Controller
@RequestMapping(value="/empleado")
public class EmpleadoRestController {
	
	@Autowired
	RepositorioEmpleados dao;
	
	// Al llamar por GET /empleado/23, el id será 23
	// Con PathVarieble es una variable que va en el Path de la URL
	// Con ResponseBody indica que el método devuelve ese objeto directamente de tipo Empleado.
	
	@RequestMapping (method=RequestMethod.GET, value="/{id}")
	public @ResponseBody Empleado empleado(@PathVariable int id) {
		Empleado e=dao.get(Empleado.class, id);
		
		//Debe devolver un JSON (comprobar el pom.xml)
		//Para evitar bucles, se debe agregar el JSON para hibernate y 
		//Crear una clase, por ejemplo HibernateAwareObjectMapper que haga un 'registerModule'
		//y modificar el <annotation-driven/> del servlet-context.xml
		
		return e;
	}
	
	@RequestMapping (method=RequestMethod.GET, value="/buscar/{texto}")
	public @ResponseBody List<Empleado> buscar(@PathVariable String texto) {
		
		if(texto.equals("NoBuscoNada"))
			texto="";
		
		Map<String, Object> params=new HashMap();
		params.put("texto", "%" + texto + "%");
		List<Empleado> le=dao.find("empleado.buscador", params);

		return le;
	}
	
	//en el cuerpo de EmpleadoRestControllerla petición se encuentra el objeto empleado
	//el value no hace falta pues lo coge del  EmpleadoRestController
	//	get -> consulta
	//	post -> insert
	//	put -> actualizaciones
	//	delete -> borrado
	
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody Empleado empleado) {

		dao.delete(empleado);
		
		return "borrado";
	}
	
}
