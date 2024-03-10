package com.customermicroservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.customermicroservice.entity.Customer;
import com.customermicroservice.repository.CustomerRepository;
import com.customermicroservice.request.CustomerRequest;
import com.customermicroservice.response.CustomerResponse;
import com.customermicroservice.response.OrderResponse;

import reactor.core.publisher.Mono;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	WebClient webClient;
	
	// Add new customer
	public CustomerResponse createCustomer(CustomerRequest newCustomerRequest) {
		Customer newCustomer = new Customer();
		newCustomer.setCustomerName(newCustomerRequest.getName());
		newCustomer.setCustomerEmail(newCustomerRequest.getEmail());
		// Set the order id
		newCustomer.setOrderId(newCustomerRequest.getOrderId());
		newCustomer = customerRepository.save(newCustomer);
		// Get the order details
		CustomerResponse customerResponse = new CustomerResponse(newCustomer);
		customerResponse.setOrderResponse(getOrderById(newCustomer.getOrderId()));
		
		return customerResponse;
	}
	
	// Get order by id
	public OrderResponse getOrderById(long id) {
		Mono<OrderResponse> orderResponse = webClient.get().uri("/api/order/" + id).retrieve().bodyToMono(OrderResponse.class);
		return orderResponse.block();
	}
	
	// Get customer by id
	public CustomerResponse getCustomerById(long id) {
		Customer customer = customerRepository.findById(id).orElse(null);
		CustomerResponse customerResponse = new CustomerResponse(customer);
		customerResponse.setOrderResponse(getOrderById(customer.getOrderId()));
		return customerResponse;
	}
	
	// Get all customers
	public List<CustomerResponse> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerResponse> customerResponses = new ArrayList<>();
		for (Customer customer : customers) {
			CustomerResponse customerResponse = new CustomerResponse(customer);
			customerResponse.setOrderResponse(getOrderById(customer.getOrderId()));
			customerResponses.add(customerResponse);
		}
		return customerResponses;
	}
	
}
