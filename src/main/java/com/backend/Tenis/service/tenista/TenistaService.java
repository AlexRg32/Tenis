package com.backend.Tenis.service.tenista;

import com.backend.Tenis.entity.Raqueta;
import com.backend.Tenis.entity.Tenista;
import com.backend.Tenis.exception.DeleteEntityException;
import com.backend.Tenis.exception.NotFoundEntityException;
import com.backend.Tenis.repository.tenista.ITenistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenistaService implements ITenistaService {
    private  ITenistaRepository tenistaRepository;

    public TenistaService(ITenistaRepository tenistaRepository) {
        this.tenistaRepository = tenistaRepository;
    }


    @Override
    public List<Tenista> findAll() {
         try{
             return (List<Tenista>) tenistaRepository.findAll();
         }catch (Exception e){
             throw new NotFoundEntityException(null, Tenista.class);
         }
    }

    @Override
    public Tenista findById(Long id) {
        return tenistaRepository.findById(id).orElseThrow(() -> new NotFoundEntityException(id, Tenista.class));
    }

    @Override
    public Tenista save(Tenista tenista) {
        try {
            return tenistaRepository.save(tenista);
         } catch (Exception e){
            throw new NotFoundEntityException(null, Tenista.class);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            tenistaRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteEntityException(id, Tenista.class, e);
        }
    }

    @Override
    public Tenista update(Tenista tenista) {
        try {
            return tenistaRepository.save(tenista);
        }
        catch (Exception e) {
            throw new NotFoundEntityException(null, Tenista.class);
        }
    }
}
