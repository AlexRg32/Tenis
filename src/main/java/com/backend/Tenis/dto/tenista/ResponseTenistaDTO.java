package com.backend.Tenis.dto.tenista;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTenistaDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String nacionalidad;
}
