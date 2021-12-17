package com.example.fakeflix.models.distribution;

import com.example.fakeflix.entities.Distribution;

import java.util.Date;

public class RegisterDTO {
    private String nom;

    private Date dateCreation;

    public RegisterDTO(){}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Distribution toModel(){
        Distribution d = new Distribution();
        d.setNom(this.getNom());
        d.setDateCreation(this.getDateCreation());
        return  d;
    }
}
