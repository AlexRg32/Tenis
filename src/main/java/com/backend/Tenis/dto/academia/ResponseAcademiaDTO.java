package com.backend.Tenis.dto.academia;

import com.backend.Tenis.entity.Tenista;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAcademiaDTO {
    private Long id;
    private String nombre;
    private String ciudad;
    private String pais;
    private List<Tenista> tenistas;
}
