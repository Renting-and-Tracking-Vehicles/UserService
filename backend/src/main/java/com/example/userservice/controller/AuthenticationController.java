package com.example.userservice.controller;

import com.example.userservice.auth.TokenUtils;
import com.example.userservice.dto.Jwt;
import com.example.userservice.dto.JwtAuthenticationRequest;
import com.example.userservice.model.RegisteredUserEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;


    @PostMapping("/login")
    public ResponseEntity<Jwt> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        RegisteredUserEntity registeredUser = (RegisteredUserEntity) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(registeredUser.getEmail());
        int expiresIn = tokenUtils.getExpiredIn();

        return ResponseEntity.ok(new Jwt(jwt, expiresIn));

    }
}
