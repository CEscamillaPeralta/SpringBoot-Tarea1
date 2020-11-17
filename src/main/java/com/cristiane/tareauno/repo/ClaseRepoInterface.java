package com.cristiane.tareauno.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cristiane.tareauno.model.Clase;

@Repository
public interface ClaseRepoInterface extends JpaRepository<Clase, Integer> {

}
