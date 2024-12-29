package com.example.OrderService.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.List;

public class OrderRequestDTO {

    @NotNull(message = "Product IDs cannot be null")
    private List<Long> productIds;

    @NotNull(message = "Customer ID cannot be null")
    @Positive(message = "Customer ID must be a positive value")
    private Long customerId;

    @NotNull(message = "Total price cannot be null")
    @Positive(message = "Total price must be a positive value")
    private Double totalPrice;

    // Getters and Setters
    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

