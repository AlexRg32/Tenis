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
public class RequestTorneoDTO {
    @Size(min = 1, max = 50)
    private String nombre;

    @Digits(integer = 8, fraction = 2, message = "El premio debe ser un número con hasta 8 dígitos enteros y 2 decimales")
    private BigDecimal premio;

    private int puntos;

}
