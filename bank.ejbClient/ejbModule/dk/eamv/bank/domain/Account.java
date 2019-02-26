package dk.eamv.bank.domain;

import java.math.BigDecimal;

public class Account {
	private final int customerID;
	private final String regNumber;
	private final String accountNumber;
	private final String accountName;
	private final BigDecimal balance;

	public static class Builder {
		private int customerID;
		private String regNumber;
		private String accountNumber;
		private String accountName;
		private BigDecimal balance;

		public Builder(String accountNumber) {
			this.accountName = accountNumber;
		}
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		customerID = customerID;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		regNumber = regNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		accountName = accountName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		balance = balance;
	}
}
