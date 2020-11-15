package com.cristiane.tareauno.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "alumno")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlumno;
	
	@Size(min = 2, message = "Nombres debe tener minimo 2 caracteres")
	@Column(name = "nombres", nullable=false, length=50)
	private String nombre;
	
	@Size(min = 5, message = "Apellido debe tener un minimo de 5 caracteres")
	@Column(name = "apellidos", nullable = true, length = 50)
	private String apellido;
	
	@Size(min = 9, message = "Rut debe tener un minimo de 9 caracteres")
	@Column(name = "rut", nullable = false, length = 10)
	private String rut;
	
	@Size(min = 10, message = "Direccion debe tener un minimo de 10 caracteres")
	@Column(name = "direccion", nullable = false, length = 100)
	private String direccion;
	
	@Size(min = 9, message = "Telefono debe tener un minimo de 9")
	@Column(name = "celular", nullable = true, length = 15)
	private String celular;
	
	@Email
	@Column(name = "email", nullable = false, length = 60)
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "alumno_clase", joinColumns = @JoinColumn(name = "id_alumno", referencedColumnName = "idAlumno"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idClase"))
	private List<Clase> clases;

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	
}
