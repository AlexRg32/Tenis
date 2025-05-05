package com.backend.Tenis.service.tenista;

import com.backend.Tenis.entity.Raqueta;
import com.backend.Tenis.entity.Tenista;
import com.backend.Tenis.entity.Torneo;
import com.backend.Tenis.entity.relaciones.Gana;
import com.backend.Tenis.exception.DeleteEntityException;
import com.backend.Tenis.exception.NotFoundEntityException;
import com.backend.Tenis.repository.tenista.ITenistaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

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

    @Override
    public int obtenerPuntosTenista(Long id) {
        int puntos = 0;
        try{
            Tenista tenista = tenistaRepository.findById(id).orElseThrow(() -> new NotFoundEntityException(id, Tenista.class));
            List<Gana> torneosGanados = tenista.getTorneos();
            for(int i = 0; i < torneosGanados.size(); i++){
                puntos++;
            }
            return puntos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Torneo> torneoGanadosPorTenista(Long id) {
        List<Torneo> torneos = new ArrayList<>();

        try{
            Tenista tenista = tenistaRepository.findById(id).orElseThrow(() -> new NotFoundEntityException(id, Tenista.class));
            List<Gana> torneosGanados = tenista.getTorneos();
            for (Gana torneosGanado : torneosGanados) {
                torneos.add(torneosGanado.getTorneo());
                System.out.println(torneosGanado.getTenista());
            }

            return torneos;
        }
        catch (Exception e){
            throw new RuntimeException(e);

        }

    }
}
