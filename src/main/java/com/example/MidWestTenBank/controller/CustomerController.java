package com.example.MidWestTenBank.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.MidWestTenBank.model.Customer;
import com.example.MidWestTenBank.service.CustomerService;

@Controller
@RequestMapping("/api/")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/allcustomers")
	public ResponseEntity<?> getAllCustomers(){
		List<Customer> allCustomers = customerService.allCustomers();
		
		return new ResponseEntity<List<Customer>>(allCustomers, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerNewCustomer(@RequestBody Customer customer) {
		
		if (customer != null) {
			customerService.newCustomer(customer);
			return new ResponseEntity<String>("customer details saved", HttpStatus.OK);
		}else
			return new ResponseEntity<String>("customer details missing", HttpStatus.BAD_REQUEST);
	
	}
	
	@GetMapping("/getcustomer/{id}")
	public ResponseEntity<?> getCustomer(@PathVariable ("id")  Long customerId){
		if (customerId != null) {
			Customer customer = customerService.getCustomer(customerId);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}else
			return new ResponseEntity<String>("id not inserted", HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("/deletecustomer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable ("id") Long customerId){
		if (customerId != null) {
			customerService.deleteCustomer(customerId);
			return new ResponseEntity<String>("Customer has been deleted", HttpStatus.OK);
		}else
			return new ResponseEntity<String>("id not inserted", HttpStatus.BAD_REQUEST);
		
	}

}
