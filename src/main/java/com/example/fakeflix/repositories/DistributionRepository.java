package com.example.fakeflix.repositories;

import com.example.fakeflix.entities.Distribution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistributionRepository extends JpaRepository<Distribution,Integer> {
}
