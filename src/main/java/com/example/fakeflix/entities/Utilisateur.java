package com.example.fakeflix.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "utilisateurs")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom_utilisateur")
    @NotNull
    private String nomUtilisateur;

    @Column(name = "email")
    @NotNull
    private String email;

    @JsonIgnore
    @Column(name = "password")
    @NotNull
    private String password;

    @ManyToMany
    @JoinTable(name="filmFavoris", joinColumns = @JoinColumn(name = "utilisateur_id"), inverseJoinColumns = @JoinColumn(name = "film_id"))
    private List<Film> filmFavoris;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Film> getFilmFavoris() {
        return filmFavoris;
    }

    public void setFilmFavoris(List<Film> filmFavoris) {
        this.filmFavoris = filmFavoris;
    }
}
