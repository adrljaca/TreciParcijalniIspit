package com.example.EvidencijaPolaznika.controller;

import com.example.EvidencijaPolaznika.dto.UpisDTO;
import com.example.EvidencijaPolaznika.service.UpisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/upisi")
public class UpisController {
    UpisService upisService;

    public UpisController(UpisService upisService) {
        this.upisService = upisService;
    }

    @GetMapping
    public List<UpisDTO> getAllUpisi() {
        List<UpisDTO> upisi = upisService.getAllUpisi();
        return upisi;
    }
}
