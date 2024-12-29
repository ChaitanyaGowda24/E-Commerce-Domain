package com.example.ProductService.dto;

import jakarta.validation.constraints.NotBlank;

public class AuthRequest {

    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    // Default Constructor
    public AuthRequest() {
    }

    // Parameterized Constructor
    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

