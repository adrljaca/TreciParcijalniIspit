package com.example.EvidencijaPolaznika.controller;

import com.example.EvidencijaPolaznika.model.ProgramObrazovanja;
import com.example.EvidencijaPolaznika.service.ProgramObrazovanjaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programi")
public class ProgramObrazovanjaController {

    private final ProgramObrazovanjaService service;

    public ProgramObrazovanjaController(ProgramObrazovanjaService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<ProgramObrazovanja> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramObrazovanja> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProgramObrazovanja create(@RequestBody ProgramObrazovanja program) {
        return service.save(program);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramObrazovanja> update(@PathVariable Long id, @RequestBody ProgramObrazovanja program) {
        return service.findById(id)
                .map(existing -> {
                    program.setId(id);
                    return ResponseEntity.ok(service.save(program));
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
