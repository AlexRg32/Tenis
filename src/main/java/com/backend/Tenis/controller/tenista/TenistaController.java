package com.backend.Tenis.controller.tenista;

import com.backend.Tenis.entity.Tenista;
import com.backend.Tenis.service.tenista.ITenistaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenista")
@CrossOrigin(origins = "*")
public class TenistaController {

    private ITenistaService tenistaService;

    public TenistaController(ITenistaService tenistaService) {
        this.tenistaService = tenistaService;
    }
    @GetMapping("/tenista")
    public ResponseEntity<List<Tenista>> findAll() {
        List<Tenista> tenistas = tenistaService.findAll();
        return ResponseEntity.ok(tenistas);
    }

    @GetMapping("/tenista/{id}")
    public ResponseEntity<Tenista> findById(@PathVariable Long id) {
        Tenista tenista = tenistaService.findById(id);
        return ResponseEntity.ok(tenista);
    }

    @PostMapping("/tenista")
    public ResponseEntity<Tenista> save(@RequestBody Tenista tenista) {
        Tenista tenistaSave = tenistaService.save(tenista);
        return ResponseEntity.ok(tenistaSave);
    }

    @DeleteMapping("/tenista/{id}")
    public void deleteById(@PathVariable Long id) {
        tenistaService.deleteById(id);
    }

    @PutMapping("/tenista")
    public ResponseEntity<Tenista> update(@RequestBody Tenista tenista) {
        Tenista tenistaUpdate = tenistaService.update(tenista);
        return ResponseEntity.ok(tenistaUpdate);
    }


}
