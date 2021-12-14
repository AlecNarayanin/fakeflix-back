package com.example.fakeflix.models.user;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private String token;

    public JwtResponse(){}

    public JwtResponse(String token){
        this.setToken(token);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
