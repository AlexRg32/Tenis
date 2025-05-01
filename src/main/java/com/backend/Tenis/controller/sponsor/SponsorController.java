package com.backend.Tenis.controller.sponsor;

import com.backend.Tenis.dto.sponsor.RequestSponsorDTO;
import com.backend.Tenis.dto.sponsor.ResponseSponsorDTO;
import com.backend.Tenis.entity.Sponsor;
import com.backend.Tenis.mapper.sponsor.SponsorMapper;
import com.backend.Tenis.service.sponsor.ISponsorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SponsorController {


    @Autowired
    private ISponsorService sponsorService;


    @Autowired
    private SponsorMapper sponsorMapper;


    @GetMapping("/sponsor")
    public ResponseEntity<List<ResponseSponsorDTO>> findAll() {
        List<Sponsor> sponsors = sponsorService.findAll();
        List<ResponseSponsorDTO> sponsorDTOS = sponsorMapper.toResponseSponsorDTOList(sponsors);
        return ResponseEntity.ok(sponsorDTOS);
    }

    @GetMapping("/sponsor/{id}")
    public ResponseEntity<ResponseSponsorDTO> findById(@Valid @PathVariable Long id) {
        Sponsor sponsor = sponsorService.findById(id);
        ResponseSponsorDTO sponsorDTO = sponsorMapper.toResponseSponsorDTO(sponsor);
        return ResponseEntity.ok(sponsorDTO);
    }

    @PostMapping("/sponsor")
    public ResponseEntity<RequestSponsorDTO> save(@Valid @RequestBody Sponsor sponsor) {
        Sponsor sponsorSave = sponsorService.save(sponsor);
        RequestSponsorDTO sponsorDTO = sponsorMapper.toRequestSponsorDTO(sponsorSave);
        return ResponseEntity.ok(sponsorDTO);
    }

    @DeleteMapping("/sponsor/{id}")
    public void deleteById(@Valid @PathVariable Long id) {
        sponsorService.deleteById(id);

    }
    @PutMapping("/sponsor")
    public ResponseEntity<ResponseSponsorDTO> update(@Valid @RequestBody Sponsor sponsor) {
        Sponsor sponsorUpdate = sponsorService.update(sponsor);
        ResponseSponsorDTO sponsorDTO = sponsorMapper.toResponseSponsorDTO(sponsorUpdate);
        return ResponseEntity.ok(sponsorDTO);
    }


}

