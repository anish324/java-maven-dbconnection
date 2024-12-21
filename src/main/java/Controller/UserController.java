package com.example.demo.controller;

import com.example.demo.model.User;  // Make sure this import is correct!
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController  // Marks this class as a REST controller
@RequestMapping("/users")  // Base URL for all user-related endpoints
public class UserController {

    @Autowired  // Injects the UserService bean
    private UserService userService;

    // Endpoint to create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Endpoint to get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Endpoint to get a user by ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Endpoint to delete a user by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
