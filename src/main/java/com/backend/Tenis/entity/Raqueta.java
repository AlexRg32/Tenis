package com.backend.Tenis.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "raqueta")
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
}
