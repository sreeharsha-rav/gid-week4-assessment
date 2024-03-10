package com.customermicroservice.request;

public class CustomerRequest {

	private String name;
	private String email;
	
	private Long orderId; // This will be used to map the customer with the order.
	
	public CustomerRequest() {
	}
	
	public CustomerRequest(String name, String email, Long orderId) {
		this.name = name;
		this.email = email;
		this.orderId = orderId;
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
	
	public Long getOrderId() {
		return orderId;
	}
	
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
}
