package com.stenahe.business_logic.service;

import com.stenahe.business_logic.model.Order;
import com.stenahe.business_logic.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Product> mockProducts = new ArrayList<>();
    private List<Order> mockOrders = new ArrayList<>();

    public OrderService() {
        mockProducts.add(new Product("1", "Laptop", 1200.00));
        mockProducts.add(new Product("2", "Smartphone", 800.00));
        mockProducts.add(new Product("3", "Headphones", 150.00));

        mockOrders.add(new Order("1001", List.of(mockProducts.get(0), mockProducts.get(1))));
        mockOrders.add(new Order("1002", List.of(mockProducts.get(2))));
    }

    public List<Order> getAllOrders() {
        return mockOrders;
    }

    public double calculateTotalPrice(String orderId) {
        return mockOrders.stream()
                .filter(order -> order.getId().equals(orderId))
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
