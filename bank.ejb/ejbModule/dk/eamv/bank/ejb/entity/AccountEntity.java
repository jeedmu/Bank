package dk.eamv.bank.ejb.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import dk.eamv.bank.domain.Account;

@NamedQuery(name = "searchAccounts", query = "SELECT p FROM account p " 
											+ "WHERE p.customerID = :customerID "
											+ "ORDER BY p.accountNumber")

@Entity(name="account")
public class AccountEntity
{
	@NotNull
    private int regNumber;
    
	@GeneratedValue
	@Id
    private int accountNumber;
	
	@NotNull
	private String accountName;

	@NotNull
	private BigDecimal balance;
	
	private int customerID;

	public AccountEntity()
	{
		this.balance = BigDecimal.ZERO;
	}
	
	public AccountEntity(Account account) 
	{
		this.customerID = account.getCustomerID();
		this.accountNumber = account.getAccountNumber();
		this.accountName = account.getAccountName();
		this.balance = account.getBalance();
		this.regNumber = account.getRegNumber();
	}
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomer(int customerID) {
		this.customerID = customerID;
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
	
	public int getAccountNumber()
	{
		return accountNumber;
	}
	
	public Account toDomain() {
		return new Account.Builder(customerID, this.regNumber, (int)this.accountNumber).setAccountName(this.accountName).setBalance(this.balance).build();
	}
}