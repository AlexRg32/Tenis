package com.backend.Tenis.service.raqueta;

import com.backend.Tenis.entity.Raqueta;
import com.backend.Tenis.repository.raqueta.IRaquetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaquetaService implements IRaquetaService{
    private IRaquetaRepository raquetaRepository;
    @Override
    public List<Raqueta> findAll() {
        return (List<Raqueta>) raquetaRepository.findAll();
    }

    @Override
    public Raqueta findById(Long id) {
        return raquetaRepository.findById(id).orElse(null);
    }

    @Override
    public Raqueta save(Raqueta raqueta) {
        return raquetaRepository.save(raqueta);
    }

    @Override
    public void deleteById(Long id) {
        raquetaRepository.deleteById(id);
    }

    @Override
    public Raqueta update(Raqueta raqueta) {
        return raquetaRepository.save(raqueta);
    }
}
