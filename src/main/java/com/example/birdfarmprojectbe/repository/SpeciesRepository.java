package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {
}
