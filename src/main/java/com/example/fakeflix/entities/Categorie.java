package com.example.fakeflix.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "categories")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "label")
    @NotNull
    private String label;

    @ManyToMany(mappedBy = "filmCategories")
    private List<Film> categories;


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

    public List<Film> getCategories() {
        return categories;
    }

    public void setCategories(List<Film> categories) {
        this.categories = categories;
    }
}
