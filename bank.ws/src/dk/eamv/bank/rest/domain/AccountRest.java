package dk.eamv.bank.rest.domain;

import java.math.BigDecimal;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Account.Builder;

public class AccountRest {
	private int customerID;
	private int regNumber;
	private int accountNumber;
	private String accountName;
	private BigDecimal balance;
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(int regNumber) {
		this.regNumber = regNumber;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
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
	
	public Account toDomain() {
		Account.Builder builder = new Builder(customerID, regNumber, accountNumber)
									.setAccountName(accountName).setBalance(balance);
		return builder.build();
	}
}
