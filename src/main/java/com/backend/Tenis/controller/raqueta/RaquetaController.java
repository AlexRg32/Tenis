package com.backend.Tenis.controller.raqueta;

import com.backend.Tenis.entity.Raqueta;
import com.backend.Tenis.service.raqueta.IRaquetaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class RaquetaController {

    private IRaquetaService raquetaService;

    public RaquetaController(IRaquetaService raquetaService) {
        this.raquetaService = raquetaService;
    }

    @GetMapping("/raqueta")
    public ResponseEntity<List<Raqueta>> findAll() {
        List<Raqueta> raquetas = raquetaService.findAll();
        return ResponseEntity.ok(raquetas);
    }

    @GetMapping("/raqueta/{id}")
    public ResponseEntity<Raqueta> findById(@PathVariable Long id) {
        Raqueta raqueta = raquetaService.findById(id);
        return ResponseEntity.ok(raqueta);
    }

    @PostMapping("/raqueta")
    public ResponseEntity<Raqueta> save(@RequestBody Raqueta raqueta) {
        Raqueta raquetaSave = raquetaService.save(raqueta);
        return ResponseEntity.ok(raquetaSave);
    }

    @DeleteMapping("/raqueta/{id}")
    public void deleteById(@PathVariable Long id) {
        raquetaService.deleteById(id);

    }

    @PutMapping("/raqueta")
    public ResponseEntity<Raqueta> update(@RequestBody Raqueta raqueta) {
        Raqueta raquetaUpdate = raquetaService.update(raqueta);
        return ResponseEntity.ok(raquetaUpdate);
    }

}
