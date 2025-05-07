package com.backend.Tenis.entity;

import com.backend.Tenis.entity.relaciones.Ficha;
import com.backend.Tenis.entity.relaciones.Firma;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sponsor")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nombre")
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Size(min = 1, max = 50)
    private String nombre;

    @Column
    @Size( min = 1, max = 50)
    private String pais;

    @OneToMany(mappedBy = "sponsor", cascade = CascadeType.ALL)
    private List<Firma> tenistas;


}
