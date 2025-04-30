package com.backend.Tenis.service.tenista;

import com.backend.Tenis.entity.Tenista;

import java.util.List;

public interface ITenistaService {
    List<Tenista> findAll();
    Tenista findById(Long id);
    Tenista save(Tenista tenista);
    void deleteById(Long id);
    Tenista update(Tenista tenista);
}
