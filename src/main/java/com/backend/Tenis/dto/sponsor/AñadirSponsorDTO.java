package com.backend.Tenis.dto.sponsor;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AñadirSponsorDTO {
    long sponsor_id;
    long tenista_id;
    LocalDateTime fecha_inicio;
    LocalDateTime fecha_fin;
    double saldo;

}
