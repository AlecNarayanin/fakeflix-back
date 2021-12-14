package com.example.fakeflix.models.user;

import java.io.Serializable;

public class AuthDTO implements Serializable {

    private String Username;
    private String Password;


    public AuthDTO(){}


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
