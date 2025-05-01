package com.backend.Tenis.controller.torneo;

import com.backend.Tenis.dto.torneo.RequestTorneoDTO;
import com.backend.Tenis.dto.torneo.ResponseTorneoDTO;
import com.backend.Tenis.entity.Torneo;
import com.backend.Tenis.mapper.torneo.TorneoMapper;
import com.backend.Tenis.service.torneo.TorneoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TorneoController {

    private  TorneoService torneoService;

    @Autowired
    private TorneoMapper torneoMapper;

    public TorneoController(TorneoService torneoService) {
        this.torneoService = torneoService;
    }

    @GetMapping("/torneo")
    public ResponseEntity<List<ResponseTorneoDTO>> findAll() {
        List<Torneo> torneos = torneoService.findAll();
        List<ResponseTorneoDTO> responseTorneoDTOList = torneoMapper.toResponseTorneoDTOList(torneos);
        return ResponseEntity.ok(responseTorneoDTOList);
    }

    @GetMapping("/torneo/{id}")
    public ResponseEntity<ResponseTorneoDTO> findById(@Valid  @PathVariable Long id) {
        Torneo torneo = torneoService.findById(id);
        ResponseTorneoDTO responseTorneoDTO = torneoMapper.toResponseTorneoDTO(torneo);
        return ResponseEntity.ok(responseTorneoDTO);
    }

    @PostMapping("/torneo")
    public ResponseEntity<RequestTorneoDTO> save(@Valid @RequestBody RequestTorneoDTO requestTorneoDTO) {
        Torneo torneo = torneoMapper.toTorneoFromRequest(requestTorneoDTO);
        Torneo savedTorneo = torneoService.save(torneo);
        RequestTorneoDTO savedDTO = torneoMapper.toRequestTorneoDTO(savedTorneo);
        return ResponseEntity.ok(savedDTO);
    }

    @DeleteMapping("/torneo/{id}")
    public void deleteById(@PathVariable Long id) {
        torneoService.deleteById(id);
    }

    @PutMapping("/torneo")
    public ResponseEntity<ResponseTorneoDTO> update(@Valid @RequestBody ResponseTorneoDTO responseTorneoDTO) {
        Torneo torneo = torneoMapper.toTorneoFromResponse(responseTorneoDTO);
        Torneo updatedTorneo = torneoService.update(torneo);
        ResponseTorneoDTO updatedDTO = torneoMapper.toResponseTorneoDTO(updatedTorneo);
        return ResponseEntity.ok(updatedDTO);
    }
}
