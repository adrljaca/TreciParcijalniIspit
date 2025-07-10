package com.example.EvidencijaPolaznika.mapper;

import com.example.EvidencijaPolaznika.domain.Polaznik;
import com.example.EvidencijaPolaznika.dto.PolaznikDTO;
import org.springframework.stereotype.Component;

@Component
public class PolaznikMapperImpl implements PolaznikMapper {

    @Override
    public PolaznikDTO mapToPolaznikDTO(Polaznik polaznik) {
        return new PolaznikDTO (
                polaznik.getIme(),
                polaznik.getPrezime(),
                polaznik.getProgramNaziv()
        );
    }
}
