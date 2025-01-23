package com.stenahe.business_logic;

import com.stenahe.business_logic.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BusinessLogicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessLogicApplication.class, args);

		OrderService orderService = new OrderService();

		orderService.getAllOrders().forEach(order -> {
			System.out.println("Order ID: " + order.getId());
			order.getProducts().forEach(product -> {
				System.out.println("  Product: " + product.getName() + " - $" + product.getPrice());
			});
			System.out.println("  Total: $" + orderService.calculateTotalPrice(order.getId()));
		});
	}
}
