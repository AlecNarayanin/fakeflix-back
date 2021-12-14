package com.example.fakeflix.repositories;

import com.example.fakeflix.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface  UserRepository extends JpaRepository<Utilisateur,Integer> {


    @Query(value = "select u from Utilisateur u where u.nomUtilisateur =:value")
    Utilisateur getByUsername(@Param("value") String value);
}
