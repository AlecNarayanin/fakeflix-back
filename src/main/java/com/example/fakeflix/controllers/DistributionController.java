package com.example.fakeflix.controllers;

import com.example.fakeflix.entities.Distribution;
import com.example.fakeflix.models.distribution.RegisterDTO;
import com.example.fakeflix.models.distribution.UpsertDTO;
import com.example.fakeflix.services.DistributionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DistributionController {

    @Autowired
    private DistributionService distributionService;

    @Operation(summary = "Retourne toutes les distribution")
    @RequestMapping(path = "/distribution/all", method = RequestMethod.GET)
    public List<Distribution> getDistributions(){
        return distributionService.getAll();
    }

    @Operation(summary = "Retourne une distribution")
    @RequestMapping(path = "/distribution/{id}", method = RequestMethod.GET)
    public Distribution getDistribution(@PathVariable(value = "id") Integer id){
        return distributionService.getById(id);
    }

    @Operation(summary = "Créer une distribution")
    @RequestMapping(path = "/distribution", method = RequestMethod.POST)
    public Distribution createDistribution(@RequestBody RegisterDTO registerDTO) {
        Distribution d = registerDTO.toModel();
        return distributionService.create(d);
    }

    @Operation(summary = "Mettre a jour une distribution")
    @RequestMapping(path = "/distribution", method = RequestMethod.PUT)
    public void updateCategorie(@RequestBody UpsertDTO upsertDTO) throws Exception {
        Distribution d = upsertDTO.mapDistributionModelFromDTO(distributionService.getById(upsertDTO.getId()));
        boolean operationResult = distributionService.update(d);
        if(!operationResult){
            throw new Exception("distribution inexistante");
        }
    }

    @Operation(summary = "Supprimer une distribution")
    @RequestMapping(path = "/distribution/{id}", method = RequestMethod.DELETE)
    public void deleteDistribution(@PathVariable(value = "id")Integer id) throws Exception {
        boolean operationResult = distributionService.delete(id);
        if(!operationResult){
            throw new Exception("distribution inexistante");
        }
    }
}
