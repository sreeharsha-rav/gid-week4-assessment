package com.ordermicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ordermicroservice.service.OrderService;
import com.ordermicroservice.request.OrderRequest;
import com.ordermicroservice.response.OrderResponse;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	// Hello world
	@GetMapping("/hello")
	public String hello() {
		return "Hello World from Order Microservice";
	}
	
	// Create a new order
	@PostMapping("/add")
	public OrderResponse createOrder(@RequestBody OrderRequest newOrderRequest) {
		return orderService.createOrder(newOrderRequest);
	}
	
	// Get order by id
	@GetMapping("/{id}")
	public OrderResponse getOrderById(@PathVariable long id) {
		return orderService.getOrderById(id);
	}
	
	// Get all orders
	@GetMapping("/all")
	public List<OrderResponse> getAllOrders() {
		return orderService.getAllOrders();
	}
}
