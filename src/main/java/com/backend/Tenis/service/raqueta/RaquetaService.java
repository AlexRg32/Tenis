package com.backend.Tenis.service.raqueta;

import com.backend.Tenis.entity.Raqueta;
import com.backend.Tenis.exception.CreateEntityException;
import com.backend.Tenis.exception.DeleteEntityException;
import com.backend.Tenis.exception.NotFoundEntityException;
import com.backend.Tenis.repository.raqueta.IRaquetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaquetaService implements IRaquetaService{
    private IRaquetaRepository raquetaRepository;

    public RaquetaService(IRaquetaRepository raquetaRepository) {
        this.raquetaRepository = raquetaRepository;
    }
    @Override
    public List<Raqueta> findAll() {
        try{
            return (List<Raqueta>) raquetaRepository.findAll();
        }catch (Exception e){
            throw new NotFoundEntityException(null, Raqueta.class);
        }
    }

    @Override
    public Raqueta findById(Long id) {
        return raquetaRepository.findById(id).orElseThrow(() -> new NotFoundEntityException(id, Raqueta.class));
    }

    @Override
    public Raqueta save(Raqueta raqueta) {
        try {
             return raquetaRepository.save(raqueta);
        } catch (Exception e){
            throw new CreateEntityException( Raqueta.class, e);
        }

    }

    @Override
    public void deleteById(Long id) {
        try {
            raquetaRepository.deleteById(id);
        }catch (Exception e){
            throw new DeleteEntityException(id,Raqueta.class, e);
        }
    }

    @Override
    public Raqueta update(Raqueta raqueta) {
        return raquetaRepository.save(raqueta);
    }
}
