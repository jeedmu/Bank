package dk.eamv.bank.domain;

import java.math.BigDecimal;

public class Account {
	private final int customerID;
	private final String regNumber;
	private final String accountNumber;
	private final String accountName;
	private final BigDecimal balance;

	public static class Builder {
		private final int customerID;
		private final String regNumber;
		private final String accountNumber;
		private String accountName;
		private BigDecimal balance;

		public Builder(int customerID, String regNumber, String accountNumber) {
			this.customerID = customerID;
			this.regNumber = regNumber;
			this.accountNumber = accountNumber;
		}
		
		public Builder setAccountName(String accountName) {
			this.accountName = accountName;
			return this;
		}
		
		public Builder setBalance(BigDecimal balance) {
			this.balance = balance;
			return this;
		}
		
		public Account Build() {
			return new Account(this);
		}
	}

	private Account(Builder builder) {
		customerID = builder.customerID;
		regNumber = builder.regNumber;
		accountNumber = builder.accountNumber;
		accountName = builder.accountName;
		balance = builder.balance;
	}

	public int getCustomerID() {
		return customerID;
	}

	public Account setCustomerID(int customerID) {
		return new Account.Builder(customerID, this.regNumber, this.accountNumber)
						  .setAccountName(this.accountName)
						  .setBalance(this.balance)
						  .Build();
	}

	public String getRegNumber() {
		return regNumber;
	}

	public Account setRegNumber(String regNumber) {
		return new Account.Builder(this.customerID, regNumber, this.accountNumber)
				  .setAccountName(this.accountName)
				  .setBalance(this.balance)
				  .Build();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public Account setAccountNumber(String accountNumber) {
		return new Account.Builder(this.customerID, this.regNumber, accountNumber)
				  .setAccountName(this.accountName)
				  .setBalance(this.balance)
				  .Build();
	}

	public String getAccountName() {
		return accountName;
	}

	public Account setAccountName(String accountName) {
		return new Account.Builder(this.customerID, this.regNumber, this.accountNumber)
				  .setAccountName(accountName)
				  .setBalance(this.balance)
				  .Build();
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public Account setBalance(BigDecimal balance) {
		return new Account.Builder(this.customerID, this.regNumber, this.accountNumber)
				  .setAccountName(this.accountName)
				  .setBalance(balance)
				  .Build();
	}
}
