package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity // Marks this class as a JPA entity
public class User {

    @Id // Marks the id field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key (like AUTO_INCREMENT in MySQL)
    private Long id;

    @NotNull(message = "Name cannot be null")  // Validate that the name is not null
    @Size(min = 2, message = "Name must have at least 2 characters")  // Validate that the name has at least 2 characters
    private String name;

    @NotNull(message = "Email cannot be null")  // Validate that the email is not null
    @Email(message = "Email should be valid")  // Validate that the email format is correct
    private String email;

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
