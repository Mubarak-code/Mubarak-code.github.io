package com.example.MidWestTenBank.service;

import java.util.List;

import com.example.MidWestTenBank.model.Customer;

public interface CustomerService {
	
	List<Customer> allCustomers();
	void newCustomer(Customer customer);
	Customer getCustomer(Long id);

}
