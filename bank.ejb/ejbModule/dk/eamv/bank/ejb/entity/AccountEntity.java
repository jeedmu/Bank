package dk.eamv.bank.ejb.entity;

import java.math.BigDecimal;
import dk.eamv.bank.domain.Account;
public class AccountEntity {

	public AccountEntity(Account account ) {
		this.CustomerID = account.getCustomerID();
		this.RegNumber = account.getRegNumber();
		this.AccountNumber = account.getAccountNumber();
		this.AccountName = getAccountName();
		this.Balance = getBalance();
	}
	
	private int CustomerID;
	private String RegNumber;
	private String AccountNumber;
	private String AccountName;
	private BigDecimal Balance;
	
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getRegNumber() {
		return RegNumber;
	}
	public void setRegNumber(String regNumber) {
		RegNumber = regNumber;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public BigDecimal getBalance() {
		return Balance;
	}
	public void setBalance(BigDecimal balance) {
		Balance = balance;
	}
	
	
}
