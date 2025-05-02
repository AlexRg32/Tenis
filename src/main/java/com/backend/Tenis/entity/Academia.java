package com.backend.Tenis.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "academia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Academia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Max(value = 250)
    private String nombre;

    @Column
    @Max(value = 100)
    private String ciudad;

    @Column
    @Max(value = 50)
    private String pais;


}
