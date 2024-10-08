package com.jwt.example.AuthMicroService.controllers;

import com.jwt.example.AuthMicroService.model.JwtRequest;
import com.jwt.example.AuthMicroService.model.JwtResponse;
import com.jwt.example.AuthMicroService.security.JwtHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtHelper jwtHelper;


    private Logger logger= LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request){
        this.doAuthentication(request.getEmail(),request.getPassword());
        UserDetails userDetails=userDetailsService.loadUserByUsername(request.getEmail());
        String token=this.jwtHelper.generateToken(userDetails);

        JwtResponse response=JwtResponse.builder().jwtToken(token).userName(userDetails.getUsername()).build();
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthentication(String email,String password){
        UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(email,password);

        try{
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid Username or Password");
        }
    }

}
