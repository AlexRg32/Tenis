package com.backend.Tenis.service.entrenador;

import com.backend.Tenis.entity.Entrenador;
import com.backend.Tenis.repository.entrenador.IEntrenadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService implements IEntrenadorService{

    private IEntrenadorRepository entrenadorRepository;

    public EntrenadorService(IEntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }
    @Override
    public List<Entrenador> findAll() {
        return (List<Entrenador>) entrenadorRepository.findAll();
    }

    @Override
    public Entrenador findById(Long id) {
        return entrenadorRepository.findById(id).orElse(null);
    }

    @Override
    public Entrenador save(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    @Override
    public void deleteById(Long id) {
        entrenadorRepository.deleteById(id);
    }

    @Override
    public Entrenador update(Entrenador entrenador) {
        if (entrenadorRepository.existsById(entrenador.getId())) {
            return entrenadorRepository.save(entrenador);
        } else {
            return null;
        }
    }
}
