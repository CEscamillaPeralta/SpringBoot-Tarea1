package com.cristiane.tareauno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clase")
public class Clase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idClase;
	
	@Size(min = 10, message = "Clase debe tener un minimo de 10 caracteres")
	@Column(name = "nombres", nullable = false, length = 50)
	private String nombre;
	
	@Size(min = 2, message = "Seccion debe tener un minimo de 2 caracteres")
	@Column(name = "seccion", nullable = true, length = 3)
	private Integer seccion;

	public Integer getIdClase() {
		return idClase;
	}

	public void setIdClase(Integer idClase) {
		this.idClase = idClase;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getSeccion() {
		return seccion;
	}

	public void setSeccion(Integer seccion) {
		this.seccion = seccion;
	}
	
	

}
