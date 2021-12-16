package com.example.fakeflix.controllers;

import com.example.fakeflix.entities.Film;
import com.example.fakeflix.entities.Utilisateur;
import com.example.fakeflix.models.user.AuthDTO;
import com.example.fakeflix.models.user.JwtResponse;
import com.example.fakeflix.models.user.RegisterDTO;
import com.example.fakeflix.models.user.UpsertDTO;
import com.example.fakeflix.services.FilmService;
import com.example.fakeflix.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FilmService filmService;

    @RequestMapping(value = "/user/me", method = RequestMethod.GET)
    public ResponseEntity<?> getCurrentUser() throws Exception {
        Utilisateur u = userService.getCurrentUser();
        return u != null ? ResponseEntity.ok(u) : ResponseEntity.badRequest().body("User dont have username");
    }


    @RequestMapping(value ="/user" , method = RequestMethod.POST)
    public ResponseEntity<?> updateUser(@RequestBody UpsertDTO upsertDTO) {
        try{

            Utilisateur u =  upsertDTO.MapUserModelFromDTO(userService.getById(upsertDTO.getId()));

            if(upsertDTO.getPassword() != null){
                userService.encryptUserPassword(u);
            }

            Utilisateur userWithName  = userService.getByUsername(upsertDTO.getUsername());

            if(userWithName == null || userWithName.getId().equals(u.getId())){
                userService.upsert(u);
                return ResponseEntity.ok(u);
            }
            return ResponseEntity.badRequest().body("User with this name already exist");

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @RequestMapping(value = "/user/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        try{

            Utilisateur u = userService.getCurrentUser();

            if(u.getId().equals(id)){
                userService.delete(id);
                return ResponseEntity.ok("User successfuly deleted");
            }
            return ResponseEntity.status(401).body("Vous n'avez pas les droits de supprimer cet utilisateur");

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @RequestMapping(value="/user/{userId}/film/{filmId}/favorite", method = RequestMethod.POST)
    public ResponseEntity<?> addFilmFavoriteToUser(@PathVariable("userId") Integer userId, @PathVariable("filmId") Integer filmId){
        try{

            Film film = filmService.GetById(filmId);
            Utilisateur user = userService.getById(userId);
            Utilisateur currentUser = userService.getCurrentUser();

            if(film != null && user != null && user.getId().equals(currentUser.getId())){
                user.addFilm(film);
                userService.upsert(user);
                return  ResponseEntity.ok(user);
            }

            return ResponseEntity.badRequest().body(" ");

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @RequestMapping(value="/user/{userId}/film/{filmId}/favorite", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeFilmFavoriteToUser(@PathVariable("userId") Integer userId, @PathVariable("filmId") Integer filmId){
        try{

            Film film = filmService.GetById(filmId);
            Utilisateur user = userService.getById(userId);
            Utilisateur currentUser = userService.getCurrentUser();

            if(film != null && user != null && user.getId().equals(currentUser.getId())){
                user.removeFilm(film);
                userService.upsert(user);
                return  ResponseEntity.ok(user);
            }
            return ResponseEntity.badRequest().body(" ");

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




}
