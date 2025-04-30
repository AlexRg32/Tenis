package com.backend.Tenis.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "torneo")
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Size(min = 1, max = 50)
    private String nombre;

    @Column
    @Digits(integer = 8, fraction = 2, message = "El premio debe ser un número con hasta 8 dígitos enteros y 2 decimales")
    private BigDecimal premio;

    @Column
    private int puntos;






}
