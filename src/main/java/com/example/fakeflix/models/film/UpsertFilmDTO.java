package com.example.fakeflix.models.film;

import com.example.fakeflix.entities.Film;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class UpsertFilmDTO implements Serializable {

    private Integer id;

    private String nom;

    private Date annee;

    private String description;

    private Double score;

    private Integer categorieAge;

    private String urlImageFilm;


    public UpsertFilmDTO(){
    }

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

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getCategorieAge() {
        return categorieAge;
    }

    public void setCategorieAge(Integer categorieAge) {
        this.categorieAge = categorieAge;
    }

    public String getUrlImageFilm() {
        return urlImageFilm;
    }

    public void setUrlImageFilm(String urlImageFilm) {
        this.urlImageFilm = urlImageFilm;
    }

    public Film ToModel(){
        Film f = new Film();
        f.setId(this.getId());
        f.setAnnee(this.getAnnee());
        f.setDescription(this.getDescription());
        f.setCategorieAge(this.getCategorieAge());
        f.setNom(this.getNom());
        f.setScore(this.getScore());
        f.setUrlImageFilm(this.getUrlImageFilm());
        return f;
    }
}
