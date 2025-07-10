package com.example.EvidencijaPolaznika.service;

import com.example.EvidencijaPolaznika.dto.PolaznikDTO;

import java.util.List;
import java.util.Optional;

public interface PolaznikService {
    Optional<PolaznikDTO> save(PolaznikDTO polaznikDTO);

    List<PolaznikDTO> getAllPolaznik();

    Optional<PolaznikDTO> findById(Long polaznikID);

    Optional<PolaznikDTO> updatePolaznik(Long polaznikId, PolaznikDTO polaznikDTO);

    void deletePolaznik(Long polaznikId);
}
