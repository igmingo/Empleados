package com.igmingo.empleados.modelo;
// Generated 14-jul-2014 18:36:36 by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NamedQuery;

/**
 * Empleado generated by hbm2java
 */
@Entity
@Table(name="empleado"
    ,catalog="teide2014"
)

@NamedQuery (name="empleado.buscador", query="from Empleado e where e.nombre like :texto")
public class Empleado  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private Integer idEmpleado;
     private Puesto puesto;
     private Departamento departamento;
     private String nombre;
     private double salario;
     private Date fechaAlta;
     private Set<Idioma> idiomas = new HashSet<Idioma>(0);
     private Set<EmpleadoProyecto> empleadoProyectos = new HashSet<EmpleadoProyecto>(0);

    public Empleado() {
    }

	
    public Empleado(Puesto puesto, String nombre, double salario) {
        this.puesto = puesto;
        this.nombre = nombre;
        this.salario = salario;
    }
    public Empleado(Puesto puesto, Departamento departamento, String nombre, double salario, Date fechaAlta, Set<Idioma> idiomas, Set<EmpleadoProyecto> empleadoProyectos) {
       this.puesto = puesto;
       this.departamento = departamento;
       this.nombre = nombre;
       this.salario = salario;
       this.fechaAlta = fechaAlta;
       this.idiomas = idiomas;
       this.empleadoProyectos = empleadoProyectos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idEmpleado", unique=true, nullable=false)
    public Integer getIdEmpleado() {
        return this.idEmpleado;
    }
    
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPuesto", nullable=false)
    public Puesto getPuesto() {
        return this.puesto;
    }
    
    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idDepartamento")
    public Departamento getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    
    @Column(name="nombre", nullable=false, length=250)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="salario", nullable=false, precision=22, scale=0)
    public double getSalario() {
        return this.salario;
    }
    
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fechaAlta", length=10)
    public Date getFechaAlta() {
        return this.fechaAlta;
    }
    
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

@ManyToMany(fetch=FetchType.LAZY, mappedBy="empleados")
    public Set<Idioma> getIdiomas() {
        return this.idiomas;
    }
    
    public void setIdiomas(Set<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="empleado")
    public Set<EmpleadoProyecto> getEmpleadoProyectos() {
        return this.empleadoProyectos;
    }
    
    public void setEmpleadoProyectos(Set<EmpleadoProyecto> empleadoProyectos) {
        this.empleadoProyectos = empleadoProyectos;
    }

}


