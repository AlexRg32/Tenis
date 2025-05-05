package com.backend.Tenis.entity.relaciones;

import com.backend.Tenis.entity.Tenista;
import com.backend.Tenis.entity.Torneo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gana")
public class Gana {

    @EmbeddedId
    private GanaId id;

    @ManyToOne
    @MapsId("torneoId")
    @JoinColumn(referencedColumnName = "id", name = "torneo_id", nullable = false)

    private Torneo torneo;

    @ManyToOne
    @MapsId("tenistaId")

    @JoinColumn(referencedColumnName = "id", name = "tenista_id", nullable = false)
    private Tenista tenista;

    @Column(nullable = false)
    @NotNull(message = "El atributo no puede estar vacío")
    private LocalDateTime fecha;
}



    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    class GanaId implements Serializable {
    private long torneoId;
    private long tenistaId;
}