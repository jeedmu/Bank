package dk.eamv.bank.ejb.entity;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import dk.eamv.bank.domain.Account;
public class AccountEntity {

	public AccountEntity(Account account ) {
		this.CustomerID = account.getCustomerID();
		this.RegNumber = account.getRegNumber();
		this.AccountNumber = account.getAccountNumber();
		this.AccountName = getAccountName();
		this.Balance = getBalance();
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CustomerID")
	private CustomerEntity customer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RegNumber")
	private int RegNumber;
	@Id
	@GeneratedValue
	private int AccountNumber;
	@NotNull
	private String AccountName;
	@NotNull
	private BigDecimal Balance;
	
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public int getRegNumber() {
		return RegNumber;
	}
	public void setRegNumber(int regNumber) {
		RegNumber = regNumber;
	}
	public int getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(int accountNumber) {
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
