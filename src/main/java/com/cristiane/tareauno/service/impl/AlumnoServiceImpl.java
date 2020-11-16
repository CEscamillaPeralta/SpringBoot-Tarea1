package com.cristiane.tareauno.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristiane.tareauno.model.Alumno;
import com.cristiane.tareauno.repo.AlumnoRepoInterface;
import com.cristiane.tareauno.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	private AlumnoRepoInterface repo;

	@Override
	public Alumno registrar(Alumno obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public Alumno modificar(Alumno obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Alumno> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Alumno leerPorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<Alumno> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}{
			return new Alumno();
		}
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return true;
	}

}
