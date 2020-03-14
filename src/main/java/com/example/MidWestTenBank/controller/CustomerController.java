package com.example.MidWestTenBank.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.MidWestTenBank.model.Customer;
import com.example.MidWestTenBank.service.CustomerService;

@Controller
@RequestMapping("/api/")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/allcustomers")
	public ModelAndView getAllCustomers(){
		List<Customer> allCustomers = customerService.allCustomers();
		ModelAndView modelandView = new ModelAndView();
		modelandView.addObject("customers", allCustomers);
		modelandView.setViewName("customer/list");
		
		return modelandView;
	}
	
	@GetMapping("/register")
	public ModelAndView registerNewCustomer(Model model) {
		ModelAndView modelandView = new ModelAndView();
		modelandView.addObject("newCustomer", new Customer());
		modelandView.setViewName("customer/registerform");
		
		return modelandView;
	}
	
	@PostMapping("/newcustomer")
	public ModelAndView newCustomer(@ModelAttribute Customer customer) {
		customerService.newCustomer(customer);
		ModelAndView modelandView = new ModelAndView();
		modelandView.setViewName("redirect:/api/allcustomers");
		return modelandView;
	
	}
	
	

}
