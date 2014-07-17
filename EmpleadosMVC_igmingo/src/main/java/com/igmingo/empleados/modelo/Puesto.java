package com.igmingo.empleados.modelo;
// Generated 14-jul-2014 18:36:36 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Puesto generated by hbm2java
 */
@Entity
@Table(name="puesto"
    ,catalog="teide2014"
)
public class Puesto  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idPuesto;
     private String nombre;
     private Set<Empleado> empleados = new HashSet<Empleado>(0);

    public Puesto() {
    }

	
    public Puesto(String nombre) {
        this.nombre = nombre;
    }
    public Puesto(String nombre, Set<Empleado> empleados) {
       this.nombre = nombre;
       this.empleados = empleados;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idPuesto", unique=true, nullable=false)
    public Integer getIdPuesto() {
        return this.idPuesto;
    }
    
    public void setIdPuesto(Integer idPuesto) {
        this.idPuesto = idPuesto;
    }

    
    @Column(name="nombre", nullable=false, length=100)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="puesto")
    public Set<Empleado> getEmpleados() {
        return this.empleados;
    }
    
    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }




}


