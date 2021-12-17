package com.example.fakeflix.models.person;

import com.example.fakeflix.entities.Personne;
import com.example.fakeflix.entities.Utilisateur;

import java.io.Serializable;
import java.util.Date;

public class UpsertPersonDTO implements Serializable {

    private Integer id;

    private String firstname;

    private String lastname;

    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Personne mapPersonModelFromDTO(Personne p){
        p.setFirstname(this.getFirstname());
        p.setLastname(this.getLastname());
        p.setBirthday(this.getBirthday());
        return p;
    }
}
