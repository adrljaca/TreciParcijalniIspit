package com.example.EvidencijaPolaznika.controller;

import com.example.EvidencijaPolaznika.model.Polaznik;
import com.example.EvidencijaPolaznika.service.PolaznikService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polaznici")
public class PolaznikController {

    private final PolaznikService service;

    public PolaznikController(PolaznikService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Polaznik> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Polaznik> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Polaznik create(@RequestBody Polaznik polaznik) {
        return service.save(polaznik);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Polaznik> update(@PathVariable Long id, @RequestBody Polaznik polaznik) {
        return service.findById(id)
                .map(existing -> {
                    polaznik.setId(id);
                    return ResponseEntity.ok(service.save(polaznik));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
