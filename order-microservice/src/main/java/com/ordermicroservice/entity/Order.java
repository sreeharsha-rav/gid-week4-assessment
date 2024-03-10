package com.ordermicroservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;
	@Column(name = "order_name")
	private String orderName;
	@Column(name = "quantity")
	private int quantity;
	
	public Order() {
	}
	
	public Order(String orderName, int quantity) {
		this.orderName = orderName;
		this.quantity = quantity;
	}
	
	public Long getOrderId() {
		return orderId;
	}
	
	public String getOrderName() {
		return orderName;
	}
	
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", quantity=" + quantity + "]";
	}
}
