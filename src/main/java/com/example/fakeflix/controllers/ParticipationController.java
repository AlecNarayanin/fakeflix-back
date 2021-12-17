package com.example.fakeflix.controllers;

import com.example.fakeflix.entities.Participation;
import com.example.fakeflix.models.participation.UpsertDTO;
import com.example.fakeflix.services.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParticipationController {

    @Autowired
    private ParticipationService participationService;

    @RequestMapping(value = "/participation", method = RequestMethod.GET)
    public List<Participation> getParticipations() {
        return participationService.getAll();
    }

    @RequestMapping(value = "/participation/{id}", method = RequestMethod.GET)
    public Participation getParticipation(@PathVariable("id") Integer id) {
        return participationService.getById(id);
    }

    @RequestMapping(value ="/user" , method = RequestMethod.POST)
    public ResponseEntity<?> createParticipation(@RequestBody UpsertDTO upsertDTO) {
        try{
            Participation p = upsertDTO.mapParticipationModelFromDTO(participationService.getById(upsertDTO.getId()));
            boolean result = participationService.create(p);
            return ResponseEntity.ok("update success");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value ="/user" , method = RequestMethod.PUT)
    public ResponseEntity<?> updateParticipation(@RequestBody UpsertDTO upsertDTO) {
        try{
            Participation p = upsertDTO.mapParticipationModelFromDTO(participationService.getById(upsertDTO.getId()));
            participationService.update(p);
            return ResponseEntity.ok("update success");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/user/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteParticipation(@PathVariable("id") Integer id) {
        try{
            participationService.delete(id);
            return ResponseEntity.ok("delete success");

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
