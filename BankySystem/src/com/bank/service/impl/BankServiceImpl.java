package com.bank.service.impl;

import java.util.List;

import com.bank.bean.Account;
import com.bank.dao.IBankDao;
import com.bank.dao.impl.BankDaoImpl;
import com.bank.service.IBankService;

public class BankServiceImpl implements IBankService
{
	private IBankDao bankDao;

	public BankServiceImpl() {
		bankDao=new BankDaoImpl();
	}
	@Override
	public Integer saveAccount(List<Account> ac) {
		return bankDao.saveAccount(ac);
	}

	@Override
	public Boolean transferAmount(Double amount, String accountNumber,String transferAccount_No) {
		return bankDao.transferAmount(amount, accountNumber, transferAccount_No);
	}

	@Override
	public Boolean withdrawAmount(Double amount, String accountNumber) {
		return bankDao.withdrawAmount(amount, accountNumber);
	}

	@Override
	public Boolean depositAmount(Double amount, String accountNumber) {
		return bankDao.depositAmount(amount, accountNumber);
	}
	@Override
	public Boolean isbankAccountExists(String accountNumber) {
		return bankDao.isbankAccountExists(accountNumber);
	}

	

}
