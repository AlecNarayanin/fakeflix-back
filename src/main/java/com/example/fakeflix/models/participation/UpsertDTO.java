package com.example.fakeflix.models.participation;

import com.example.fakeflix.entities.Participation;
import com.example.fakeflix.services.FilmService;
import com.example.fakeflix.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class UpsertDTO implements Serializable {

    @Autowired
    private PersonneService personneService;

    @Autowired
    private FilmService filmService;

    private Integer id;

    private Integer filmId;

    private Integer personneId;

    private Participation.Role role;

    public PersonneService getPersonneService() {
        return personneService;
    }

    public void setPersonneService(PersonneService personneService) {
        this.personneService = personneService;
    }

    public FilmService getFilmService() {
        return filmService;
    }

    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Participation mapParticipationModelFromDTO(Participation p){
        p.setPersonne(getPersonneService().getById(this.getPersonneId()));
        p.setFilm(getFilmService().GetById(this.getFilmId()));
        p.setRole(this.getRole());
        return p;
    }
}
