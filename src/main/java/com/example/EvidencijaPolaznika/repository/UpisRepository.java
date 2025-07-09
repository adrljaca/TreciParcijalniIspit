package com.example.EvidencijaPolaznika.repository;

import com.example.EvidencijaPolaznika.model.Upis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpisRepository extends JpaRepository<Upis, Long> {
}
