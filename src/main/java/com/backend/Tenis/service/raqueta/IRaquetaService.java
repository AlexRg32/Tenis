package com.backend.Tenis.service.raqueta;

import com.backend.Tenis.entity.Raqueta;

import java.util.List;

public interface IRaquetaService {
    List<Raqueta> findAll();
    Raqueta findById(Long id);
    Raqueta save(Raqueta raqueta);
    void deleteById(Long id);
    Raqueta update(Raqueta raqueta);
}
