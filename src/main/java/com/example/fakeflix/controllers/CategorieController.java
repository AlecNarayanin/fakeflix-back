package com.example.fakeflix.controllers;

import com.example.fakeflix.entities.Categorie;
import com.example.fakeflix.models.categorie.RegisterDTO;
import com.example.fakeflix.models.categorie.UpsertDTO;
import com.example.fakeflix.services.CategorieService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @Operation(summary = "Retourne toutes les categories")
    @RequestMapping(path = "/categorie/all", method = RequestMethod.GET)
    public List<Categorie> getCategories(){
        return categorieService.getAll();
    }

    @Operation(summary = "Retourne une categorie")
    @RequestMapping(path = "categorie/{id}", method = RequestMethod.GET)
    public Categorie getCategorie(@PathVariable(value = "id") Integer id){
        return categorieService.getById(id);
    }

    @Operation(summary = "Créer une categorie")
    @RequestMapping(path = "categorie", method = RequestMethod.POST)
    public Categorie createCategorie(@RequestBody RegisterDTO registerDTO) {
        Categorie c = registerDTO.toModel();
        return categorieService.create(c);
    }

    @Operation(summary = "Mettre a jour une categorie")
    @RequestMapping(path = "categorie", method = RequestMethod.PUT)
    public void updateCategorie(@RequestBody UpsertDTO upsertDTO) throws Exception {
        Categorie c = upsertDTO.mapCategorieModelFromDTO(categorieService.getById(upsertDTO.getId()));
        boolean operationResult = categorieService.update(c);
        if(!operationResult){
            throw new Exception("categorie inexistante");
        }
    }

    @Operation(summary = "Supprimer une categorie")
    @RequestMapping(path = "categorie/{id}", method = RequestMethod.DELETE)
    public void deleteCategorie(@PathVariable(value = "id")Integer id) throws Exception {
        boolean operationResult = categorieService.delete(id);
        if(!operationResult){
            throw new Exception("categorie inexistante");
        }
    }
}
