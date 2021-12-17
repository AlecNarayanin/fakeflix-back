package com.example.fakeflix.models.distribution;

import com.example.fakeflix.entities.Distribution;

import java.io.Serializable;
import java.util.Date;

public class RegisterDistributionDTO implements Serializable {

    private int id;

    private String name;


    public RegisterDistributionDTO(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Distribution toModel(){
        Distribution d = new Distribution();
        d.setId(this.getId());
        d.setNom(this.getName());
        return  d;
    }


}
