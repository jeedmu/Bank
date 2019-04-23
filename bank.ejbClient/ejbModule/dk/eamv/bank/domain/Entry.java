package dk.eamv.bank.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Entry {

	private final long entryID;
	private final String description;
	private final LocalDateTime date;
	private final BigDecimal amount;
	private final int accountNumber;
	private final int regNumber;
	private final boolean isHandled;

	public static class Builder {
		private long entryID;
		private LocalDateTime date;
		private BigDecimal amount;
		private int accountNumber;
		private int regNumber;
		private String description;
		private boolean isHandled;
		
		public Builder() {
		}
		
		public Builder setEntryID(long entryID) {
			this.entryID = entryID;
			return this;
		}
		
		public Builder setDate(LocalDateTime date) {
			this.date = date;
			return this;
		}
		
		public Builder setAmount(BigDecimal amount) {
			this.amount = amount;
			return this;
		}

		public Builder setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
			return this;
		}
		
		public Builder setRegNumber(int regNumber) {
			this.regNumber = regNumber;
			return this;
		}
		
		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}
		
		public Builder setIsHandled(boolean isHandled) {
			this.isHandled = isHandled;
			return this;
		}
		
		public Entry build() {
			return new Entry(this);
		}
	}

	public Entry(Builder builder) {
		entryID = builder.entryID;
		description = builder.description;
		date = builder.date;
		amount = builder.amount;
		accountNumber = builder.accountNumber;
		regNumber = builder.regNumber;
		isHandled = builder.isHandled;
	}

	public long getEntryID() {
		return entryID;
	}

	public Entry setEntryID(long entryID) {
		return new Entry.Builder()
				.setEntryID(entryID)
				.setDate(this.date)
				.setAmount(this.amount)
				.setAccountNumber(this.accountNumber)
				.setRegNumber(this.regNumber)
				.setDescription(this.description)
				.setIsHandled(this.isHandled)
				.build();
	}

	public String getDescription() {
		return description;
	}

	public Entry setDescription(String description) {
		return new Entry.Builder()
				.setEntryID(this.entryID)
				.setDate(this.date)
				.setAmount(this.amount)
				.setAccountNumber(this.accountNumber)
				.setRegNumber(this.regNumber)
				.setDescription(description)
				.setIsHandled(this.isHandled)
				.build();
	}

	public LocalDateTime getDate() {
		return date;
	}

	public Entry setDate(LocalDateTime date) {
		return new Entry.Builder()
				.setEntryID(this.entryID)
				.setDate(date)
				.setAmount(this.amount)
				.setAccountNumber(this.accountNumber)
				.setRegNumber(this.regNumber)
				.setDescription(this.description)
				.setIsHandled(this.isHandled)
				.build();
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Entry setAmount(BigDecimal amount) {
		return new Entry.Builder()
				.setEntryID(this.entryID)
				.setDate(this.date)
				.setAmount(amount)
				.setAccountNumber(this.accountNumber)
				.setRegNumber(this.regNumber)
				.setDescription(this.description)
				.setIsHandled(this.isHandled)
				.build();
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public Entry setAccountNumber(int accountNumber) {
		return new Entry.Builder()
				.setEntryID(this.entryID)
				.setDate(this.date)
				.setAmount(this.amount)
				.setAccountNumber(accountNumber)
				.setRegNumber(this.regNumber)
				.setDescription(this.description)
				.setIsHandled(this.isHandled)
				.build();
	}
	
	public int getRegNumber() {
		return regNumber;
	}
	public Entry setRegNumber(int regNumber) {
		return new Entry.Builder()
				.setEntryID(this.entryID)
				.setDate(this.date)
				.setAmount(this.amount)
				.setAccountNumber(this.accountNumber)
				.setRegNumber(regNumber)
				.setDescription(this.description)
				.setIsHandled(this.isHandled)
				.build();
	}
	
	public boolean isHandled() {
		return isHandled;
	}
	public Entry setIsHandled(boolean isHandled) {
		return new Entry.Builder()
				.setEntryID(this.entryID)
				.setDate(this.date)
				.setAmount(this.amount)
				.setAccountNumber(this.accountNumber)
				.setRegNumber(regNumber)
				.setDescription(this.description)
				.setIsHandled(isHandled)
				.build();
	}
}
