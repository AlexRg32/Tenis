package com.backend.Tenis.dto.torneo;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTorneoDTO {
    private Long id;
    private String nombre;
    private BigDecimal premio;
    private int puntos;

}
