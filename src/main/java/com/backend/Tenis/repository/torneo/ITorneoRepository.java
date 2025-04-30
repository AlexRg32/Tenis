package com.backend.Tenis.repository.torneo;

import com.backend.Tenis.entity.Torneo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITorneoRepository extends CrudRepository<Torneo, Long> {
}
