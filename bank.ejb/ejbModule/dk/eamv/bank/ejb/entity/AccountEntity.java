package dk.eamv.bank.ejb.entity;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import dk.eamv.bank.domain.Account;

@NamedQuery(name = "allAccounts", query = "SELECT p FROM account p  "
		+ "ORDER BY p.accountNumber")

@Entity(name="account")
public class AccountEntity 
{
	@NotNull
	private String accountName;

	@NotNull
	private BigDecimal balance;
	
	@NotNull
	private int accountNumber;
	
	@NotNull
	private int regNumber;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customerID")
	private CustomerEntity customer;

	AccountKey primaryKey;
	public AccountEntity()
	{
	}
	
	public AccountEntity(Account account) 
	{
		//this.customerID = account.getCustomerID();
		this.accountName = account.getAccountName();
		this.balance = account.getBalance();
	}

	
	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	@EmbeddedId
    public AccountKey getPrimaryKey() {
        return primaryKey;
    }
 
    public void setPrimaryKey(AccountKey pk) {
        primaryKey = pk;
    }

	
	//set/getters

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
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(int regNumber) {
		this.regNumber = regNumber;
	}
	public Account toDomain() {
		return new Account.Builder(this.customer.getCustomerID(), this.regNumber, this.accountNumber).setAccountName(this.accountName).setBalance(this.balance).Build();
	}
}
