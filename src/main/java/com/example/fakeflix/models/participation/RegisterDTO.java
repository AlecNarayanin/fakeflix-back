package com.example.fakeflix.models.participation;

import com.example.fakeflix.entities.Film;
import com.example.fakeflix.entities.Participation;
import com.example.fakeflix.entities.Personne;
import com.example.fakeflix.services.FilmService;
import com.example.fakeflix.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.Serializable;

public class RegisterDTO implements Serializable {

    @Autowired
    private FilmService filmService;

    @Autowired
    private PersonneService personneService;

    private Integer filmId;

    private Integer personneId;

    private Participation.Role role;

    public FilmService getFilmService() {
        return filmService;
    }

    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    public PersonneService getPersonneService() {
        return personneService;
    }

    public void setPersonneService(PersonneService personneService) {
        this.personneService = personneService;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getPersonneId() {
        return personneId;
    }

    public void setPersonneId(Integer personneId) {
        this.personneId = personneId;
    }

    public Participation.Role getRole() {
        return role;
    }

    public void setRole(Participation.Role role) {
        this.role = role;
    }

    public Participation toModel(){
        Participation p = new Participation();
        p.setFilm(filmService.GetById(this.filmId));
        p.setPersonne(personneService.getById(this.personneId));
        p.setRole(this.getRole());
        return p;
    }
}
