package com.example.fakeflix.models.participation;

import com.example.fakeflix.entities.Film;
import com.example.fakeflix.entities.Participation;
import com.example.fakeflix.entities.Personne;


import java.io.Serializable;

public class RegisterDTO implements Serializable {

    private Film film;

    private Personne personne;

    private Participation.Role role;

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Participation.Role getRole() {
        return role;
    }

    public void setRole(Participation.Role role) {
        this.role = role;
    }

    public Participation toModel(){
        Participation p = new Participation();
        p.setRole(this.getRole());
        return p;
    }
}
