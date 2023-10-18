package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.Bird;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirdRepository extends JpaRepository<Bird, Integer> {
}
