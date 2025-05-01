package com.backend.Tenis.dto.raqueta;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestRaquetaDTO {
    @NotNull
    @Size(max = 100)
    private String marca;
    @NotNull
    @Size(max = 100)
    private String modelo;
}
