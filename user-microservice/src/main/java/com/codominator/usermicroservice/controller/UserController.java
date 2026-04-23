package com.codominator.usermicroservice.controller;


import com.codominator.usermicroservice.entity.User;
import com.codominator.usermicroservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
      return ResponseEntity.ok().body(userService.createUser(user));
    }

    @PostMapping("/find/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        Optional<User> userById = userService.findUserById(id);
        return userById.map(user -> ResponseEntity.ok().body(user)).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{id}") // Use @PutMapping for updates
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        return userService.updateUser(id, user)
                .map(updatedUser -> ResponseEntity.ok().body(updatedUser))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User has been deleted", HttpStatus.OK);
    }

}
