package dk.eamv.bank.ejb.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import dk.eamv.bank.domain.Entry;

@NamedQuery(name = "searchEntriesForAccount", query = "SELECT p FROM entry p "
		+ "WHERE p.accountNumber = :accountNumber " 
		+ "AND p.regNumber = :regNumber "
		+ "ORDER BY p.entryID")

@NamedQuery(name = "futureEntries", query = "SELECT p FROM entry p "
		+ "WHERE isHandled = false " 
		+ "And date <= current_date()")

@Entity(name ="entry") 
public class EntryEntity {
	@Id
	@GeneratedValue 
	private long entryID;    
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
	@NotNull
	private boolean isHandled;
	
	public EntryEntity(Entry entry) {
		this.entryID = entry.getEntryID();
		this.accountNumber = entry.getAccountNumber();
		this.description = entry.getDescription();
		this.date = entry.getDate();
		this.amount = entry.getAmount();
		this.regNumber = entry.getRegNumber();
		this.isHandled = entry.isHandled();
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
	
	public boolean getIsHandled()
	{
		return isHandled;
	}
	
	public void setIsHandled(boolean isHandled)
	{
		this.isHandled = isHandled;
	}
	
	public int getRegNumber() {
		return regNumber;
	}
	public void SetRegNumber(int regNumber) {
		this.regNumber = regNumber;
	}
	public Entry toDomain() {
		return new Entry.Builder().setEntryID(this.entryID)
				.setEntryID(this.entryID)
				.setDate(this.date)
				.setAmount(this.amount)
				.setAccountNumber(this.accountNumber)
				.setRegNumber(this.regNumber)
				.setDescription(this.description)
				.setIsHandled(this.isHandled)
				.build();
	}
}