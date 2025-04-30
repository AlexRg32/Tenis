package com.backend.Tenis.service.sponsor;

import com.backend.Tenis.entity.Sponsor;
import com.backend.Tenis.repository.sponsor.ISponsorRepository;

import java.util.List;

public class SponsorService implements ISponsorService{

    private ISponsorRepository sponsorRepository;
    @Override
    public List<Sponsor> findAll() {
        return (List<Sponsor>) sponsorRepository.findAll();
    }

    @Override
    public Sponsor findById(Long id) {
        return sponsorRepository.findById(id).orElse(null);
    }

    @Override
    public Sponsor save(Sponsor sponsor) {
        return  sponsorRepository.save(sponsor);
    }

    @Override
    public void deleteById(Long id) {
        sponsorRepository.deleteById(id);
    }

    @Override
    public Sponsor update(Sponsor sponsor) {
        return  sponsorRepository.save(sponsor);
    }
}
