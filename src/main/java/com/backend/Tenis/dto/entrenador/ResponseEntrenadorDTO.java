package com.backend.Tenis.dto.entrenador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntrenadorDTO {
    private Long id;
    private String nombre;
    private String email;
}
