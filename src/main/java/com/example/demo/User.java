package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Marks this class as a JPA entity.
public class User {

    @Id // Marks the id field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key (like AUTO_INCREMENT in MySQL)
    private Long id;

    private String name;  // Field to store the user's name
    private String email; // Field to store the user's email

    // Default constructor (needed by JPA)
    public User() {}

    // Constructor to initialize the object with name and email
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Override toString() method for easy debugging
    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}
