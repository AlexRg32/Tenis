package com.backend.Tenis.service.tenista;

import com.backend.Tenis.dto.sponsor.AñadirSponsorDTO;
import com.backend.Tenis.dto.torneo.AñadirTorneoDTO;
import com.backend.Tenis.entity.Tenista;

import java.util.List;

public interface ITenistaService {
    List<Tenista> findAll();
    Tenista findById(Long id);
    Tenista save(Tenista tenista);
    void deleteById(Long id);
    Tenista update(Tenista tenista);
  Tenista agregarSponsor(AñadirSponsorDTO sponsorDTO);
  Tenista ganarTorneo(AñadirTorneoDTO añadirTorneoDTO);
    void  borrarTenista(Long id);
    Tenista ficharEntrenador(Long idTenista, Long idEntrenador);
}
