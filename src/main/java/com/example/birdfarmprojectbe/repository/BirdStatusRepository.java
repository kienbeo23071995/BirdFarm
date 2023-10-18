package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.BirdStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirdStatusRepository extends JpaRepository<BirdStatus, Integer> {
}
