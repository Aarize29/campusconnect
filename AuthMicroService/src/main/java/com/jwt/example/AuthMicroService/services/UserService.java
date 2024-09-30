package com.jwt.example.AuthMicroService.services;

import com.jwt.example.AuthMicroService.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> users=new ArrayList<>();

    public UserService() {
        users.add(new User(1,"Aarize", "aarize123","Shams Aarize Siddique","shamsaarize@gmail.com","Student","6203995489"));
        users.add(new User(2,"Faisal", "faisal123","Faisal Tanveer","faisal@gmail.com","Student","9999999991"));
        users.add(new User(3,"Shadan", "shadan123","Shadan Ijmal Siddique","shadan@gmail.com","Student","8889997771"));
    }

    public List<User> getUsers(){
        return this.users;
    }
}
