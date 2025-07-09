package com.example.EvidencijaPolaznika.repository;

import com.example.EvidencijaPolaznika.model.ProgramObrazovanja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramObrazovanjaRepository extends JpaRepository<ProgramObrazovanja, Long> {
}
