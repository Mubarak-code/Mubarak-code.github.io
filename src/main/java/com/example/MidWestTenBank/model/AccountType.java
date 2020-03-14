package com.example.MidWestTenBank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class AccountType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountTypeId;
	private String accountTypeName;

	public Integer getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(Integer accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public String getAccountTypeName() {
		return accountTypeName;
	}
	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}
	
}
