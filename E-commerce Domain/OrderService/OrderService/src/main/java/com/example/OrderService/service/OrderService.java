package com.example.OrderService.service;

import com.example.OrderService.dto.OrderRequestDTO;
import com.example.OrderService.dto.OrderResponseDTO;
import com.example.OrderService.entity.Order;
import com.example.OrderService.exception.OrderNotFoundException;
import com.example.OrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Create a new order
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        Order order = new Order();
        order.setProductId(orderRequestDTO.getProductId());
        order.setQuantity(orderRequestDTO.getQuantity());
        order.setTotalPrice(orderRequestDTO.getTotalPrice());
        order.setOrderStatus(orderRequestDTO.getOrderStatus());
        order = orderRepository.save(order);
        return mapToResponseDTO(order);
    }

    // Retrieve all orders
    public List<OrderResponseDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    // Retrieve order by ID
    public OrderResponseDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + id));
        return mapToResponseDTO(order);
    }

    // Update an existing order
    public OrderResponseDTO updateOrder(Long id, OrderRequestDTO orderRequestDTO) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + id));
        existingOrder.setProductId(orderRequestDTO.getProductId());
        existingOrder.setQuantity(orderRequestDTO.getQuantity());
        existingOrder.setTotalPrice(orderRequestDTO.getTotalPrice());
        existingOrder.setOrderStatus(orderRequestDTO.getOrderStatus());
        existingOrder = orderRepository.save(existingOrder);
        return mapToResponseDTO(existingOrder);
    }

    // Delete an order
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + id));
        orderRepository.delete(order);
    }

    // Helper method to map Order to OrderResponseDTO
    private OrderResponseDTO mapToResponseDTO(Order order) {
        return new OrderResponseDTO(
                order.getId(),
                order.getProductId(),
                order.getQuantity(),
                order.getTotalPrice(),
                order.getOrderStatus()
        );
    }
}

