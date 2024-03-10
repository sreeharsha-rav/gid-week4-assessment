package com.ordermicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermicroservice.repository.OrderRepository;
import com.ordermicroservice.entity.Order;
import com.ordermicroservice.request.OrderRequest;
import com.ordermicroservice.response.OrderResponse;

import java.util.List;
import java.util.ArrayList;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	// Add new order
	public OrderResponse createOrder(OrderRequest newOrderRequest) {
		Order newOrder = new Order();
		newOrder.setOrderName(newOrderRequest.getName());
		newOrder.setQuantity(newOrderRequest.getQuantity());
		return new OrderResponse(orderRepository.save(newOrder));
	}
	
	// Get order by id else return null
	public OrderResponse getOrderById(long id) {
		return new OrderResponse(orderRepository.findById(id).orElse(null));
    }
	
	// Get all orders
	public List<OrderResponse> getAllOrders() {
		List<Order> orders = orderRepository.findAll();
		List<OrderResponse> orderResponses = new ArrayList<>();
		for (Order order : orders) {
			orderResponses.add(new OrderResponse(order));
		}
		return orderResponses;
	}
}
