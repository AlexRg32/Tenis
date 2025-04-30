package com.backend.Tenis.repository.raqueta;

import com.backend.Tenis.entity.Raqueta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRaquetaRepository extends CrudRepository<Raqueta, Long> {
}
