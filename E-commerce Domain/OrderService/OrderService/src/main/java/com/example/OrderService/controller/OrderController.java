package com.example.OrderService.controller;

import com.example.OrderService.dto.OrderRequestDTO;
import com.example.OrderService.dto.OrderResponseDTO;
import com.example.OrderService.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Create a new order
    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody @Valid OrderRequestDTO orderRequestDTO) {
        OrderResponseDTO createdOrder = orderService.createOrder(orderRequestDTO);
        return ResponseEntity.ok(createdOrder);
    }

    // Get all orders
    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        List<OrderResponseDTO> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    // Get an order by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Long id) {
        OrderResponseDTO order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    // Update an order
    @PutMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> updateOrder(@PathVariable Long id, @RequestBody @Valid OrderRequestDTO orderRequestDTO) {
        OrderResponseDTO updatedOrder = orderService.updateOrder(id, orderRequestDTO);
        return ResponseEntity.ok(updatedOrder);
    }

    // Delete an order
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Order deleted successfully");
    }
}
