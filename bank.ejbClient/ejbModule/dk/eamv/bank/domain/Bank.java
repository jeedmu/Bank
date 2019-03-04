package dk.eamv.bank.domain;

public class Bank {

	private final String cvr;
	private final String bankName;
	private final int regNumber;
	private final String phoneNumber;
	
	
	public static class Builder {
		//Required params
		private final String cvr;
		private final String bankName;
		private final int regNumber;
		
		//Optional params
		private String phoneNumber;
		
		public Builder(String cvr, String bankName, int regNumber) {
			this.cvr = cvr;
			this.bankName = bankName;
			this.regNumber = regNumber;
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
	}
	
	public String getCVR() {
		return cvr;
	}
	
	public Bank setCVR(String cvr) {
		return new Bank.Builder(cvr, this.bankName, this.regNumber).setPhoneNumber(this.phoneNumber).Build();
	}

	public String getBankName() {
		return bankName;
	}

	public Bank setBankName(String bankName) {
		return new Bank.Builder(this.cvr, bankName, this.regNumber).setPhoneNumber(this.phoneNumber).Build();
	}
	
	public int getRegNumber() {
		return regNumber;
	}

	public Bank setRegName(int regNumber) {
		return new Bank.Builder(this.cvr, this.bankName, regNumber).setPhoneNumber(this.phoneNumber).Build();
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public Bank setPhoneNumber(String phoneNumber) {
		return new Bank.Builder(this.cvr, this.bankName, this.regNumber).setPhoneNumber(phoneNumber).Build();
	}
}
