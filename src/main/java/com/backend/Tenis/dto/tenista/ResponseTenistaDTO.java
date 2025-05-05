package com.backend.Tenis.dto.tenista;

import com.backend.Tenis.entity.Torneo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTenistaDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private List<Torneo> torneos;
}
