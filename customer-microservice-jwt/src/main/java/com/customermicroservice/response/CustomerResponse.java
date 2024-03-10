package com.customermicroservice.response;

import com.customermicroservice.entity.Customer;

public class CustomerResponse {
	
	private long id;
	private String name;
	private String email;
	private OrderResponse orderResponse;
	
	public CustomerResponse() {
	}
	
	public CustomerResponse(Customer customer) {
		this.id = customer.getCustomerId();
		this.name = customer.getCustomerName();
		this.email = customer.getCustomerEmail();
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public OrderResponse getOrderResponse() {
		return orderResponse;
	}
	
	public void setOrderResponse(OrderResponse orderResponse) {
		this.orderResponse = orderResponse;
	}
}
