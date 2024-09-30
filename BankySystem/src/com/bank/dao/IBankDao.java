package com.bank.dao;

import java.util.List;

import com.bank.bean.Account;

public interface IBankDao 
{
	public Integer saveAccount(List<Account> ac);
	public Boolean transferAmount(Double amount,String accountNumber,String transferAccount_No);
	public Boolean withdrawAmount(Double amount,String accountNumber);
	public Boolean depositAmount(Double amount,String accountNumber);
	public Boolean isbankAccountExists(String accountNumber);
    public Double findingBalanceOf(String accountNumber);
}
