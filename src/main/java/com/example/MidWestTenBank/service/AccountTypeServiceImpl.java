package com.example.MidWestTenBank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MidWestTenBank.model.AccountType;
import com.example.MidWestTenBank.repository.AccountTypeRepository;

@Service
public class AccountTypeServiceImpl implements AccountTypeService {
	@Autowired
	private AccountTypeRepository accountTypeRepo;

	@Override
	public void newAccountType(AccountType accountType) {
		accountTypeRepo.save(accountType);
		
	}

	@Override
	public AccountType getAccountType(Integer id) {
		
		AccountType accountType = accountTypeRepo.findById(id).get();
		
		return accountType;
	}
	public List<AccountType> accountTypes(){
		return accountTypeRepo.findAll();
	}

}
