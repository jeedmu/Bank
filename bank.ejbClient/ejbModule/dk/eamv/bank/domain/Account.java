package dk.eamv.bank.domain;

import java.math.BigDecimal;

public class Account {
	private int customerID;
	private String regNumber;
	private  String accountNumber;
	private String accountName;
	private BigDecimal balance;

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
		this.customerID = customerID;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
