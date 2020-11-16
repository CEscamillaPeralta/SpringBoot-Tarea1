package com.cristiane.tareauno.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cristiane.tareauno.model.Alumno;

@Repository
public interface AlumnoRepoInterface extends JpaRepository<Alumno, Integer>{

}
