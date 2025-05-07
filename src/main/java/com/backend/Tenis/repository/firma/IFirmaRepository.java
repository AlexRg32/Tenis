package com.backend.Tenis.repository.firma;

import com.backend.Tenis.entity.relaciones.Firma;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFirmaRepository extends CrudRepository<Firma, Long> {
}
