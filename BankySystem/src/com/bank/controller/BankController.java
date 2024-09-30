package com.bank.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.bank.Test;
import com.bank.bean.Account;
import com.bank.service.IBankService;
import com.bank.service.impl.BankServiceImpl;


public class BankController {

	private Scanner sc=null;
	private IBankService bankService=null;
	public BankController() 
	{
		sc=new Scanner(System.in);
		bankService=new BankServiceImpl();

	}
	public void bankSystem(int i)
	{
		while(true)
		{
			System.out.println("---------------------------------");
			System.out.println("|    WEL_COME TO BANKY          |");
			System.out.println("|                               |");
			System.out.println("| 1. Create   Account             |");
			System.out.println("| 2. Deposit  Amount             |");
			System.out.println("| 3. Withdraw Amount            |"); 
			System.out.println("| 4. Transfer Amount                 |");
			System.out.println("| 5. Go Back                    |");
			System.out.println("| 6. Logout                     |");
			System.out.println("---------------------------------");
			System.out.println("Please Enter Your Choice: ");
			int value=0;
			try 
			{
				if(i!=0)
					sc.nextLine();
				value=sc.nextInt();
			}
			catch (Exception e) {
				System.err.println("It Should Be in Numbers");
				bankSystem(1);
				return;
			}
			if(value==9)
			{
				break;
			}
			switch (value) {
			case 1:
				createAccount();
				break;
			case 2:
				sc.nextLine();
				System.out.println("Enter Holder Number ");
				String number=sc.nextLine();
				System.out.println("Enter The Amount ");
				Double amount=sc.nextDouble();
				if(bankService.depositAmount(amount, number))
					System.out.println("Successfully Deposited");
				else
					System.err.println("Failed to Deposit");
				break;
			case 3:
				sc.nextLine();
				System.out.println("Enter Holder Number ");
				String number1=sc.nextLine();
				System.out.println("Enter The Amount ");
				Double amount1=sc.nextDouble();
				if(bankService.withdrawAmount(amount1, number1))
				     System.out.println("Successfully Withdrawal");
				else
					System.err.println("Failed To Withdraw");
				break;
			case 4:
				sc.nextLine();
				System.out.println("Enter Holder Number ");
				String number2=sc.nextLine();
				System.out.println("Enter The Amount ");
				Double amount2=sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter Receiver Holder Number ");
				String receiverNumber=sc.nextLine();
				if(bankService.transferAmount(amount2, number2,receiverNumber))
			    System.out.println("Transfer successful");
							else
								System.err.println("Failed To Transfer Amount");
							break;
			case 5:
				Test.main(null);
				break;
			case 6:
				System.err.println("You have Loged out");
				System.exit(0);
				break;
			default:
				System.err.println("Choice Should Be From given Choice");
				break;
			}		
		}
	}

// Adding the book 
	public Integer createAccount()
	{
		sc.nextLine();
		System.out.println(" Holder Name ");
		String name=sc.nextLine();
		
		System.out.println("Holder Number ");
		String number=sc.nextLine();
		checkIsExistsAccount(number);
		
		System.out.println("The AccountType ");
		String type=sc.nextLine();
		
		/*
		  System.out.println("Account Balance "); 
		  Double amount=sc.nextDouble();
		 */
		
		System.out.println("The Contact Number ");
		String phoneNumber=sc.nextLine();
		
		System.out.println("The Contact Email ");
		String email=sc.nextLine();

		System.out.println("The Contact Address ");
		String address=sc.nextLine();
		
		List<Account> bankInfo=Arrays.asList(
				new Account(null,name,number,type,0.00,phoneNumber,email,address));
		return bankService.saveAccount(bankInfo);
		}
	
	// checking that book already present or not if present then you have to return because name is unique
	public String checkIsExistsAccount(String number)
	{
		if( number.matches("\\d{10}"))
		{
			if(!(bankService.isbankAccountExists(number)))
			{
				return number;
			}
			else
			{
				System.err.println("Re-Enter Account Number" +"\n"+ "(Because With the Same Account Already Exist )");
				String number1=sc.nextLine();
				return checkIsExistsAccount(number1);
			}
		}
		else
		{
			System.err.println("Re-Enter Account Number" +"\n"+ "(Because Account should contain 10 Digits Only )");
			String number1=sc.nextLine();
			return checkIsExistsAccount(number1);	
		}
	}
}
