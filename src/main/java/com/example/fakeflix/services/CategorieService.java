package com.example.fakeflix.services;

import com.example.fakeflix.entities.Categorie;
import com.example.fakeflix.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService{

    @Autowired
    private CategorieRepository categorieRepository;

    public Categorie getById(Integer id){
        return categorieRepository.getById(id);
    }

    public List<Categorie> getAll(){
        return categorieRepository.findAll();
    }

    public Categorie create(Categorie categorie){
        return categorieRepository.save(categorie);
    }

    public boolean update(Categorie categorie) {
        boolean check = checkExistence(categorie.getId());
        if(check){
            categorieRepository.save(categorie);
        }
        return check;
    }

    public boolean delete(Integer id) {
        boolean check = checkExistence(id);
        if(check){
            categorieRepository.deleteById(id);
        }
        return check;

    }

    public boolean checkExistence(Integer id) {
        return categorieRepository.existsById(id);
    }
}
