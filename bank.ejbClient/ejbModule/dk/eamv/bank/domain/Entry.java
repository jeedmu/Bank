package dk.eamv.bank.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class Entry {
	
	private final long entryID;
	private final String description;
	private final LocalDateTime date;
	private final BigDecimal amount;
	private final String accountNumber;
	
	public static class Builder{
		private final int entryID;
		private String description;
		private final LocalDateTime date;
		private final BigDecimal amount;
		private final String accountNumber;
		
		public Builder(int entryID, LocalDateTime date, BigDecimal amount, String accountNumber) {
			this.entryID = entryID;
			this.date = date;
			this.amount = amount;
			this.accountNumber = accountNumber;
		}
		
		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}
		
		public Entry Build() {
			return new Entry(this);
		}
	}
	
	public Entry(Builder builder) {
		entryID = builder.entryID;
		description = builder.description;
		date = builder.date;
		amount = builder.amount;
		accountNumber = builder.accountNumber;
	}
	public int getEntryID() {
		return entryID;
	}
	public Entry setEntryID(int entryID) {
		return new Entry.Builder(entryID, this.date, this.amount, this.accountNumber)
				  .setDescription(this.description)
				  .Build();
	}
	public String getDescription() {
		return description;
	}
	public Entry setDescription(String description) {
		return new Entry.Builder(this.entryID, this.date, this.amount, this.accountNumber)
				  .setDescription(description)
				  .Build();
	}
	public LocalDateTime getDate() {
		return date;
	}
	public Entry setDate(LocalDateTime date) {
		return new Entry.Builder(this.entryID, date, this.amount, this.accountNumber)
				  .setDescription(this.description)
				  .Build();
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public Entry setAmount(BigDecimal amount) {
		return new Entry.Builder(this.entryID, this.date, amount, this.accountNumber)
				  .setDescription(this.description)
				  .Build();
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public Entry setAccountNumber(String accountNumber) {
		return new Entry.Builder(this.entryID, this.date, this.amount, accountNumber)
				  .setDescription(this.description)
				  .Build();
	}
}
