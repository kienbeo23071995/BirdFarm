package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.BirdType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirdTypeRepository extends JpaRepository<BirdType, Integer> {
}
