package com.backend.Tenis.entity.relaciones;

import com.backend.Tenis.entity.Tenista;
import com.backend.Tenis.entity.Torneo;
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
    @JoinColumn(referencedColumnName = "id", name = "torneo_id", nullable = false)
    private Torneo torneo_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "tenista_id", nullable = false)
    private Tenista tenista_id;

    @Column(nullable = false)
    @NotNull(message = "El atributo no puede estar vacío")
    private LocalDateTime fecha;
}




    class GanaId implements Serializable {
    private Long torneoId;
    private Long tenistaId;
}