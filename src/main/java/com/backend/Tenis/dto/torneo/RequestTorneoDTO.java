package com.backend.Tenis.dto.torneo;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String nombre;

    @NotNull
    @Digits(integer = 8, fraction = 2, message = "El premio debe ser un número con hasta 8 dígitos enteros y 2 decimales")
    private BigDecimal premio;

    @NotNull
    @Max(value = 2000, message = "El valor máximo de los puntos es 2000")
    @Min(value = 250, message = "El valor mínimo de los puntos es 250")
    private int puntos;

}
