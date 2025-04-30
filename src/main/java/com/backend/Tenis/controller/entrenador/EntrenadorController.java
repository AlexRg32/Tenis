package com.backend.Tenis.controller.entrenador;

import com.backend.Tenis.entity.Entrenador;
import com.backend.Tenis.service.entrenador.EntrenadorService;
import com.backend.Tenis.service.entrenador.IEntrenadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin( origins = "*")
@RestController
@RequestMapping("/api")

public class EntrenadorController {

    private IEntrenadorService entrenadorService;

    public EntrenadorController(IEntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping("/entrenador")
    public ResponseEntity<List<Entrenador>> findAll() {
        List<Entrenador> entrenadores = entrenadorService.findAll();
        return ResponseEntity.ok(entrenadores);
    }

    @GetMapping("entrenador/{id}")
    public ResponseEntity<Entrenador> findById(@PathVariable  Long id) {
        Entrenador entrenador = entrenadorService.findById(id);
        return ResponseEntity.ok(entrenador);
    }

    @PostMapping("entrenador")
    public ResponseEntity<Entrenador> save(@RequestBody Entrenador entrenador) {
        Entrenador entrenadorSave = entrenadorService.save(entrenador);
        return ResponseEntity.ok(entrenadorSave);
    }

    @DeleteMapping("entrenador/{id}")
    public void deleteById(@PathVariable  Long id) {
        entrenadorService.deleteById(id);
    }

    @PutMapping("entrenador")
    public ResponseEntity<Entrenador> update(@RequestBody Entrenador entrenador) {
        Entrenador entrenadorUpdate = entrenadorService.update(entrenador);
        return ResponseEntity.ok(entrenadorUpdate);
    }





}
