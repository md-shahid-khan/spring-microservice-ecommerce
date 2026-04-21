package com.codominator.usermicroservice.service;

import com.codominator.usermicroservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    static Long increment = 1L;
    List<User> users = new ArrayList<User>();
    public List<User> getUser(){
        return users;
    }

    public User createUser(User user){
        User createUser = new User();
        createUser.setId(increment++);
        createUser.setUsername(user.getUsername());
        createUser.setPassword(user.getPassword());
        createUser.setEmail(user.getEmail());
        users.add(user);
        return user;
    }
}
