package com.wallet.onlinewalletapplication.controller;

import com.wallet.onlinewalletapplication.Service.CustomerServiceImpl;
import com.wallet.onlinewalletapplication.module.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	@GetMapping("/hello")
	public String sayHello(){
		return "Welcome to Online wallet Application";
	}
	// to register user
	@PostMapping(value = "/customer")
	public Customer saveCustomer(@Valid @RequestBody Customer customer) {
		return customerServiceImpl.createCustomer(customer);
	}
	
	// To update existing user details by passing its login key
	@PutMapping(value = "/customer")
	public Customer updateCustomer(@Valid @RequestBody Customer customer) {
		return customerServiceImpl.updateCustomer(customer);
	}
	
	// To delete existing user details by passing its login key
	@DeleteMapping(value = "/customer")
	public Customer deleteCustomer() {
		return customerServiceImpl.deleteCustomer();
	}
	
	// To get details of current user by passing its login key
	@GetMapping(value = "/customer")
	public Customer getCustomerDetails() {
		return customerServiceImpl.getCustomerDetails();
	}
	
}
