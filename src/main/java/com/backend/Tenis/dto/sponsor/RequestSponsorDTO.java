package com.backend.Tenis.dto.sponsor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestSponsorDTO {
    @NotNull
    @Size(max = 50)
    private String nombre;
}
