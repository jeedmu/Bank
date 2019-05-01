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
