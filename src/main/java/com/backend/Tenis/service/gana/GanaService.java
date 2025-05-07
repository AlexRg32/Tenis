package com.backend.Tenis.service.gana;

import com.backend.Tenis.entity.relaciones.Gana;
import com.backend.Tenis.repository.gana.IGanaRepository;

public class GanaService implements IGanaService {
    private IGanaRepository ganaRepository;
    public GanaService(IGanaRepository ganaRepository) {
        this.ganaRepository = ganaRepository;
    }
    @Override
    public Gana save(Gana gana) {
            return ganaRepository.save(gana);
    }
}
