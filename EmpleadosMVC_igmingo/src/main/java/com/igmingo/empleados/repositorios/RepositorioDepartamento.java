package com.igmingo.empleados.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.igmingo.empleados.modelo.Departamento;

public class RepositorioDepartamento extends Repositorio<Departamento> {
	
	
	//Creamos en el repositorio, un mapa con el idPuesto y el Nombre, pera poder desplegar una lista de opciones.
	public Map<Integer, String> getMapaOptions(){
		//recupero la lista de departamentos
		List<Departamento> l=get(Departamento.class);
		//creo un mapa
		Map<Integer, String> mapa=new HashMap<Integer, String>();
		
		//rellenamos el mapa con un pares de valores
		for (Departamento dep : l) {
			mapa.put(dep.getIdDepartamento(), dep.getNombre());
		}
		
		return mapa;	
	}
	
}
