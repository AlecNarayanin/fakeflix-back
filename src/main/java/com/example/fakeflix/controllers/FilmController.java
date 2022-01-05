package com.example.fakeflix.controllers;

import com.example.fakeflix.entities.Film;
import com.example.fakeflix.models.film.UpsertFilmDTO;
import com.example.fakeflix.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilmController {

    @Autowired
    private FilmService filmService;


    @PutMapping("/film")
    public Film upsertFilm(@RequestBody UpsertFilmDTO dto){
        return filmService.upsert(dto.ToModel());
    }

    @DeleteMapping("/film/{id}")
    public void deleteFilm(@PathVariable(value = "id") Integer id) throws Exception{
        boolean operationResult = filmService.delete(id);
        if(!operationResult){
            throw new Exception("distribution inexistante");
        }
    }

    @PostMapping("/film/{filmId}/categorie/{categorieId}")
    public void addCategorieTofilm(@PathVariable(value = "filmId") Integer filmId , @PathVariable(value = "categorieId") Integer categorieId ) throws Exception{
        boolean operationResult = filmService.addCategorie(filmId,categorieId);
        if(!operationResult){
            throw new Exception("film ou categorie inexistants");
        }
    }

    @DeleteMapping("/film/{filmId}/categorie/{categorieId}")
    public void deleteCategorieTofilm(@PathVariable(value = "filmId") Integer filmId , @PathVariable(value = "categorieId") Integer categorieId ) throws Exception{
        boolean operationResult = filmService.removeCategorie(filmId,categorieId);
        if(!operationResult){
            throw new Exception("film ou categorie inexistants");
        }
    }
}
