package com.igmingo.empleados.modelo.viewforms;

import java.util.HashSet;
import java.util.Set;

import com.igmingo.empleados.modelo.Departamento;
import com.igmingo.empleados.modelo.Empleado;
import com.igmingo.empleados.modelo.Idioma;
import com.igmingo.empleados.modelo.Puesto;

//Creamos una clase ViewForm que sirva de nexo entre vista y controlador

public class EmpleadoViewForm {

	private Integer idEmpleado;
	private String nombre; 
	private Double salario;
	private Integer idPuesto;
	private Integer idDepartamento;
	//son varios idIdioma luego es un Array
	private Integer[] idsIdioma;
				
	public EmpleadoViewForm() {
	}
	
	public EmpleadoViewForm(Integer idEmpleado, String nombre, Double salario,
			Integer idPuesto, Integer idDepartamento, Integer[] idsIdioma) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.salario = salario;
		this.idPuesto = idPuesto;
		this.idDepartamento = idDepartamento;
		this.idsIdioma = idsIdioma;
	}

	// Metodo creado por nosotros para devolver el empleado
	public Empleado getEmpleado(){
		Empleado emple=new Empleado();
		emple.setIdEmpleado(idEmpleado);
		emple.setNombre(nombre);
		emple.setSalario(salario);
		
		Departamento d=new Departamento();
		d.setIdDepartamento(idDepartamento);
		emple.setDepartamento(d);
		
		Puesto p=new Puesto();
		p.setIdPuesto(idPuesto);
		emple.setPuesto(p);
		
		//creo un set de idioma, para rellenarla con los idiomas
		Set<Idioma> s=new HashSet<Idioma>();
		for (Integer idioma : idsIdioma) {
			Idioma i=new Idioma();
			i.setIdIdioma(idioma);
			s.add(i);
		}
		emple.setIdiomas(s);
		
		return emple;
	}
	
	// Metodo creado por nosotros para coger el empleado
	public void fromEmpleado(Empleado emple){
		setIdEmpleado(emple.getIdEmpleado());
		setNombre(emple.getNombre());
		setSalario(emple.getSalario());
		setIdDepartamento(emple.getDepartamento().getIdDepartamento());
		setIdPuesto(emple.getPuesto().getIdPuesto());
	}
		
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Integer getIdPuesto() {
		return idPuesto;
	}
	public void setIdPuesto(Integer idPuesto) {
		this.idPuesto = idPuesto;
	}
	public Integer getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public Integer[] getIdsIdioma() {
		return idsIdioma;
	}
	public void setIdsIdioma(Integer[] idsIdioma) {
		this.idsIdioma = idsIdioma;
	}
}
