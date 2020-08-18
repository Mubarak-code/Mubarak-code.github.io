package com.example.MidWestTenBank.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MidWestTenBank.model.Account;
import com.example.MidWestTenBank.model.Customer;
import com.example.MidWestTenBank.repository.AccountRepository;


@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepo;
	

	@Override
	public List<Account> allAccounts() {
		
		List<Account> all = accountRepo.findAll() ;
		
		all.sort(Comparator.comparing(Account :: getAccountNumber));
		
		return all;
		
	}

	@Override
	public void newAccount(Account account) {
		
		accountRepo.save(account);
		
	}

	@Override
	public Double netLiquidity() {
		
		List <Account> accounts = accountRepo.findAll();
		
		Double total = 0.00;
		Double loanTotal = 0.00;
		
		for(Account account : accounts) {
			
			
			if(account.getAccountType().getAccountTypeName().equalsIgnoreCase("Loan")) {
				
				loanTotal += account.getBalance();
				
			}else
			
			total +=  account.getBalance();
			
		}
		
		total = total - loanTotal;
		return total;
	}

	@Override
	public Account getAccount(Long accountNumber) {
		Account account = accountRepo.findByAccountNumber(accountNumber);
		
		return account;
	}

}
