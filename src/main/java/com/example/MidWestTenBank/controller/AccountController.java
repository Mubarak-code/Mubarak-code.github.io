package com.example.MidWestTenBank.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.MidWestTenBank.model.Account;
import com.example.MidWestTenBank.model.AccountType;
import com.example.MidWestTenBank.model.Customer;
import com.example.MidWestTenBank.service.AccountService;
import com.example.MidWestTenBank.service.AccountTypeService;
import com.example.MidWestTenBank.service.CustomerService;


@Controller
@RequestMapping("/api/")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AccountTypeService accounttypeService;
	
	
	@GetMapping("/allaccount")
	public ModelAndView getAllAccounts(){
		
		List<Account> allAccounts = accountService.allAccounts();
		Double netLiquid = accountService.netLiquidity();
		ModelAndView modelandView = new ModelAndView();
		modelandView.addObject("accounts", allAccounts );
		modelandView.addObject("net", netLiquid );
		modelandView.setViewName("account/accountlist");
				
		return modelandView ;
	}
	
	@GetMapping("/createaccount")
	public ModelAndView createAccount(Model model) {
		List<AccountType> accountTypes = accounttypeService.accountTypes();
		List<Customer> customers = customerService.allCustomers();
		ModelAndView modelandView = new ModelAndView();
		modelandView.addObject("newAccount", new Account());
		modelandView.addObject("acctTypes", accountTypes);
		modelandView.addObject("customers", customers);
		modelandView.setViewName("account/registerform");
		
		return modelandView;
	}
	
	@PostMapping("/newaccount")
	public ModelAndView newAccount(@ModelAttribute Account account) {
		
		 accountService.newAccount(account);
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("redirect:/api/allaccount");
		 
		 return modelAndView;
		 
	}

	
	
}
