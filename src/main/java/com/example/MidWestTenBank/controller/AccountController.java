package com.example.MidWestTenBank.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.MidWestTenBank.model.Account;

import com.example.MidWestTenBank.service.AccountService;



@RestController
@RequestMapping("/api/")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	

	
	@GetMapping("/allaccount")
	public ResponseEntity<?> getAllAccounts(){
		
		List<Account> allAccounts = accountService.allAccounts();
		 
		return new ResponseEntity<List<Account>>(allAccounts, HttpStatus.OK);
					
	}
	
	@PostMapping("/createaccount")
	public ResponseEntity<?> createAccount(@RequestBody Account account) {
		if (account != null) {
			accountService.newAccount(account);
			return new ResponseEntity<String>("New accont created", HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getaccount/{accountnumber}")
	public ResponseEntity<?> getAccount(@PathVariable ("accountnumber") Long accountNumber){
		
		Account account = accountService.getAccount(accountNumber);
		
		if (account != null) {
			
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		}else
			return new ResponseEntity<String>("Account number not inserted", HttpStatus.BAD_REQUEST);
		
	}
	
	
	
}
