package com.backend.Tenis.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "entrenador")
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

}
