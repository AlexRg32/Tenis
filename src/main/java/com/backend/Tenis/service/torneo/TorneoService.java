package com.backend.Tenis.service.torneo;

import com.backend.Tenis.entity.Torneo;
import com.backend.Tenis.repository.torneo.ITorneoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorneoService implements ITorneoService{

    private  ITorneoRepository torneoRepository;

    @Override
    public List<Torneo> findAll() {
        return (List<Torneo>) torneoRepository.findAll();
    }

    @Override
    public Torneo findById(Long id) {
        return torneoRepository.findById(id).orElse(null);
    }

    @Override
    public Torneo save(Torneo torneo) {
        return torneoRepository.save(torneo);
    }

    @Override
    public void deleteById(Long id) {
        torneoRepository.deleteById(id);
    }

    @Override
    public Torneo update(Torneo torneo) {
        return torneoRepository.save(torneo);
    }
}
