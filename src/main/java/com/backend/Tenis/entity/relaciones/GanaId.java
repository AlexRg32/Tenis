package com.backend.Tenis.entity.relaciones;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
   public class GanaId implements Serializable {
    private long torneoId;
    private long tenistaId;
}
