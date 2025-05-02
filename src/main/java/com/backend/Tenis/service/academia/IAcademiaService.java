package com.backend.Tenis.service.academia;

import com.backend.Tenis.entity.Academia;

import java.util.List;

public interface IAcademiaService {
    List<Academia>  findAll();
    Academia findById(Long id);
    Academia save(Academia academia);
    void deleteById(Long id);
    Academia update(Academia academia);
}
