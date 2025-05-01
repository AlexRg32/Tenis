package com.backend.Tenis.dto.raqueta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestRaquetaDTO {
    private String marca;
    private String modelo;
}
