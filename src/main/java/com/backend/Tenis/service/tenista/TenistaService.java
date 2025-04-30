package com.backend.Tenis.service.tenista;

import com.backend.Tenis.entity.Tenista;
import com.backend.Tenis.repository.tenista.ITenistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenistaService implements ITenistaService {
    private  ITenistaRepository tenistaRepository;

    @Override
    public List<Tenista> findAll() {
        return (List<Tenista>) tenistaRepository.findAll();
    }

    @Override
    public Tenista findById(Long id) {
        return tenistaRepository.findById(id).orElse(null);
    }

    @Override
    public Tenista save(Tenista tenista) {
        return tenistaRepository.save(tenista);
    }

    @Override
    public void deleteById(Long id) {
        tenistaRepository.deleteById(id);
    }

    @Override
    public Tenista update(Tenista tenista) {
        return tenistaRepository.save(tenista);
    }
}
