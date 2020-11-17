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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristiane.tareauno.exception.ModelNotFoundException;
import com.cristiane.tareauno.model.Clase;
import com.cristiane.tareauno.service.ClaseService;

@RestController
@RequestMapping("/clases")
public class ClaseController {

	@Autowired
	private ClaseService claseService;

	@GetMapping
	public ResponseEntity<List<Clase>> listar() {
		List<Clase> lista = claseService.listar();
		return new ResponseEntity<List<Clase>>(lista, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Clase> registrar(@Valid @RequestBody Clase clase) {
		Clase cla = claseService.registrar(clase);
		return new ResponseEntity<Clase>(cla, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Clase cla = claseService.leerPorId(id);
		if (cla.getIdClase() == null) {
			throw new ModelNotFoundException("NO SE ENCUENTRA EL ID " + id);
		}
		claseService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Clase> listarPorId(@PathVariable("id") Integer id) {
		if (id != null && id > 0) {
			Clase cla = claseService.leerPorId(id);
			return new ResponseEntity<Clase>(cla, HttpStatus.OK);
		}
		{
			return new ResponseEntity<Clase>(new Clase(), HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping
	public ResponseEntity<Clase> modificar(@Valid @RequestBody Clase clase) {
		Clase cla = claseService.modificar(clase);
		return new ResponseEntity<Clase>(cla, HttpStatus.OK);
	}
}
