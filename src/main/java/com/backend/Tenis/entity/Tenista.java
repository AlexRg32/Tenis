package com.backend.Tenis.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tenista")
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


}