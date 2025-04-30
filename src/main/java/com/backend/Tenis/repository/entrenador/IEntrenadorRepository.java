package com.backend.Tenis.repository.entrenador;

import com.backend.Tenis.entity.Entrenador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEntrenadorRepository extends CrudRepository<Entrenador, Long> {

}

