package com.example.fakeflix.services;

import com.example.fakeflix.entities.Utilisateur;
import com.example.fakeflix.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Utilisateur upsert(Utilisateur user) {
        return userRepository.save(user);
    }
    public Utilisateur getById(Integer id) {
        return userRepository.getById(id);
    }

    public Utilisateur getByUsername(String username){
        return userRepository.getByUsername(username);
    }

    public void delete(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
    public List<Utilisateur> getAll() {
        return userRepository.findAll();
    }


    public Utilisateur encryptUserPassword(Utilisateur u){
        u.setPassword( passwordEncoder.encode(u.getPassword()));
        return u;
    }

    public Utilisateur getCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal =  auth.getPrincipal();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> principalValues = mapper.convertValue(principal, Map.class);

        if(principalValues.containsKey("username"))
            return getByUsername(principalValues.get("username").toString());

        return null;
    }




}
