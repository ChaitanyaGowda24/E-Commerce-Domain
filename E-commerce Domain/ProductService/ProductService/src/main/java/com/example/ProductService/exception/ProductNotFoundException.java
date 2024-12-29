package com.example.ProductService.exception;

public class ProductNotFoundException extends RuntimeException {

    // Constructor with message
    public ProductNotFoundException(String message) {
        super(message);
    }

    // Constructor with message and cause
    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}


