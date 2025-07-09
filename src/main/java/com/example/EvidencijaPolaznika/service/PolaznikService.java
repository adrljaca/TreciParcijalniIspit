package com.example.EvidencijaPolaznika.service;

import com.example.EvidencijaPolaznika.model.Polaznik;
import com.example.EvidencijaPolaznika.repository.PolaznikRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolaznikService {

    private final PolaznikRepository polaznikRepository;

    public PolaznikService(PolaznikRepository polaznikRepository) {
        this.polaznikRepository = polaznikRepository;
    }

    public List<Polaznik> findAll() {
        return polaznikRepository.findAll();
    }

    public Optional<Polaznik> findById(Long id) {
        return polaznikRepository.findById(id);
    }

    public Polaznik save(Polaznik polaznik) {
        return polaznikRepository.save(polaznik);
    }

    public void delete(Long id) {
        polaznikRepository.deleteById(id);
    }
}
