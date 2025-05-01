package com.backend.Tenis.service.torneo;

import com.backend.Tenis.entity.Raqueta;
import com.backend.Tenis.entity.Torneo;
import com.backend.Tenis.exception.DeleteEntityException;
import com.backend.Tenis.exception.NotFoundEntityException;
import com.backend.Tenis.repository.torneo.ITorneoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorneoService implements ITorneoService{

    private  ITorneoRepository torneoRepository;

    public TorneoService(ITorneoRepository torneoRepository) {
        this.torneoRepository = torneoRepository;
    }

    @Override
    public List<Torneo> findAll() {
        try{
            return (List<Torneo>) torneoRepository.findAll();
        }catch (Exception e){
            throw new NotFoundEntityException(null, Torneo.class);
        }

    }

    @Override
    public Torneo findById(Long id) {
        return torneoRepository.findById(id).orElseThrow(() -> new NotFoundEntityException(id, Torneo.class));
    }

    @Override
    public Torneo save(Torneo torneo) {
       try {
           return torneoRepository.save(torneo);
       }
       catch (Exception e){
           throw new NotFoundEntityException(null, Torneo.class);
       }
    }

    @Override
    public void deleteById(Long id) {
        try {
            torneoRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteEntityException(id, Torneo.class, e);
        }
    }

    @Override
    public Torneo update(Torneo torneo) {
        try {
            return torneoRepository.save(torneo);
        } catch (Exception e) {
            throw new NotFoundEntityException(null, Torneo.class);
        }
    }
}
