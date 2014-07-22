package com.igmingo.empleados.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.igmingo.empleados.modelo.Idioma;

public class RepositorioIdiomas extends Repositorio<Idioma>{
	
	//Creamos en el repositorio, un mapa con el idPuesto y el Nombre, pera poder desplegar una lista de opciones.
	public Map<Integer, String> getMapaOptions(){
		//recupero la lista de puestos
		List<Idioma> l=get(Idioma.class);
		//creo un mapa
		Map<Integer, String> mapa=new HashMap<Integer, String>();
		
		//rellenamos el mapa con un pares de valores
		for (Idioma idioma : l) {
			mapa.put(idioma.getIdIdioma(), idioma.getNombre());
		}
		
		return mapa;	
	}

}
