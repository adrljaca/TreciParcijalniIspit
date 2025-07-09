package com.example.EvidencijaPolaznika.controller;

import com.example.EvidencijaPolaznika.model.Upis;
import com.example.EvidencijaPolaznika.service.UpisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/upisi")
public class UpisController {

    private final UpisService service;

    public UpisController(UpisService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Upis> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Upis> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Upis create(@RequestBody Upis upis) {
        return service.save(upis);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Upis> update(@PathVariable Long id, @RequestBody Upis upis) {
        return service.findById(id)
                .map(existing -> {
                    upis.setId(id);
                    return ResponseEntity.ok(service.save(upis));
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
