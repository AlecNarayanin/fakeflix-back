package com.example.fakeflix.models.distribution;

import com.example.fakeflix.entities.Distribution;
import com.example.fakeflix.entities.Utilisateur;

import java.io.Serializable;
import java.util.Date;

public class UpsertDTO implements Serializable {

    private Integer id;
    private String nom;
    private Date dateCreation;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Distribution mapDistributionModelFromDTO(Distribution d){
        d.setNom(this.getNom());
        d.setDateCreation(this.getDateCreation());
        return d;
    }
}
