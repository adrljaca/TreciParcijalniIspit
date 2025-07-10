package com.example.EvidencijaPolaznika.repository;

import com.example.EvidencijaPolaznika.domain.Polaznik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataPolaznikRepository extends JpaRepository<Polaznik, Long> {
}
