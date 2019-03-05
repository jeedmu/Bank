package dk.eamv.bank.ejb.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import dk.eamv.bank.domain.Entry;

public class EntryEntity {
	
	public EntryEntity(Entry entry) {
		this.entryID = getEntryID();
		this.description = getDescription();
		this.date = getDate();
		this.amount = getAmount();
	}
		
	private int entryID;
	private String description;
	private LocalDateTime date;
	private BigDecimal amount;
	private int accountNumber;
	
	public int getEntryID() {
		return entryID;
	}
	public void setEntryID(int entryID) {
		this.entryID = entryID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Entry toDomain() {
		return new Entry.Builder(this.entryID, this.date, this.amount, this.accountNumber).Build();
	}
}
