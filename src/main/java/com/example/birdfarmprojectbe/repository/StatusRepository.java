package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
