package com.example.EvidencijaPolaznika.controller;

import com.example.EvidencijaPolaznika.model.ProgramObrazovanja;
import com.example.EvidencijaPolaznika.service.ProgramObrazovanjaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programi")
public class ProgramObrazovanjaController {
    ProgramObrazovanjaService programObrazovanjaService;

    public ProgramObrazovanjaController(ProgramObrazovanjaService programObrazovanjaService) {
        this.programObrazovanjaService = programObrazovanjaService;
    }

    @GetMapping
    public List<ProgramObrazovanjaDto> getAllPolaznici() {
        List<ProgramObrazovanjaDto> programObrazovanjaList = programObrazovanjaService.getAllPorgramObrazovanja();
        return programObrazovanjaList;
    }
}
