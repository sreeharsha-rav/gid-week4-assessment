package com.ordermicroservice.response;

import com.ordermicroservice.entity.Order;

// This class is a response class that will be used to send the order details as a response.
public class OrderResponse {
	private Long id;
	private String name;
	private int quantity;
	
	public OrderResponse() {
	}
	
	public OrderResponse(Order order) {
		this.id = order.getOrderId();
		this.name = order.getOrderName();
		this.quantity = order.getQuantity();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
