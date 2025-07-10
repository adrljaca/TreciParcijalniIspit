package com.example.EvidencijaPolaznika.repository;

import com.example.EvidencijaPolaznika.domain.ProgramObrazovanja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProgramObrazovanjaRepository extends JpaRepository<ProgramObrazovanja, Long> {
}
