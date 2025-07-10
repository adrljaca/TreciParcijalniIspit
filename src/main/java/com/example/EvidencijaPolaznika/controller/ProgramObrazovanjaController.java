package com.example.EvidencijaPolaznika.controller;

import com.example.EvidencijaPolaznika.dto.ProgramObrazovanjaDTO;
import com.example.EvidencijaPolaznika.service.ProgramObrazovanjaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/programi")
public class ProgramObrazovanjaController {
    ProgramObrazovanjaService programObrazovanjaService;

    public ProgramObrazovanjaController(ProgramObrazovanjaService programObrazovanjaService) {
        this.programObrazovanjaService = programObrazovanjaService;
    }

    @GetMapping
    public List<ProgramObrazovanjaDTO> getAllPolaznici() {
        List<ProgramObrazovanjaDTO> programObrazovanjaList = programObrazovanjaService.getAllPorgramObrazovanja();
        return programObrazovanjaList;
    }
}
