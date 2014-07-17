package com.igmingo.empleados.modelo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends ObjectMapper{
	public HibernateAwareObjectMapper() {
		//registra el módulo de hibernate para el conversor de JSON
		registerModule(new Hibernate4Module());
	}

}
