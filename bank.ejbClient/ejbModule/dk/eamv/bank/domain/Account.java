package dk.eamv.bank.domain;

import java.math.BigDecimal;

public class Account {
	private final int customerID;
	private final int regNumber;
	private final int accountNumber;
	private final String accountName;
	private final BigDecimal balance;

	public static class Builder {
		private final int customerID;
		private final int regNumber;
		private final int accountNumber;
		private String accountName;
		private BigDecimal balance;

		public Builder(int customerID, int regNumber, int accountNumber) {
			this.customerID = customerID;
			this.regNumber = regNumber;
			this.accountNumber = accountNumber;
			balance = BigDecimal.ZERO;
		}
		
		public Builder setAccountName(String accountName) {
			this.accountName = accountName;
			return this;
		}
		
		public Builder setBalance(BigDecimal balance) {
			this.balance = balance;
			return this;
		}
		
		public Account build() {
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
						  .build();
	}

	public int getRegNumber() {
		return regNumber;
	}

	public Account setRegNumber(int regNumber) {
		return new Account.Builder(this.customerID, regNumber, this.accountNumber)
				  .setAccountName(this.accountName)
				  .setBalance(this.balance)
				  .build();
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public Account setAccountNumber(int accountNumber) {
		return new Account.Builder(this.customerID, this.regNumber, accountNumber)
				  .setAccountName(this.accountName)
				  .setBalance(this.balance)
				  .build();
	}

	public String getAccountName() {
		return accountName;
	}

	public Account setAccountName(String accountName) {
		return new Account.Builder(this.customerID, this.regNumber, this.accountNumber)
				  .setAccountName(accountName)
				  .setBalance(this.balance)
				  .build();
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public Account setBalance(BigDecimal balance) {
		return new Account.Builder(this.customerID, this.regNumber, this.accountNumber)
				  .setAccountName(this.accountName)
				  .setBalance(balance)
				  .build();
	}
}
