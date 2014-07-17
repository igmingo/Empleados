package com.igmingo.empleados.repositorios;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;

import com.igmingo.empleados.modelo.Empleado;

public class RepositorioEmpleados extends Repositorio<Empleado> {

	//Sobreescribo el método, pero primero llama al padre y luego inicializo
	//el departamento y el puesto para que el Lazy Loader dé error por no estar
	//en la misma sesion.
	@Override
	public Empleado get(Class<Empleado> tipo, int id) {
		// TODO Auto-generated method stub
		Empleado e= super.get(tipo, id);

		Hibernate.initialize(e.getDepartamento());
		Hibernate.initialize(e.getPuesto());

		return e;
	}
	
}
