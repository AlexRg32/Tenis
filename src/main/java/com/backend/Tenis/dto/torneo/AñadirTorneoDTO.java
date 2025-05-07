package com.backend.Tenis.dto.torneo;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AñadirTorneoDTO {
    private Long tenistaId;
    private List<Long> torneosId;
    private LocalDateTime fecha;
}
