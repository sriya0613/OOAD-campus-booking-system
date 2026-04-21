package com.campus.booking.controller;

import com.campus.booking.model.User;
import com.campus.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // CREATE USER
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // GET ALL USERS
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // LOGIN API
    @PostMapping("/login")
    public User login(@RequestBody User loginUser) {

        return userRepository.findAll().stream()
                .filter(u -> u.getName().equals(loginUser.getName())
                        && u.getPassword().equals(loginUser.getPassword()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}
