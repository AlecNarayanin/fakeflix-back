package com.example.fakeflix.models.participation;

import com.example.fakeflix.entities.Film;
import com.example.fakeflix.entities.Participation;
import com.example.fakeflix.entities.Personne;

import java.io.Serializable;

public class UpsertDTO implements Serializable {

    private Integer id;

    private Film film;

    private Personne personne;

    private Participation.Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Participation.Role getRole() {
        return role;
    }

    public void setRole(Participation.Role role) {
        this.role = role;
    }

    public Participation mapParticipationModelFromDTO(Participation p){
        p.setRole(this.getRole());
        return p;
    }
}
