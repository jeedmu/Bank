package dk.eamv.bank.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Entry {
	
	private int entryID;
	private String description;
	private LocalDateTime date;
	private BigDecimal amount;
	
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
}
