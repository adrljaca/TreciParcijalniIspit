package com.example.EvidencijaPolaznika.repository;

import com.example.EvidencijaPolaznika.model.Polaznik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PolaznikRepository extends JpaRepository<Polaznik, Long> {
}
