package com.backend.Tenis.entity;

import com.backend.Tenis.entity.relaciones.Ficha;
import com.backend.Tenis.entity.relaciones.Firma;
import com.backend.Tenis.entity.relaciones.Gana;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tenista")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nombre")
public class Tenista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Size(min = 1, max = 50)
    private String nombre;

    @Column
    @Size(min = 1, max = 50)
    private String apellido;

    @Column
    @Size(min = 1, max = 50)
    private String nacionalidad;


    @OneToMany(mappedBy = "tenista")
    private List<Gana> torneos = new ArrayList<>();


    @OneToMany(mappedBy = "tenista")
    private List<Firma> sponsors;

    @ManyToMany
    @JoinTable(name = "compra", joinColumns = @JoinColumn(name = "tenista_id")
            , inverseJoinColumns = @JoinColumn(name = "raqueta_id"))
    private List<Raqueta> raquetas;

    @OneToMany(mappedBy = "tenista")
    private List<Ficha> entrenadores;





}