package com.backend.Tenis.entity.relaciones;

import com.backend.Tenis.entity.Sponsor;
import com.backend.Tenis.entity.Tenista;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "firma")
public class Firma {

    @EmbeddedId
    private FirmaId id;

    @Column
    @Digits(integer = 4, fraction = 2, message = "El saldo debe ser un número con hasta 4 dígitos enteros y 2 decimales")
    private BigDecimal saldo;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @ManyToOne
    @MapsId("sponsorId") // Relación con Sponsor
    @JoinColumn(name = "sponsor_id", nullable = false)
    private Sponsor sponsor;

    @ManyToOne
    @MapsId("tenistaId") // Relación con Tenista
    @JoinColumn(name = "tenista_id", nullable = false)
    private Tenista tenista;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
class FirmaId implements Serializable {
    private Long sponsorId;
    private Long tenistaId;
}