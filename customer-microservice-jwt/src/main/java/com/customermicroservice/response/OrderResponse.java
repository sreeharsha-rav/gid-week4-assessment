package com.customermicroservice.response;

public class OrderResponse {
	private Long id;
	private String name;
	private int quantity;
	
	public OrderResponse() {
	}
	
	public OrderResponse(Long id, String name, int quantity) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
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
