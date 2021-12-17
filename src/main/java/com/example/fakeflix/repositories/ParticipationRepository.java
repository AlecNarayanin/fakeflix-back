package com.example.fakeflix.repositories;

import com.example.fakeflix.entities.Film;
import com.example.fakeflix.entities.Participation;
import com.example.fakeflix.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipationRepository extends JpaRepository<Participation,Integer> {

    @Query(value = "SELECT p.film from Participation p where p.personne.id =:id")
    List<Film> getAllFilmByPersonId(@Param("id") Integer id);

    @Query(value = "SELECT p.personne from Participation p where p.film.id =:id AND p.role ='ACTOR'")
    List<Personne> getAllActorByFilmId(@Param("id") Integer id);

    @Query(value = "SELECT p.personne from Participation p where p.film.id =:id AND p.role ='DIRECTOR'")
    List<Personne> getAllDirectorByFilmId(@Param("id") Integer id);
}
