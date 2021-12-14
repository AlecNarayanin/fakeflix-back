package com.example.fakeflix.models.user;

import com.example.fakeflix.entities.Utilisateur;
import jdk.jshell.execution.Util;

import java.io.Serializable;

public class UpsertDTO implements Serializable {

    private Integer Id;
    private String Username;
    private String email;
    private String Password;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    public Utilisateur MapUserModelFromDTO(Utilisateur u){
        u.setNomUtilisateur(this.getUsername());
        u.setEmail(this.getEmail());
        return u;
    }

}
