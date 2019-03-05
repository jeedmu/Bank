package dk.eamv.bank.domain;

public class Bank {

	private final String cvr;
	private final String bankName;
	private final int regNumber;
	private final String phoneNumber;
	private final int accountNumber;
	
	
	public static class Builder {
		//Required params
		private final String cvr;
		private final String bankName;
		private final int regNumber;
		private final int accountNumber;
		
		//Optional params
		private String phoneNumber;
		
		public Builder(String cvr, String bankName, int regNumber, int accountNumber) {
			this.cvr = cvr;
			this.bankName = bankName;
			this.regNumber = regNumber;
			this.accountNumber = accountNumber;
		}
		
		public Builder setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		
		public Bank Build() {
			return new Bank(this);
		}
	}

	private Bank(Builder builder) {
		cvr = builder.cvr;
		bankName = builder.bankName;
		regNumber = builder.regNumber;
		phoneNumber = builder.phoneNumber;
		accountNumber = builder.accountNumber;
	}
	
	public String getCVR() {
		return cvr;
	}
	
	public Bank setCVR(String cvr) {
		return new Bank.Builder(cvr, this.bankName, this.regNumber, this.accountNumber).setPhoneNumber(this.phoneNumber).Build();
	}

	public String getBankName() {
		return bankName;
	}

	public Bank setBankName(String bankName) {
		return new Bank.Builder(this.cvr, bankName, this.regNumber, this.accountNumber).setPhoneNumber(this.phoneNumber).Build();
	}
	
	public int getRegNumber() {
		return regNumber;
	}

	public Bank setRegName(int regNumber) {
		return new Bank.Builder(this.cvr, this.bankName, regNumber, this.accountNumber).setPhoneNumber(this.phoneNumber).Build();
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public Bank setAccountNumber(int accountNumber) {
		return new Bank.Builder(this.cvr, this.bankName, this.accountNumber, accountNumber).setPhoneNumber(this.phoneNumber).Build();
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public Bank setPhoneNumber(String phoneNumber) {
		return new Bank.Builder(this.cvr, this.bankName, this.regNumber, this.accountNumber).setPhoneNumber(phoneNumber).Build();
	}
}
