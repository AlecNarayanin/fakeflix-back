package com.example.fakeflix.controllers;

import com.example.fakeflix.entities.Participation;
import com.example.fakeflix.models.participation.RegisterParticipationDTO;
import com.example.fakeflix.models.participation.UpsertParticipationDTO;
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

    @RequestMapping(value ="/participation" , method = RequestMethod.POST)
    public ResponseEntity<?> createParticipation(@RequestBody RegisterParticipationDTO registerParticipationDTO) throws Exception {
        try{
            Participation p = registerParticipationDTO.toModel();
            participationService.create(p);
            return ResponseEntity.ok("create success");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value ="/participation" , method = RequestMethod.PUT)
    public ResponseEntity<?> updateParticipation(@RequestBody UpsertParticipationDTO upsertParticipationDTO) throws Exception {
        try{
            Participation p = upsertParticipationDTO.mapParticipationModelFromDTO(participationService.getById(upsertParticipationDTO.getId()));
            participationService.update(p);
            return ResponseEntity.ok("update success");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/participation/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteParticipation(@PathVariable("id") Integer id) throws Exception {
        try{
            participationService.delete(id);
            return ResponseEntity.ok("delete success");

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
