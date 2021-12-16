package com.example.fakeflix.repositories;

import com.example.fakeflix.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Integer> {
}
