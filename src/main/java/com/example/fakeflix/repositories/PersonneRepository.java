package com.example.fakeflix.repositories;

import com.example.fakeflix.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne,Integer> {

}
