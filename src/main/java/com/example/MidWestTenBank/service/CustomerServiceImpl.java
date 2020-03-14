package com.example.MidWestTenBank.service;

//import java.util.Arrays;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MidWestTenBank.model.Customer;
import com.example.MidWestTenBank.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public List<Customer> allCustomers() {
		
		List<Customer> all = customerRepo.findAll();
		
		all.sort(Comparator.comparing(Customer :: getLastName));
		
		return all;
	}

	@Override
	public void newCustomer(Customer customer) {
		
		customerRepo.save(customer);
		
	}

	@Override
	public Customer getCustomer(Long id) {
		Customer customer = customerRepo.findById(id).get();
		
		return customer;
	}

}
