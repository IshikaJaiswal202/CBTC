package com.bank.bean;

public class Account 
{

	    private String holderId;       
	    private String accountNumber;       
	    private String accountHolder;       
	    private String accountType;          
	    private double balance;              
	    private String contactNumber;       
	    private String email;         
	    private String address;             
	    
	    
		public Account() {
			super();
		}

		public Account(String holderId, String accountNumber, String accountHolder, String accountType, double balance,
				String contactNumber, String email, String address) {
			super();
			this.holderId = holderId;
			this.accountNumber = accountNumber;
			this.accountHolder = accountHolder;
			this.accountType = accountType;
			this.balance = balance;
			this.contactNumber = contactNumber;
			this.email = email;
			this.address = address;
		}
		
		public String getHolderId() {
			return holderId;
		}

		public void setHolderId(String holderId) {
			this.holderId = holderId;
		}

		public String getAccountNumber() {
			return accountNumber;
		}


		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}


		public String getAccountHolder() {
			return accountHolder;
		}


		public void setAccountHolder(String accountHolder) {
			this.accountHolder = accountHolder;
		}


		public String getAccountType() {
			return accountType;
		}


		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}


		public double getBalance() {
			return balance;
		}


		public void setBalance(double balance) {
			this.balance = balance;
		}


		public String getContactNumber() {
			return contactNumber;
		}


		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}

		@Override
		public String toString() {
			return "Account [holderId=" + holderId + ", accountNumber=" + accountNumber + ", accountHolder="
					+ accountHolder + ", accountType=" + accountType + ", balance=" + balance + ", contactNumber="
					+ contactNumber + ", email=" + email + ", address=" + address + "]";
		}

        

		
	    
}
