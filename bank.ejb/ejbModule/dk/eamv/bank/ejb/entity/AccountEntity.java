package dk.eamv.bank.ejb.entity;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import dk.eamv.bank.domain.Account;

@Entity
@Table(name="account")
public class AccountEntity 
{
	AccountKey primaryKey;
	public AccountEntity()
	{
		
	}
	
	public AccountEntity(Account account) 
	{
		//this.customerID = account.getCustomerID();
		this.accountName = getAccountName();
		this.balance = getBalance();
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customerID")
	private CustomerEntity customer;

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

	@NotNull
	private String accountName;

	@NotNull
	private BigDecimal balance;
	
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
}
