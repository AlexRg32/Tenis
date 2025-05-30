package com.backend.Tenis.controller.tenista;

import com.backend.Tenis.dto.sponsor.AñadirSponsorDTO;
import com.backend.Tenis.dto.torneo.AñadirTorneoDTO;
import com.backend.Tenis.dto.tenista.RequestTenistaDTO;
import com.backend.Tenis.dto.tenista.ResponseTenistaDTO;
import com.backend.Tenis.entity.Tenista;
import com.backend.Tenis.mapper.tenista.TenistaMapper;
import com.backend.Tenis.service.tenista.ITenistaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TenistaController {

    private ITenistaService tenistaService;

    @Autowired
    private TenistaMapper tenistaMapper;

    public TenistaController(ITenistaService tenistaService) {
        this.tenistaService = tenistaService;
    }
    @GetMapping("/tenista")
    public ResponseEntity<List<ResponseTenistaDTO>> findAll() {
        List<Tenista> tenistas = tenistaService.findAll();
        List<ResponseTenistaDTO> tenistasDTO = tenistaMapper.toResponseTenistaDTOList(tenistas);
        return ResponseEntity.ok(tenistasDTO);
    }

    @GetMapping("/tenista/{id}")
    public ResponseEntity<ResponseTenistaDTO> findById(@Valid @PathVariable Long id) {
        Tenista tenista = tenistaService.findById(id);
        ResponseTenistaDTO tenistaDTO = tenistaMapper.toResponseTenistaDTO(tenista);
        return ResponseEntity.ok(tenistaDTO);
    }

    @PostMapping("/tenista")
    public ResponseEntity<RequestTenistaDTO> save(@Valid @RequestBody Tenista tenista) {
        Tenista tenistaSave = tenistaService.save(tenista);
        RequestTenistaDTO tenistaDTO = tenistaMapper.toRequestTenistaDTO(tenistaSave);
        return ResponseEntity.ok(tenistaDTO);
    }

    @DeleteMapping("/tenista/{id}")
    public void deleteById(@PathVariable Long id) {
        tenistaService.deleteById(id);
    }

    @PutMapping("/tenista")
    public ResponseEntity<ResponseTenistaDTO> update(@Valid @RequestBody Tenista tenista) {
        Tenista tenistaUpdate = tenistaService.update(tenista);
        ResponseTenistaDTO tenistaDTO = tenistaMapper.toResponseTenistaDTO(tenistaUpdate);
        return ResponseEntity.ok(tenistaDTO);
    }

    @PostMapping("/tenista/añadirSponsor")
    public ResponseEntity<ResponseTenistaDTO> addSponsor(@Valid @RequestBody AñadirSponsorDTO añadirSponsorDTO) {
        Tenista tenista = tenistaService.agregarSponsor(añadirSponsorDTO);
        ResponseTenistaDTO tenistaDTO = tenistaMapper.toResponseTenistaDTO(tenista);
        return ResponseEntity.ok(tenistaDTO);
    }

    @PostMapping("/tenista/añadirTorneo")
    public ResponseEntity<ResponseTenistaDTO> addTorneo(@Valid @RequestBody AñadirTorneoDTO torneoDTO) {
        System.out.println("ID TENISTA: " + torneoDTO.getTenistaId());
        Tenista tenista = tenistaService.ganarTorneo(torneoDTO);
        System.out.println("ID TENISTA: " + tenista.getId());
        ResponseTenistaDTO tenistaDTO = tenistaMapper.toResponseTenistaDTO(tenista);
        return ResponseEntity.ok(tenistaDTO);

    }

    @DeleteMapping("/tenista/borrarTenista/{id}")
    public ResponseEntity<Void> borrarTenista(@Valid @PathVariable Long id) {
      tenistaService.borrarTenista(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/tenista/ficharEntrenador/{idTenista}/{idEntrenador}")
    public ResponseEntity<ResponseTenistaDTO> ficharEntrenador(@PathVariable Long idTenista, @PathVariable Long idEntrenador) {
        Tenista tenista = tenistaService.ficharEntrenador(idTenista, idEntrenador);
        ResponseTenistaDTO tenistaDTO = tenistaMapper.toResponseTenistaDTO(tenista);
        return ResponseEntity.ok(tenistaDTO);
    }






}
