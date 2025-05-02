package com.backend.Tenis.dto.entrenador;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestEntrenadorDTO {
    @NotNull
    @Size( max = 50)
    private String nombre;

    @Email
    @NotNull
    @Size( max = 50)
    private String email;

    @NotNull
    private boolean activo;
}
