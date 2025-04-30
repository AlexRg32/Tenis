package com.backend.Tenis.service.sponsor;

import com.backend.Tenis.entity.Sponsor;

import java.util.List;

public interface ISponsorService {
    List<Sponsor> findAll();
    Sponsor findById(Long id);
    Sponsor save(Sponsor sponsor);
    void deleteById(Long id);
    Sponsor update(Sponsor sponsor);
}
