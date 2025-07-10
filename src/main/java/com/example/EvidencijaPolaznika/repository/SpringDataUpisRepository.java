package com.example.EvidencijaPolaznika.repository;

import com.example.EvidencijaPolaznika.domain.Upis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUpisRepository extends JpaRepository<Upis, Long> {
}
