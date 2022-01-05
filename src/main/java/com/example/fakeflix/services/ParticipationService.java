package com.example.fakeflix.services;

import com.example.fakeflix.entities.Film;
import com.example.fakeflix.entities.Participation;
import com.example.fakeflix.entities.Personne;
import com.example.fakeflix.repositories.FilmRepository;
import com.example.fakeflix.repositories.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipationService {


    @Autowired
    private ParticipationRepository participationRepository;

    public List<Film> getAllFilmByPersonId(Integer id){
        return participationRepository.getAllFilmByPersonId(id);
    }

    public List<Personne> getAllActorByFilmId(Integer id){
        return participationRepository.getAllActorByFilmId(id);
    }

    public List<Personne> getAllDirectorByFilmId(Integer id){
        return participationRepository.getAllActorByFilmId(id);
    }

    public List<Participation> getAll(){
        return participationRepository.findAll();
    }

    public Participation getById(Integer id){
        return participationRepository.getById(id);
    }

    public Participation create(Participation p){
        return participationRepository.save(p);
    }

    public boolean update(Participation participation){
        boolean check = checkExistence(participation.getId());
        if(check){
            participationRepository.save(participation);
        }
        return check;
    }

    public boolean delete(Integer id){
        boolean check = checkExistence(id);
        if(check){
            participationRepository.deleteById(id);
        }
        return check;
    }

    public boolean checkExistence(Integer id){
        return participationRepository.existsById(id);
    }
}
