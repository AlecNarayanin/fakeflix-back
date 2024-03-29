package com.example.fakeflix.controllers;

import com.example.fakeflix.entities.Utilisateur;
import com.example.fakeflix.models.user.AuthDTO;
import com.example.fakeflix.models.user.JwtResponse;
import com.example.fakeflix.models.user.RegisterDTO;
import com.example.fakeflix.services.JwtUserDetailsService;
import com.example.fakeflix.services.UserService;
import com.example.fakeflix.utils.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthentificationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthDTO authDTO) throws Exception {
        authenticate(authDTO.getUsername(), authDTO.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(authDTO.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }


    @RequestMapping(value="/register",method = RequestMethod.POST)
    public ResponseEntity registerUser(@RequestBody RegisterDTO registerDTO) throws Exception {

        if(userService.getByUsername(registerDTO.getUsername()) == null){
            Utilisateur u = userService.encryptUserPassword(registerDTO.toModel());
            userService.upsert(u);
            return ResponseEntity.ok("User successfully created");
        }else{
            return ResponseEntity.badRequest().body("User already exist");
        }

    }



    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }


}
