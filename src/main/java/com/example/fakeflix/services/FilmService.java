package com.example.fakeflix.services;

import com.example.fakeflix.entities.Categorie;
import com.example.fakeflix.entities.Film;
import com.example.fakeflix.repositories.CategorieRepository;
import com.example.fakeflix.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {


    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private CategorieRepository categorieRepository;


    public Film GetById(Integer id){
        return filmRepository.getById(id);
    }


    public Film upsert(Film f){
        return filmRepository.save(f);
    }


    public boolean delete(Integer id) {
        boolean check = filmRepository.existsById(id);
        if(check){
            filmRepository.deleteById(id);
        }
        return check;

    }

    public Boolean addCategorie(Integer filmId , Integer categorieId){

        if(filmRepository.existsById(filmId) && categorieRepository.existsById(categorieId)){
            Film f = this.GetById(filmId);

            ArrayList<Categorie> categories = new ArrayList<Categorie>();

            if(f.getFilmCategories() != null){
                categories = new ArrayList<Categorie>(f.getFilmCategories());
            }
            Categorie categorie = categorieRepository.getById(categorieId);

            if(!categories.contains(categorie)){
                categories.add(categorie);
            }
            f.setFilmCategories(categories);
            filmRepository.save(f);
            return true;
        }
        return false;
    }
}
