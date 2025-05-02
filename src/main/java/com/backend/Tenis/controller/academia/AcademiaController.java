package com.backend.Tenis.controller.academia;

import com.backend.Tenis.dto.academia.RequestAcademiaDTO;
import com.backend.Tenis.dto.academia.ResponseAcademiaDTO;
import com.backend.Tenis.entity.Academia;
import com.backend.Tenis.mapper.academia.AcademiaMapper;
import com.backend.Tenis.service.academia.IAcademiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AcademiaController {

    @Autowired
    private IAcademiaService academiaService;

    @Autowired
    private AcademiaMapper academiaMapper;

    public AcademiaController(IAcademiaService academiaService) {
        this.academiaService = academiaService;
    }


    @GetMapping("/academia")
    public ResponseEntity<List<ResponseAcademiaDTO>> findAll() {
        List<Academia> academias = academiaService.findAll();
        List<ResponseAcademiaDTO> academiaDTOS = academiaMapper.fromAcademiaListToResponseList(academias);
        return ResponseEntity.ok(academiaDTOS);
    }

    @GetMapping("/academia/{id}")
    public ResponseEntity<ResponseAcademiaDTO> findById(@PathVariable Long id) {
        Academia academia = academiaService.findById(id);
        ResponseAcademiaDTO academiaDTO = academiaMapper.fromAcademiaToResponse(academia);
        return ResponseEntity.ok(academiaDTO);
    }

    @PostMapping("/academia")
    public ResponseEntity<ResponseAcademiaDTO> save(@RequestBody RequestAcademiaDTO requestAcademiaDTO) {

        Academia academia = academiaMapper.fromRequestToAcademia(requestAcademiaDTO);
        academia = academiaService.save(academia);
        return ResponseEntity.ok(academiaMapper.fromAcademiaToResponse(academia));

    }

    @DeleteMapping("/academia/{id}")
    public void deleteById(@PathVariable Long id) {
        academiaService.deleteById(id);
    }

    @PutMapping("/academia")
    public ResponseEntity<ResponseAcademiaDTO> update(@RequestBody ResponseAcademiaDTO responseAcademiaDTO) {
        Academia academia = academiaMapper.fromResponseToAcademia(responseAcademiaDTO);
        academia = academiaService.update(academia);
        return ResponseEntity.ok(academiaMapper.fromAcademiaToResponse(academia));
    }

}
