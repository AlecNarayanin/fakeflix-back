package com.example.fakeflix.controllers;

import com.example.fakeflix.entities.Film;
import com.example.fakeflix.entities.Personne;
import com.example.fakeflix.entities.Utilisateur;
import com.example.fakeflix.models.user.UpsertDTO;
import com.example.fakeflix.services.FilmService;
import com.example.fakeflix.services.PersonneService;
import com.example.fakeflix.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonneController {

    @Autowired
    private PersonneService personneService;

    @Operation(summary = "Retourne une personne")
    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public Personne getPerson(@PathVariable(value = "id") Integer id) throws Exception {
        return personneService.getById(id);
    }

    @Operation(summary = "Créer une personne")
    @RequestMapping(value ="/person" , method = RequestMethod.POST)
    public Personne createPersonne(@RequestBody Personne person){
       return personneService.create(person);
    }

    @Operation(summary = "Mettre à jour une personne")
    @RequestMapping(value ="/person" , method = RequestMethod.PUT)
    public void updatePersonne(@RequestBody Personne person) throws Exception{
        boolean operationResult = personneService.update(person);
        if(!operationResult){
            throw new Exception("Personne inexistante");
        }
    }


    @Operation(summary = "Supprimer une personne")
    @RequestMapping(value = "/person/{id}" , method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Integer id) throws Exception {
        boolean operationResult = personneService.delete(id);
        if(!operationResult){
            throw new Exception("Personne inexistante");
        }

    }




}
