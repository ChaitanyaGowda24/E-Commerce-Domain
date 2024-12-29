package com.example.OrderService.repository;

import com.example.OrderService.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByName(String username);
    // Additional query methods can be added here if needed
}

