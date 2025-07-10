package com.example.EvidencijaPolaznika.service;

import com.example.EvidencijaPolaznika.dto.ProgramObrazovanjaDTO;
import com.example.EvidencijaPolaznika.repository.SpringDataProgramObrazovanjaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramObrazovanjaServiceImpl implements ProgramObrazovanjaService{

    SpringDataProgramObrazovanjaRepository springDataProgramObrazovanjaRepository;
    ModelMapper modelMapper;

    public ProgramObrazovanjaServiceImpl(SpringDataProgramObrazovanjaRepository springDataProgramObrazovanjaRepository, ModelMapper modelMapper) {
        this.springDataProgramObrazovanjaRepository = springDataProgramObrazovanjaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProgramObrazovanjaDTO> getAllPorgramObrazovanja() {
        return springDataProgramObrazovanjaRepository.findAll().stream()
                .map(program -> modelMapper.map(program, ProgramObrazovanjaDTO.class))
                .collect(Collectors.toList());
    }
}
