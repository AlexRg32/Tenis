package com.backend.Tenis.controller.sponsor;

import com.backend.Tenis.entity.Sponsor;
import com.backend.Tenis.service.sponsor.ISponsorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SponsorController {

    private ISponsorService sponsorService;

    @GetMapping("/sponsor")
    public ResponseEntity<List<Sponsor>> findAll() {
        List<Sponsor> sponsors = sponsorService.findAll();
        return ResponseEntity.ok(sponsors);
    }

    @GetMapping("/sponsor/{id}")
    public ResponseEntity<Sponsor> findById(@PathVariable Long id) {
        Sponsor sponsor = sponsorService.findById(id);
        return ResponseEntity.ok(sponsor);
    }

    @PostMapping("/sponsor")
    public ResponseEntity<Sponsor> save(@RequestBody Sponsor sponsor) {
        Sponsor sponsorSave = sponsorService.save(sponsor);
        return ResponseEntity.ok(sponsorSave);
    }

    @DeleteMapping("/sponsor/{id}")
    public void deleteById(@PathVariable Long id) {
        sponsorService.deleteById(id);

    }
    @PutMapping("/sponsor")
    public ResponseEntity<Sponsor> update(@RequestBody Sponsor sponsor) {
        Sponsor sponsorUpdate = sponsorService.update(sponsor);
        return ResponseEntity.ok(sponsorUpdate);
    }


}
