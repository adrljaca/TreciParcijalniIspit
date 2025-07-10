package com.example.EvidencijaPolaznika.service;

import com.example.EvidencijaPolaznika.dto.UpisDTO;
import com.example.EvidencijaPolaznika.repository.SpringDataUpisRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UpisServiceImpl implements UpisService {
    SpringDataUpisRepository springDataUpisRepository;
    ModelMapper modelMapper;

    public UpisServiceImpl(SpringDataUpisRepository springDataUpisRepository, ModelMapper modelMapper) {
        this.springDataUpisRepository = springDataUpisRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UpisDTO> getAllUpisi() {
        return springDataUpisRepository.findAll().stream()
                .map(upis -> modelMapper.map(upis, UpisDTO.class))
                .collect(Collectors.toList());
    }
}
