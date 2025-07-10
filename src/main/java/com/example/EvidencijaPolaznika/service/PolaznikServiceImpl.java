package com.example.EvidencijaPolaznika.service;

import com.example.EvidencijaPolaznika.domain.Polaznik;
import com.example.EvidencijaPolaznika.dto.PolaznikDTO;
import com.example.EvidencijaPolaznika.mapper.PolaznikMapper;
import com.example.EvidencijaPolaznika.mapper.PolaznikMapperImpl;
import com.example.EvidencijaPolaznika.repository.SpringDataPolaznikRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PolaznikServiceImpl implements PolaznikService {

    SpringDataPolaznikRepository polaznikRepository;
    ModelMapper modelMapper;
    PolaznikMapper polaznikMapper;

    public PolaznikServiceImpl(SpringDataPolaznikRepository polaznikRepository, ModelMapper modelMapper, PolaznikMapperImpl polaznikMapper) {
        this.polaznikRepository = polaznikRepository;
        this.modelMapper = modelMapper;
        this.polaznikMapper = polaznikMapper;
    }

    @Override
    public Optional<PolaznikDTO> save(PolaznikDTO polaznikDTO) {
        Polaznik polaznik = modelMapper.map(polaznikDTO, Polaznik.class);
        Polaznik savedPolaznik = polaznikRepository.save(polaznik);

        return Optional.of(modelMapper.map(savedPolaznik, PolaznikDTO.class));
    }

    @Override
    public List<PolaznikDTO> getAllPolaznik() {
        List<Polaznik> polaznici = polaznikRepository.findAll();
        return polaznici.stream().map(polaznik -> polaznikMapper.mapToPolaznikDTO(polaznik)).collect(Collectors.toList());
    }

    @Override
    public Optional<PolaznikDTO> findById(Long polaznikID) {
        Polaznik polaznik = polaznikRepository.findById(polaznikID).orElseThrow();
        return Optional.of(polaznikMapper.mapToPolaznikDTO(polaznik));
    }

    @Override
    public Optional<PolaznikDTO> updatePolaznik(Long polaznikId, PolaznikDTO polaznikDTO) {
        Optional<Polaznik> polaznik = polaznikRepository.findById(polaznikId);

        if (polaznik.isPresent()) {
            Polaznik polaznikToUpdate = polaznik.get();
            polaznikToUpdate.setIme(polaznikDTO.getIme());
            polaznikToUpdate.setPrezime(polaznikDTO.getPrezime());
            polaznikToUpdate.setProgramNaziv(polaznikDTO.getProgramNaziv());

            Polaznik updatedPolaznik = polaznikRepository.save(polaznikToUpdate);
            return Optional.of(polaznikMapper.mapToPolaznikDTO(updatedPolaznik));
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public void deletePolaznik(Long polaznikId) {
        Optional<Polaznik> hardwareOptional = polaznikRepository.findById(polaznikId);
        hardwareOptional.ifPresent(polaznikRepository::delete);
    }
}