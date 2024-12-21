package com.example.demo.service;

import com.example.demo.repository.UserRepository;  // Import statement
import com.example.demo.model.User;  // Import statement for User

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;  // Injecting the UserRepository

    // Method to save a user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Method to get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Method to get a user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Method to delete a user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
