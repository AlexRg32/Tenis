package com.backend.Tenis.repository.ficha;

import com.backend.Tenis.entity.relaciones.Ficha;
import com.backend.Tenis.entity.relaciones.FichaId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFichaRepository extends CrudRepository<Ficha, FichaId> {
}
