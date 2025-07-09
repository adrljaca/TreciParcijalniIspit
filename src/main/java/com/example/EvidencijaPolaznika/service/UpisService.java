package com.example.EvidencijaPolaznika.service;

import com.example.EvidencijaPolaznika.model.Upis;
import com.example.EvidencijaPolaznika.repository.UpisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UpisService {

    private final UpisRepository repository;

    public UpisService(UpisRepository repository) {
        this.repository = repository;
    }

    public List<Upis> findAll() {
        return repository.findAll();
    }

    public Optional<Upis> findById(Long id) {
        return repository.findById(id);
    }

    public Upis save(Upis upis) {
        return repository.save(upis);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
