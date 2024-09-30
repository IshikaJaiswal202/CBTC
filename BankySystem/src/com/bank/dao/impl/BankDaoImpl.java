package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.bank.bean.Account;
import com.bank.dao.IBankDao;
import com.bank.util.DbConnection;

public class BankDaoImpl implements IBankDao
{
	private PreparedStatement pstm;
	private ResultSet rs;
	private String  DB_QUERY;
	private Connection con;
	public BankDaoImpl() {
		con=DbConnection.getConnection();
	}


	@Override
	public Integer saveAccount(List<Account> ac) {
		DB_QUERY="Insert into Bank_Account values(?,?,?,?,?,?,?,?)";
		int count[] = null;
		try 
		{
			pstm=con.prepareStatement(DB_QUERY);
			for(Account a:ac)
			{
				pstm.setString(1, UUID.randomUUID().toString());
				pstm.setString(2, a.getAccountHolder());
				pstm.setString(3, a.getAccountNumber());
				pstm.setString(4, a.getAccountType());
				pstm.setDouble(5, a.getBalance());
				pstm.setString(6, a.getContactNumber());
				pstm.setString(7, a.getEmail());
				pstm.setString(8, a.getAddress());
				pstm.addBatch();
			}
			count=pstm.executeBatch();
			if(count!=null)
			{
				return 1;
			}

		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean transferAmount(Double amount, String accountNumber ,String transferAccount_No) {
		Double balance = 0.00 ;
		DB_QUERY="update Bank_Account set account_balance=? where account_HolderNumber=?";
		if( isbankAccountExists(accountNumber)&& isbankAccountExists(transferAccount_No))
		{
			//check the account exists or not and amount is sufficient or not
			balance =findingBalanceOf(accountNumber);
			if(amount>balance)
			{
				System.err.println("Insufficient fund");
				return false;
			}
		}
		else
		{
			//Update sender's balance
			try 
			{
				pstm=con.prepareStatement(DB_QUERY);
				pstm.setDouble(1, balance-amount);
				pstm.setString(2, accountNumber);
				return pstm.executeUpdate()>0;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			//Update receiver's balance
			try 
			{
				pstm=con.prepareStatement(DB_QUERY);
				pstm.setDouble(1, balance+amount);
				pstm.setString(2, transferAccount_No);
				return pstm.executeUpdate()>0;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return true;
	
	}

	@Override
	public Boolean depositAmount(Double amount, String accountNumber) {
		Double balance;
		DB_QUERY="update Bank_Account set account_balance=? where account_HolderNumber=?";
		if( isbankAccountExists(accountNumber))
		{
			balance =findingBalanceOf(accountNumber);
			try {
				pstm=con.prepareStatement(DB_QUERY);
				pstm.setDouble(1, balance+amount);
				pstm.setString(2, accountNumber);
				return pstm.executeUpdate()>0;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Boolean withdrawAmount(Double amount, String accountNumber) {
		Double balance = 0.00 ;
		DB_QUERY="update Bank_Account set account_balance=? where account_HolderNumber=?";
		if( isbankAccountExists(accountNumber))
		{
			balance =findingBalanceOf(accountNumber);
			if(amount>balance)
			{
				System.err.println("Insufficient fund");
				return false;
			}
		}
		else
		{
			try 
			{
				pstm=con.prepareStatement(DB_QUERY);
				pstm.setDouble(1, balance-amount);
				pstm.setString(2, accountNumber);
				return pstm.executeUpdate()>0;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public Boolean isbankAccountExists(String accountNumber) {

		DB_QUERY="Select * from Bank_Account where account_HolderNumber=?";
		try {
			pstm=con.prepareStatement(DB_QUERY);
			pstm.setString(1, accountNumber);
			rs=pstm.executeQuery();
			if(rs.next())
			{
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public Double findingBalanceOf(String accountNumber) {
		DB_QUERY="Select account_Balance from Bank_Account where account_HolderNumber=?";
		double balance = 0;
		try {
			pstm=con.prepareStatement(DB_QUERY);
			pstm.setString(1, accountNumber);
			rs=pstm.executeQuery();
			if(rs.next())
			{
				balance=rs.getDouble("account_HolderNumber");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return balance ;
	}

}
