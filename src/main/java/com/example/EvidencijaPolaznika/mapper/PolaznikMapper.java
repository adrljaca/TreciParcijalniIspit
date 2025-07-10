package com.example.EvidencijaPolaznika.mapper;

import com.example.EvidencijaPolaznika.domain.Polaznik;
import com.example.EvidencijaPolaznika.dto.PolaznikDTO;

public interface PolaznikMapper {
    public PolaznikDTO mapToPolaznikDTO(Polaznik polaznik);
}
