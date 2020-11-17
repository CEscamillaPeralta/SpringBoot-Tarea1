package com.cristiane.tareauno.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristiane.tareauno.model.Clase;
import com.cristiane.tareauno.repo.ClaseRepoInterface;
import com.cristiane.tareauno.service.ClaseService;

@Service
public class ClaseServiceImpl implements ClaseService{

	@Autowired
	private ClaseRepoInterface repo;
	
	@Override
	public Clase registrar(Clase obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public Clase modificar(Clase obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Clase> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Clase leerPorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<Clase> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}{
			return new Clase();
		}
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return true;
	}

}
