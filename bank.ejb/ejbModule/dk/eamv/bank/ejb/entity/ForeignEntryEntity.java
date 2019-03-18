package dk.eamv.bank.ejb.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import dk.eamv.bank.domain.Entry;


@Entity(name ="foreignEntry") 

@NamedQuery(name = "allForeignEntries", query = "SELECT p FROM foreignEntry p  "
		+ "ORDER BY p.entryID")


public class ForeignEntryEntity implements Serializable{

	private static final long serialVersionUID = 1L;
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
	
	public ForeignEntryEntity(Entry entry) {
		this.entryID = entry.getEntryID();
		this.description = entry.getDescription();
		this.date = entry.getDate();
		this.amount = entry.getAmount();
		this.regNumber = entry.getRegNumber();
	}
	
	public ForeignEntryEntity() {}
		
	
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
	
	public int getRegNumber() {
		return regNumber;
	}
	public void SetRegNumber(int regNumber) {
		this.regNumber = regNumber;
	}
	public Entry toDomain() {
		return new Entry.Builder().setEntryID(this.entryID).setDescription(this.description).setDate(this.date).setAmount(this.amount).setAccountNumber(this.accountNumber).setRegNumber(this.regNumber).build();
	}
}
