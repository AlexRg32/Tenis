package com.backend.Tenis.repository.tenista;

import com.backend.Tenis.entity.Tenista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITenistaRepository extends CrudRepository<Tenista, Long> {

}
