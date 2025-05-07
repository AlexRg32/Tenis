package com.backend.Tenis.entity.relaciones;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FichaId implements Serializable {

    @Column( name = "tenista_id")
    private long tenistaId;
    @Column( name = "entrenador_id")
    private long entrenadorId;
}
