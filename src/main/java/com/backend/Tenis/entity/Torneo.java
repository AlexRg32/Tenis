package com.backend.Tenis.entity;

import com.backend.Tenis.entity.relaciones.Gana;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "torneo")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nombre")
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



    @OneToMany(mappedBy = "torneo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Gana> tenistas = new ArrayList<>();








}
