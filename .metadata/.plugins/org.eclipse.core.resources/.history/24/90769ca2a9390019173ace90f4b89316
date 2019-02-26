package dk.eamv.bank.ejb.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
@Entity
public class Account {
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CustomerID") 		// joiner account klasse til Customer tabellen via joincolumn
	private int CustomerID;
	
	@NotNull
	private String RegNumber;

	@Id
	@GeneratedValue
	private String AccountNumber;
	
	@NotNull
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
