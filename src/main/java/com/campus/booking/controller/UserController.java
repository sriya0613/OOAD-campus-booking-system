package com.campus.booking.controller;

import com.campus.booking.model.User;
import com.campus.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public java.util.List<User> getAllUsers() {
        return userRepository.findAll();
    }
}