package com.backend.Tenis.entity;

import com.backend.Tenis.entity.relaciones.Ficha;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "entrenador")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nombre")
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Size(min = 3, max = 50)
    private String nombre;

    @Column
    @Email
    @Size(min = 3, max = 50)
    private String email;

    @Column
    private boolean activo;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "academia_id")
    private Academia academia;

    @OneToMany(mappedBy = "entrenador")
    private List<Ficha> fichas;

}
