package com.example.fakeflix.controllers;
import com.example.fakeflix.entities.Personne;
import com.example.fakeflix.models.person.RegisterDTO;
import com.example.fakeflix.models.person.UpsertDTO;
import com.example.fakeflix.services.PersonneService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonneController {

    @Autowired
    private PersonneService personneService;

    @Operation(summary = "Retourne une personne")
    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public Personne getPerson(@PathVariable(value = "id") Integer id) {
        return personneService.getById(id);
    }

    @Operation(summary = "Créer une personne")
    @RequestMapping(value ="/person" , method = RequestMethod.POST)
    public Personne createPersonne(@RequestBody RegisterDTO registerDTO){
        Personne p = registerDTO.toModel();
        return personneService.create(p);
    }

    @Operation(summary = "Mettre à jour une personne")
    @RequestMapping(value ="/person" , method = RequestMethod.PUT)
    public void updatePersonne(@RequestBody UpsertDTO upsertDTO) throws Exception{
        Personne p = upsertDTO.mapPersonModelFromDTO(personneService.getById(upsertDTO.getId()));
        boolean operationResult = personneService.update(p);
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
