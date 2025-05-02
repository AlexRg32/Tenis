package com.backend.Tenis.service.academia;

import com.backend.Tenis.entity.Academia;
import com.backend.Tenis.repository.academia.IAcademiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademiaService implements IAcademiaService {

    private IAcademiaRepository academiaRepository;

    public AcademiaService(IAcademiaRepository academiaRepository) {
        this.academiaRepository = academiaRepository;
    }


    @Override
    public List<Academia> findAll() {
        return (List<Academia>) academiaRepository.findAll();
    }

    @Override
    public Academia findById(Long id) {
        return academiaRepository.findById(id).orElse(null);
    }

    @Override
    public Academia save(Academia academia) {
        return academiaRepository.save(academia);
    }

    @Override
    public void deleteById(Long id) {
        academiaRepository.deleteById(id);

    }

    @Override
    public Academia update(Academia academia) {
        if (academiaRepository.existsById(academia.getId())) {
            return academiaRepository.save(academia);
        }
        else
            {
                return null;
            }

    }
}
