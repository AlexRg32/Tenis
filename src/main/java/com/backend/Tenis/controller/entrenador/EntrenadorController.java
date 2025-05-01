package com.backend.Tenis.controller.entrenador;

import com.backend.Tenis.dto.entrenador.RequestEntrenadorDTO;
import com.backend.Tenis.dto.entrenador.ResponseEntrenadorDTO;
import com.backend.Tenis.entity.Entrenador;
import com.backend.Tenis.mapper.entrenador.EntrenadorMapper;
import com.backend.Tenis.service.entrenador.EntrenadorService;
import com.backend.Tenis.service.entrenador.IEntrenadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin( origins = "*")
@RestController
@RequestMapping("/api")

public class EntrenadorController {

    private IEntrenadorService entrenadorService;

    @Autowired
    private EntrenadorMapper entrenadorMapper;

    public EntrenadorController(IEntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping("/entrenador")
    public ResponseEntity<List<ResponseEntrenadorDTO>> findAll() {
        List<Entrenador> entrenadores = entrenadorService.findAll();
        List<ResponseEntrenadorDTO> entrenadorDTOS = entrenadorMapper.toResponseEntrenadorDTOList(entrenadores);
        return ResponseEntity.ok(entrenadorDTOS);
    }

    @GetMapping("entrenador/{id}")
    public ResponseEntity<ResponseEntrenadorDTO> findById(@Valid @PathVariable  Long id) {
        Entrenador entrenador = entrenadorService.findById(id);
        ResponseEntrenadorDTO entrenadorDTO = entrenadorMapper.toResponseEntrenadorDTO(entrenador);
        return ResponseEntity.ok(entrenadorDTO);
    }

    @PostMapping("entrenador")
    public ResponseEntity<RequestEntrenadorDTO> save(@Valid @RequestBody Entrenador entrenador) {
        Entrenador entrenadorSave = entrenadorService.save(entrenador);
        RequestEntrenadorDTO entrenadorDTO = entrenadorMapper.toRequestEntrenadorDTO(entrenadorSave);
        return ResponseEntity.ok(entrenadorDTO);
    }

    @DeleteMapping("entrenador/{id}")
    public void deleteById(@PathVariable  Long id) {
        entrenadorService.deleteById(id);
    }

    @PutMapping("entrenador")
    public ResponseEntity<ResponseEntrenadorDTO> update(@Valid @RequestBody Entrenador entrenador) {
        Entrenador entrenadorUpdate = entrenadorService.update(entrenador);
        ResponseEntrenadorDTO entrenadorDTO = entrenadorMapper.toResponseEntrenadorDTO(entrenadorUpdate);
        return ResponseEntity.ok(entrenadorDTO);
    }





}
