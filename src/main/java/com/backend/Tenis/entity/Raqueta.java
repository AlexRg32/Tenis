package com.backend.Tenis.entity;

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
@Table(name = "raqueta")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "marca")
public class Raqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Size(min = 1, max = 100)
    private String marca;

    @Column
    @Size(min = 1, max = 100)
    private String modelo;

    @ManyToMany(mappedBy = "raquetas")
    private List<Tenista> tenistas;
}
