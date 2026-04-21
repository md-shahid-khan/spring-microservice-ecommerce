package com.codominator.usermicroservice.controller;

import com.codominator.usermicroservice.entity.User;
import com.codominator.usermicroservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private List<User> users = new ArrayList<User>();

    @GetMapping("/get-all")
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok().body(userService.getUser());
    }

    @PostMapping("/create")
    public ResponseEntity<User> getUser(@RequestBody User user){
        User u = new User();
        u.setId(user.getId());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        users.add(u);
        return ResponseEntity.ok().body(u);
    }

}
