package com.backend.Tenis.controller.raqueta;

import com.backend.Tenis.dto.raqueta.RequestRaquetaDTO;
import com.backend.Tenis.dto.raqueta.ResponseRaquetaDTO;
import com.backend.Tenis.entity.Raqueta;
import com.backend.Tenis.mapper.raqueta.RaquetaMapper;
import com.backend.Tenis.service.raqueta.IRaquetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class RaquetaController {

    private IRaquetaService raquetaService;

    @Autowired
    private RaquetaMapper raquetaMapper;


    public RaquetaController(IRaquetaService raquetaService) {
        this.raquetaService = raquetaService;
    }

    @GetMapping("/raqueta")
    public ResponseEntity<List<ResponseRaquetaDTO>> findAll() {
        List<Raqueta> raquetas = raquetaService.findAll();
        List<ResponseRaquetaDTO> raquetaDTOS = raquetaMapper.toResponseRaquetaDTOList(raquetas);
        return ResponseEntity.ok(raquetaDTOS);
    }

    @GetMapping("/raqueta/{id}")
    public ResponseEntity<ResponseRaquetaDTO> findById(@Valid @PathVariable Long id) {
        Raqueta raqueta = raquetaService.findById(id);
        ResponseRaquetaDTO raquetaDTO = raquetaMapper.toResponseRaquetaDTO(raqueta);
        return ResponseEntity.ok(raquetaDTO);
    }

    @PostMapping("/raqueta")
    public ResponseEntity<RequestRaquetaDTO> save(@Valid @RequestBody Raqueta raqueta) {
        Raqueta raquetaSave = raquetaService.save(raqueta);
        RequestRaquetaDTO raquetaDTO = raquetaMapper.toRequestRaquetaDTO(raquetaSave);
        return ResponseEntity.ok(raquetaDTO);
    }

    @DeleteMapping("/raqueta/{id}")
    public void deleteById(@PathVariable Long id) {
        raquetaService.deleteById(id);

    }

    @PutMapping("/raqueta")
    public ResponseEntity<ResponseRaquetaDTO> update(@Valid @RequestBody Raqueta raqueta) {
        Raqueta raquetaUpdate = raquetaService.update(raqueta);
        ResponseRaquetaDTO raquetaDTO = raquetaMapper.toResponseRaquetaDTO(raquetaUpdate);
        return ResponseEntity.ok(raquetaDTO);
    }

}
