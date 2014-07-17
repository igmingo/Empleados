package com.igmingo.empleados.repositorios;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
//Clase Spring Framework para gestionar la BBDD desde Spring
//Es para usar el Hibernate en Spring
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class Repositorio<T> extends HibernateDaoSupport implements IRepositorio<T> {

	Session sesion=null;
	
	@Override
	public List<T> get(Class<T> tipo) {
		//obtenemos la sesion actual, ya NO creamos sesiones o las cerramos
		if (sesion==null || sesion.isOpen())
			sesion=getSessionFactory().getCurrentSession();	
		Query q=sesion.createQuery("from " + tipo.getName());
		List<T> l=(List<T>)q.list();
		return l;
	}

	@Override
	public T get(Class<T> tipo, int id) {
		if (sesion==null || sesion.isOpen())
			sesion=getSessionFactory().getCurrentSession();
		T obj=(T) sesion.get(tipo, id);
		return obj;
	}

	@Override
	public void add(T objeto) {
		if (sesion==null || sesion.isOpen())
			sesion=getSessionFactory().getCurrentSession();
		sesion.save(objeto);
	}

	@Override
	public void delete(T objeto) {
		if (sesion==null || sesion.isOpen())
			sesion=getSessionFactory().getCurrentSession();
		sesion.delete(objeto);
	}

	@Override
	public void update(T objeto) {
		if (sesion==null || sesion.isOpen())
			sesion=getSessionFactory().getCurrentSession();
		sesion.update(objeto);
	}

	@Override
	public List<T> find(String consulta, Map<String, Object> params) {
		if (sesion==null || sesion.isOpen())
			sesion=getSessionFactory().getCurrentSession();
		Query q=sesion.getNamedQuery(consulta);
		for (String param : params.keySet()) {
			q.setParameter(param, params.get(param));
		}
		List<T> l=q.list();
		return l;
	}

}
