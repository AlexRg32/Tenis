package com.backend.Tenis.dto.raqueta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseRaquetaDTO {
    private Long id;
    private String marca;
    private String modelo;
}
