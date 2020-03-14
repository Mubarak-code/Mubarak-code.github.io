package com.example.MidWestTenBank.service;

import java.util.List;

import com.example.MidWestTenBank.model.Account;

public interface AccountService {
	
	List<Account> allAccounts();
	void newAccount(Account account);
	Double netLiquidity();
	Account getAccount(Long id);
	

}
