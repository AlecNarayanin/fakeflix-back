package com.example.fakeflix.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Participation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    private Film film;

    @Enumerated()
    @Column(name = "role")
    private Role role;


    public enum Role {
        ACTOR, DIRECTOR
    }
}
