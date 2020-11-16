package com.cristiane.tareauno.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristiane.tareauno.exception.ModelNotFoundException;
import com.cristiane.tareauno.model.Alumno;
import com.cristiane.tareauno.service.AlumnoService;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping
	public ResponseEntity<List<Alumno>> listar() {
		List<Alumno> lista = alumnoService.listar();
		return new ResponseEntity<List<Alumno>>(lista, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Alumno> registrar(@Valid @RequestBody Alumno alumno) {
		Alumno alu = alumnoService.registrar(alumno);
		return new ResponseEntity<Alumno>(alu, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Alumno alu = alumnoService.leerPorId(id);
		if (alu.getIdAlumno() == null) {
			throw new ModelNotFoundException("NO SE ENCUENTRA EL ID " + id);
		}
		alumnoService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
