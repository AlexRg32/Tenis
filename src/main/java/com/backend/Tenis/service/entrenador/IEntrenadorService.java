package com.backend.Tenis.service.entrenador;

import com.backend.Tenis.entity.Entrenador;
import com.backend.Tenis.repository.entrenador.IEntrenadorRepository;

import java.util.List;

public interface IEntrenadorService  {
    List<Entrenador> findAll();
    Entrenador findById(Long id);
    Entrenador save(Entrenador entrenador);
    void deleteById(Long id);
    Entrenador update(Entrenador entrenador);
}
