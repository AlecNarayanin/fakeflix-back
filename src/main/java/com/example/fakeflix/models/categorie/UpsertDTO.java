package com.example.fakeflix.models.categorie;

import com.example.fakeflix.entities.Categorie;

import java.io.Serializable;

public class UpsertDTO implements Serializable {

    private Integer id;
    private String label;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Categorie mapCategorieModelFromDTO(Categorie c){
        c.setLabel(this.getLabel());
        return c;
    }

}
