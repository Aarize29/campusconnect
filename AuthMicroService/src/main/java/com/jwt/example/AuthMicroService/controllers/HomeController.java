package com.jwt.example.AuthMicroService.controllers;


import com.jwt.example.AuthMicroService.model.User;
import com.jwt.example.AuthMicroService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUser(){
     System.out.println("Getting users");

     return this.userService.getUsers();
    }

    @GetMapping("/currentuser")
    public String currentUser(Principal principal){

        return principal.getName();
    }

}
