package com.backend.Tenis.controller.torneo;

import com.backend.Tenis.entity.Torneo;
import com.backend.Tenis.service.torneo.TorneoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TorneoController {

    private  TorneoService torneoService;

    public TorneoController(TorneoService torneoService) {
        this.torneoService = torneoService;
    }

    @GetMapping("/torneo")
    public ResponseEntity<List<Torneo>> findAll() {
        List<Torneo> torneos = torneoService.findAll();
        return ResponseEntity.ok(torneos);
    }

    @GetMapping("/torneo/{id}")
    public ResponseEntity<Torneo> findById(@PathVariable Long id) {
        Torneo torneo = torneoService.findById(id);
        return ResponseEntity.ok(torneo);
    }

    @PostMapping("/torneo")
    public ResponseEntity<Torneo> save(@RequestBody Torneo torneo) {
        Torneo torneoSave = torneoService.save(torneo);
        return ResponseEntity.ok(torneoSave);
    }

    @DeleteMapping("/torneo/{id}")
    public void deleteById(@PathVariable Long id) {
        torneoService.deleteById(id);
    }

    @PutMapping("/torneo")
    public ResponseEntity<Torneo> update(@RequestBody Torneo torneo) {
        Torneo torneoUpdate = torneoService.update(torneo);
        return ResponseEntity.ok(torneoUpdate);
    }
}
