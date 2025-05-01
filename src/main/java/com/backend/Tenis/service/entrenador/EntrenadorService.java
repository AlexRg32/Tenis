package com.backend.Tenis.service.entrenador;

import com.backend.Tenis.entity.Entrenador;
import com.backend.Tenis.exception.DeleteEntityException;
import com.backend.Tenis.exception.NotFoundEntityException;
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
        try{
             return (List<Entrenador>) entrenadorRepository.findAll();
        }catch (Exception e){
            throw new NotFoundEntityException(null, Entrenador.class);
        }

    }

    @Override
    public Entrenador findById(Long id) {
        return entrenadorRepository.findById(id).orElseThrow(() ->new NotFoundEntityException(id, Entrenador.class));
    }

    @Override
    public Entrenador save(Entrenador entrenador) {
        try {
            return entrenadorRepository.save(entrenador);
        } catch (Exception e){
            throw new NotFoundEntityException(null, Entrenador.class);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            entrenadorRepository.deleteById(id);
        }catch (Exception e){
            throw new DeleteEntityException(id, Entrenador.class, e);

        }
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
