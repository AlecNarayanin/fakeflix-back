package com.example.fakeflix.models.user;

import com.example.fakeflix.entities.Utilisateur;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class RegisterDTO implements Serializable {

    private String username;

    private String email;

    private String password;

    public RegisterDTO(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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


    public Utilisateur toModel(){
        Utilisateur u = new Utilisateur();
        u.setNomUtilisateur(this.getUsername());
        u.setPassword(this.getPassword());
        u.setEmail(this.getEmail());
        return  u;
    }

}
