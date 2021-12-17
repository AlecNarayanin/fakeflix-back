package com.example.fakeflix.models.participation;

import com.example.fakeflix.entities.Utilisateur;

import java.io.Serializable;

public class RegisterDTO implements Serializable {

    private String Username;

    private String Email;

    private String Password;

    public RegisterDTO(){}

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }


    public Utilisateur toModel(){
        Utilisateur u = new Utilisateur();
        u.setNomUtilisateur(this.getUsername());
        u.setPassword(this.getPassword());
        u.setEmail(this.getEmail());
        return  u;
    }

}
