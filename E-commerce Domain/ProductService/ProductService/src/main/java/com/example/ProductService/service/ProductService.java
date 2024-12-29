package com.example.ProductService.service;

import com.example.ProductService.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();              // Fetch all products
    Product getProductById(Long id);             // Fetch a product by ID
    Product createProduct(Product product);      // Create a new product
    Product updateProduct(Long id, Product product); // Update an existing product
    void deleteProduct(Long id);                 // Delete a product
}

