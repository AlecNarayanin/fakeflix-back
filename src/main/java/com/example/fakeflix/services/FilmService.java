package com.example.fakeflix.services;

import com.example.fakeflix.entities.Film;
import com.example.fakeflix.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {


    @Autowired
    private FilmRepository filmRepository;


    public Film GetById(Integer id){
        return filmRepository.getById(id);
    }
}
