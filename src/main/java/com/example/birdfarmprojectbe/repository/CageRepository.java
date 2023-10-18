package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.Cage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CageRepository extends JpaRepository<Cage, Integer> {
}
