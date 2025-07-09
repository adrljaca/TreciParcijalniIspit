package com.example.EvidencijaPolaznika.service;

import com.example.EvidencijaPolaznika.model.ProgramObrazovanja;
import com.example.EvidencijaPolaznika.repository.ProgramObrazovanjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramObrazovanjaService {

    private final ProgramObrazovanjaRepository repository;

    public ProgramObrazovanjaService(ProgramObrazovanjaRepository repository) {
        this.repository = repository;
    }

    public List<ProgramObrazovanja> findAll() {
        return repository.findAll();
    }

    public Optional<ProgramObrazovanja> findById(Long id) {
        return repository.findById(id);
    }

    public ProgramObrazovanja save(ProgramObrazovanja program) {
        return repository.save(program);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
