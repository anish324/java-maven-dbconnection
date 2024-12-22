package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Batch Insert Endpoint
    @PostMapping("/batch")
    public ResponseEntity<List<User>> addUsers(@Valid @RequestBody List<User> users) {
        List<User> savedUsers = userRepository.saveAll(users); // Batch insert
        return ResponseEntity.ok(savedUsers);
    }

    // Retrieve All Users
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(
            @RequestParam(defaultValue = "0") int page,  // Default page is 0 (first page)
            @RequestParam(defaultValue = "10") int size // Default size is 10 records
    ) {
        Pageable pageable = PageRequest.of(page, size); // Create pagination object
        Page<User> usersPage = userRepository.findAll(pageable); // Fetch data with pagination
        List<User> users = usersPage.getContent(); // Extract content from the Page object
        return ResponseEntity.ok(users);
    }
}
