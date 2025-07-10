package com.example.EvidencijaPolaznika.controller;

import com.example.EvidencijaPolaznika.dto.PolaznikDTO;
import com.example.EvidencijaPolaznika.service.PolaznikService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/polaznici")
public class PolaznikController {

    PolaznikService polaznikService;

    public PolaznikController(PolaznikService polaznikService) {
        this.polaznikService = polaznikService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PolaznikDTO save(@RequestBody final PolaznikDTO command) {
        return polaznikService.save(command)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Greska prilikom " +
                        "dodavanja novog polaznika."));
    }

    @GetMapping
    public List<PolaznikDTO> getAllPolaznici() {
        List<PolaznikDTO> polaznici = polaznikService.getAllPolaznik();
        return polaznici;
    }

    @GetMapping("/{id}")
    public PolaznikDTO getById(@PathVariable("id") Long polaznikId) {
        return polaznikService.findById(polaznikId)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ne postoji polaznik sa ID-om:" + polaznikId));
    }

    @PutMapping("/{id}")
    public PolaznikDTO update(@PathVariable("id") Long polaznikId,@RequestBody final PolaznikDTO polaznikDTO) {
        return polaznikService.updatePolaznik(polaznikId, polaznikDTO)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ne postoji polaznik sa ID-om:" + polaznikId));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long polaznikId) {
        polaznikService.deletePolaznik(polaznikId);
    }
}
