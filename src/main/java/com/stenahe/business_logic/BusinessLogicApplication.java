package com.stenahe.business_logic;

import com.stenahe.business_logic.model.Order;
import com.stenahe.business_logic.model.Product;
import com.stenahe.business_logic.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

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

		System.out.println("---------------");
		orderService.addProduct(new Product("4", "Mouse", 50.00));
		List<Product> mockProducts = orderService.getProducts();
		orderService.addOrder(
				"1003",
                new java.util.ArrayList<> (List.of(
                        mockProducts.get(1),
                        mockProducts.get(2),
                        mockProducts.get(3)
                        )));

		orderService.getAllOrders().forEach(order -> {
			System.out.println("Order ID: " + order.getId());
			order.getProducts().forEach(product -> {
				System.out.println("  Product: " + product.getName() + " - $" + product.getPrice());
			});
			System.out.println("  Total: $" + orderService.calculateTotalPrice(order.getId()));
		});
	}
}
