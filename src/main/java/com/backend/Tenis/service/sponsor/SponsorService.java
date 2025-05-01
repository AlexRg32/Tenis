package com.backend.Tenis.service.sponsor;

import com.backend.Tenis.entity.Raqueta;
import com.backend.Tenis.entity.Sponsor;
import com.backend.Tenis.exception.DeleteEntityException;
import com.backend.Tenis.exception.NotFoundEntityException;
import com.backend.Tenis.repository.sponsor.ISponsorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SponsorService implements ISponsorService{

    private ISponsorRepository sponsorRepository;

    public SponsorService(ISponsorRepository sponsorRepository) {
        this.sponsorRepository = sponsorRepository;
    }
    @Override
    public List<Sponsor> findAll() {
         try{
             return (List<Sponsor>) sponsorRepository.findAll();
         } catch (Exception e){
             throw new NotFoundEntityException(null, Sponsor.class);
         }
    }

    @Override
    public Sponsor findById(Long id) {
        return sponsorRepository.findById(id).orElseThrow(() -> new NotFoundEntityException(id, Sponsor.class));
    }

    @Override
    public Sponsor save(Sponsor sponsor) {
        try {
            return sponsorRepository.save(sponsor);
         } catch (Exception e) {
            throw new NotFoundEntityException(null, Sponsor.class);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            sponsorRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteEntityException(id, Sponsor.class, e);
        }
    }

    @Override
    public Sponsor update(Sponsor sponsor) {
        try {
            return sponsorRepository.save(sponsor);
        }
        catch (Exception e) {
            throw new NotFoundEntityException(null, Sponsor.class);
        }
    }
}
