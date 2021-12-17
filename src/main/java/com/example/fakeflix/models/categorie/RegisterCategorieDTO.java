package com.example.fakeflix.models.categorie;

import com.example.fakeflix.entities.Categorie;

import java.io.Serializable;

public class RegisterCategorieDTO implements Serializable {

    private String label;

    public RegisterCategorieDTO(){}

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Categorie toModel(){
        Categorie c = new Categorie();
        c.setLabel(this.getLabel());
        return  c;
    }
}
