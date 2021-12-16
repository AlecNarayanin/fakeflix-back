package com.example.fakeflix.services;

import com.example.fakeflix.entities.Film;
import com.example.fakeflix.entities.Personne;
import com.example.fakeflix.models.person.UpsertDTO;
import com.example.fakeflix.repositories.FilmRepository;
import com.example.fakeflix.repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {


    @Autowired
    private PersonneRepository personneRepository;

    public Personne getById(Integer id){
        return personneRepository.getById(id);
    }

    public List<Personne> getAll(){
        return personneRepository.findAll();
    }

    public boolean update(Personne personne) {
        boolean check = checkExistence(personne.getId());
        if(check){
            personneRepository.save(personne);
        }
        return check;
    }

    public Personne create(Personne person){
        return personneRepository.save(person);
    }

    public boolean delete(Integer id) {
        boolean check = checkExistence(id);
        if(check){
            //TODO Delete ids sur la table participation
            //personneRepository.deleteById(id);
        }
        return check;

    }

    public boolean checkExistence(Integer id) {
        return personneRepository.existsById(id);
    }
}
