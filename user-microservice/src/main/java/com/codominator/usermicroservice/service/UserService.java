package com.codominator.usermicroservice.service;


import com.codominator.usermicroservice.entity.User;
import com.codominator.usermicroservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public List<User> getUser() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        User createUser = new User();

        createUser.setUsername(user.getUsername());
        createUser.setPassword(user.getPassword());
        createUser.setEmail(user.getEmail());

        return userRepository.save(createUser);
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> updateUser(Long id, User user) {

        return userRepository.findById(id).map(user1 -> {
            user1.setUsername(user.getUsername());
            user1.setPassword(user.getPassword());
            user1.setEmail(user.getEmail());
            return userRepository.save(user1);
        });
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
