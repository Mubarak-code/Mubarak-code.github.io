package com.example.MidWestTenBank.service;

import java.util.List;

import com.example.MidWestTenBank.model.AccountType;

public interface AccountTypeService {
	
	void newAccountType(AccountType accountType);
	AccountType getAccountType(Integer id);
	List<AccountType> accountTypes();
	
	

}
