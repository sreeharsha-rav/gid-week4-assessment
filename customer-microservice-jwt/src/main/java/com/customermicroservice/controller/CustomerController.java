package com.customermicroservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.customermicroservice.request.CustomerRequest;
import com.customermicroservice.response.CustomerResponse;
import com.customermicroservice.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World from Customer Microservice";
	}
	
	// Create a new customer
	@PostMapping("/add")
	public CustomerResponse createCustomer(@RequestBody CustomerRequest newCustomerRequest) {
		return customerService.createCustomer(newCustomerRequest);
	}
	
	// Get customer by id
	@GetMapping("/{id}")
	public CustomerResponse getCustomerById(@PathVariable long id) {
		return customerService.getCustomerById(id);
	}
	
	// Get all customers
	@GetMapping("/all")
	public List<CustomerResponse> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
}
