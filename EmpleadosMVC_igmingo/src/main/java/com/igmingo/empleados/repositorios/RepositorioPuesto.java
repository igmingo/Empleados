package com.igmingo.empleados.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.igmingo.empleados.modelo.Puesto;

public class RepositorioPuesto extends Repositorio<Puesto>{
	
	
	//Creamos en el repositorio, un mapa con el idPuesto y el Nombre, pera poder desplegar una lista de opciones.
	public Map<Integer, String> getMapaOptions(){
		//recupero la lista de puestos
		List<Puesto> l=get(Puesto.class);
		//creo un mapa
		Map<Integer, String> mapa=new HashMap<Integer, String>();
		
		//rellenamos el mapa con un pares de valores
		for (Puesto puesto : l) {
			mapa.put(puesto.getIdPuesto(), puesto.getNombre());
		}
		
		return mapa;	
	}

}
