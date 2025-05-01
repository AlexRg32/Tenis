package com.backend.Tenis.dto.tenista;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestTenistaDTO {
    @NotNull
    @Size(max = 50)
    private String nombre;
    @NotNull
    @Size(max = 50)
    private String apellido;
    @NotNull
    @Size(max = 50)
    private String nacionalidad;
}
