package com.backend.Tenis.entity.relaciones;

import com.backend.Tenis.entity.Entrenador;
import com.backend.Tenis.entity.Tenista;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ficha")
public class Ficha {

    @EmbeddedId
    private FichaId id;

    @ManyToOne
    @MapsId("tenistaId")
    @JoinColumn( referencedColumnName = "id", name = "tenista_id", nullable = false)
    private Tenista tenista;

    @ManyToOne
    @MapsId("entrenadorId")
    @JoinColumn( referencedColumnName = "id", name = "entrenador_id", nullable = false)
    private Entrenador entrenador;

    @Column
    private LocalDateTime fechaFin;


}
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
class FichaId implements Serializable {

    @Column( name = "tenista_id")
    private long tenistaId;
    @Column( name = "entrenador_id")
    private long entrenadorId;
}
