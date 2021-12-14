package com.example.fakeflix.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "films")
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom")
    @NotNull
    private String nom;

    @Column(name = "annee")
    @NotNull
    private Date annee;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "score")
    private Double score;

    @Column(name = "categorie_age")
    private Integer categorieAge;

    @Column(name = "url_image_film")
    private String urlImageFilm;

    @OneToMany(mappedBy = "film")
    private List<Participation> participants = new ArrayList<Participation>();

    @ManyToMany
    @JoinTable(name = "film_categories", joinColumns = @JoinColumn(name = "categorie_id"), inverseJoinColumns = @JoinColumn(name = "film_id"))
    private List<Categorie> filmCategories;

    @ManyToMany(mappedBy = "filmFavoris")
    private List<Utilisateur> favoris;

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

    public List<Participation> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participation> participants) {
        this.participants = participants;
    }

    public List<Categorie> getFilmCategories() {
        return filmCategories;
    }

    public void setFilmCategories(List<Categorie> filmCategories) {
        this.filmCategories = filmCategories;
    }


    public List<Utilisateur> getFavoris() {
        return favoris;
    }

    public void setFavoris(List<Utilisateur> favoris) {
        this.favoris = favoris;
    }
}
