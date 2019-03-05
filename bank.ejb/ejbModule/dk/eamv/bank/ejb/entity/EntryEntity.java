package dk.eamv.bank.ejb.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import dk.eamv.bank.domain.Entry;

@Entity(name ="entry") 
public class EntryEntity {
	@Id
	@GeneratedValue 
	private long entryID;    // der skal laves annotationos
	@NotNull
	private String description;
	@NotNull
	private LocalDateTime date;
	@NotNull
	private BigDecimal amount;
	@NotNull
	private int accountNumber;
	@NotNull
	private int regNumber;
	
	public EntryEntity(Entry entry) {
		this.entryID = entry.getEntryID();
		this.description = getDescription();
		this.date = getDate();
		this.amount = getAmount();
	}
	
	public EntryEntity() {
		
	}
		
	
	public long getEntryID() {
		return entryID;
	}
	public void setEntryID(long entryID) {
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
