package com.example.fakeflix.controllers;

import com.example.fakeflix.entities.Utilisateur;
import com.example.fakeflix.models.user.AuthDTO;
import com.example.fakeflix.models.user.JwtResponse;
import com.example.fakeflix.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/me", method = RequestMethod.GET)
    public ResponseEntity<?> getCurrentUser() throws Exception {
        Utilisateur u = userService.getCurrentUser();
        return u != null ? ResponseEntity.ok(u) : ResponseEntity.badRequest().body("User dont have username");
    }

}
