package com.stenahe.business_logic.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OrderServiceTest {

    @Test
    void testGetAllOrders() {
        OrderService orderService = new OrderService();
        assertEquals(2, orderService.getAllOrders().size());
    }

    @Test
    void testCalculateTotalPrice() {
        OrderService orderService = new OrderService();
        double total = orderService.calculateTotalPrice("1001");
        assertEquals(2000.0, total);
    }

    @Test
    void testCalculateTotalPriceForInvalidOrder() {
        OrderService orderService = new OrderService();
        double total = orderService.calculateTotalPrice("9999");
        assertEquals(0.0, total);
    }

}