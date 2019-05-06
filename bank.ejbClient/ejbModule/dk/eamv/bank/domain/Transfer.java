package dk.eamv.bank.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transfer {
	
	private BigDecimal amount;
	private Account fromAccount;
	private int toAccountAccountNumber;
	private String fromDescription;
	private String toDescription;
	private int regNumber;
	private Customer currentCustomer;
	private LocalDateTime date;
	

	public BigDecimal getAmount() {
		return amount;
	}

	public Account getFromAccount() {
		return fromAccount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}

	public void setToAccountAccountNumber(int toAccountAccountNumber) {
		this.toAccountAccountNumber = toAccountAccountNumber;
	}

	public void setFromDescription(String fromDescription) {
		this.fromDescription = fromDescription;
	}

	public void setToDescription(String toDescription) {
		this.toDescription = toDescription;
	}

	public void setRegNumber(int regNumber) {
		this.regNumber = regNumber;
	}

	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getFromDescription() {
		return fromDescription;
	}
	public String getToDescription() {
		return toDescription;
	}

	public int getRegNumber() {
		return regNumber;
	}
	public Customer getCurrentCustomer() {
		return currentCustomer;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public int getToAccountAccountNumber() {
		return toAccountAccountNumber;
	}
	
}
