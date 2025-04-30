package com.backend.Tenis.service.torneo;

import com.backend.Tenis.entity.Torneo;

import java.util.List;

public interface ITorneoService {
    List<Torneo> findAll();
    Torneo findById(Long id);
    Torneo save(Torneo torneo);
    void deleteById(Long id);
    Torneo update(Torneo torneo);
}
