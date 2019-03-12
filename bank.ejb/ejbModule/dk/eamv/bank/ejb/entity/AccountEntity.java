package dk.eamv.bank.ejb.entity;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import dk.eamv.bank.domain.Account;

@NamedQuery(name = "searchAccounts", query = "SELECT p FROM account p " 
											+ "WHERE p.customer.customerID = :customerID "
											+ "ORDER BY p.primaryKey.accountNumber")

@Entity(name="account")
public class AccountEntity 
{
	@EmbeddedId
	private AccountKey primaryKey;
	
	@NotNull
	private String accountName;

	@NotNull
	private BigDecimal balance;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customerID")
	private CustomerEntity customer;

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

//	@EmbeddedId
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
	public Account toDomain() {
		return new Account.Builder(this.customer.getCustomerID(), this.primaryKey.getRegNumber(), this.primaryKey.getAccountNumber()).setAccountName(this.accountName).setBalance(this.balance).Build();
	}
}
