package com.backend.Tenis.repository.gana;

import com.backend.Tenis.entity.relaciones.Gana;
import com.backend.Tenis.entity.relaciones.GanaId;
import org.springframework.data.repository.CrudRepository;

public interface IGanaRepository extends CrudRepository<Gana, GanaId> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
