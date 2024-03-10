package com.ordermicroservice.request;

// This class is a representation of an order request.
public class OrderRequest {
	
	private String name;
	private int quantity;
	
	public OrderRequest() {
	}
	
	public OrderRequest(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
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
