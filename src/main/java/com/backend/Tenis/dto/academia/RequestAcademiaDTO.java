package com.backend.Tenis.dto.academia;

import com.backend.Tenis.entity.Tenista;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestAcademiaDTO {
    @NotNull
    @Size(min = 1, max = 250)
    private String nombre;
    @NotNull
    @Size(min = 1, max = 100)
    private String ciudad;
    @NotNull
    @Size(min = 1, max = 50)
    private String pais;

    private List<Tenista> tenistas;

}
