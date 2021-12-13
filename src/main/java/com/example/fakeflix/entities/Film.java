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

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "annee")
    @NotNull
    private Date annee;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "score")
    private Double score;

    @OneToMany(mappedBy = "film")
    private List<Participation> participed_person = new ArrayList<Participation>();

    @ManyToMany
    @JoinTable(name = "film_categories", joinColumns = @JoinColumn(name = "categorie_id"), inverseJoinColumns = @JoinColumn(name = "film_id"))
    private List<Categorie> filmCategories;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Categorie> getFilmCategories() {
        return filmCategories;
    }

    public void setFilmCategories(List<Categorie> filmCategories) {
        this.filmCategories = filmCategories;
    }
}
