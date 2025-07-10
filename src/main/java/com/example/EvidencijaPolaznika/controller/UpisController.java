package com.example.EvidencijaPolaznika.controller;

import com.example.EvidencijaPolaznika.model.Upis;
import com.example.EvidencijaPolaznika.service.UpisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/upisi")
public class UpisController {
    UpisService upisService;

    public UpisController(UpisService upisService) {
        this.upisService = upisService;
    }

    @GetMapping
    public List<UpisDto> getAllUpisi() {
        List<UpisDto> upisi = upisService.getAllUpisi();
        return upisi;
    }
}
