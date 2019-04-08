package dk.eamv.bank.ejb.entity;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import dk.eamv.bank.domain.Account;

@NamedQuery(name = "searchAccounts", query = "SELECT p FROM account p " 
											+ "WHERE p.customer.customerID = :customerID "
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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customerID")
	private CustomerEntity customer;

	public AccountEntity()
	{
		this.balance = BigDecimal.ZERO;
	}
	
	public AccountEntity(Account account) 
	{
		this.accountName = account.getAccountName();
		this.balance = account.getBalance();
	}

	
	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
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
	public Account toDomain() {
		return new Account.Builder(this.customer.getCustomerID(), this.regNumber, (int)this.accountNumber).setAccountName(this.accountName).setBalance(this.balance).build();
	}
}
