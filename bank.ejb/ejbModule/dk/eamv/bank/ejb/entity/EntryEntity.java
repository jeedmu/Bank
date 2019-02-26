package dk.eamv.bank.ejb.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import dk.eamv.bank.domain.Entry;

public class EntryEntity {
	
	public EntryEntity(Entry entry) {
		this.EntryID = getEntryID();
		this.Description = getDescription();
		this.Date = getDate();
		this.Amount = getAmount();
	}
	
	
	
	private int EntryID;
	private String Description;
	private LocalDateTime Date;
	private BigDecimal Amount;
	
	public int getEntryID() {
		return EntryID;
	}
	public void setEntryID(int entryID) {
		EntryID = entryID;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public LocalDateTime getDate() {
		return Date;
	}
	public void setDate(LocalDateTime date) {
		Date = date;
	}
	public BigDecimal getAmount() {
		return Amount;
	}
	public void setAmount(BigDecimal amount) {
		Amount = amount;
	}
}
