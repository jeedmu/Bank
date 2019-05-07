package domain;

public class Bank {

	private final String cvr;
	private final String bankName;
	private final int regNumber;
	private final String phoneNumber;
	private final int accountNumber;
	
	
	public static class Builder {
		private String cvr;
		private String bankName;
		private int regNumber;
		private int accountNumber;
		private String phoneNumber;
		
		public Builder(){
		}
		
		public Builder setCvr(String cvr) {
			this.cvr = cvr;
			return this;
		}
		public Builder setBankName(String bankName) {
			this.bankName = bankName;
			return this;
		}
		public Builder setRegNumber(int regNumber) {
			this.regNumber = regNumber;
			return this;
		}
		public Builder setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
			return this;
		}
		public Builder setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		
		public Bank build() {
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
		return new Bank.Builder().setCvr(cvr).setBankName(this.bankName).setRegNumber(this.regNumber).setAccountNumber(this.accountNumber).setPhoneNumber(this.phoneNumber).build();
	}

	public String getBankName() {
		return bankName;
	}

	public Bank setBankName(String bankName) {
		return new Bank.Builder().setCvr(this.cvr).setBankName(bankName).setRegNumber(this.regNumber).setAccountNumber(this.accountNumber).setPhoneNumber(this.phoneNumber).build();
	}
	
	public int getRegNumber() {
		return regNumber;
	}

	public Bank setRegNumber(int regNumber) {
		return new Bank.Builder().setCvr(this.cvr).setBankName(this.bankName).setRegNumber(regNumber).setAccountNumber(this.accountNumber).setPhoneNumber(this.phoneNumber).build();
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public Bank setAccountNumber(int accountNumber) {
		return new Bank.Builder().setCvr(this.cvr).setBankName(this.bankName).setRegNumber(this.regNumber).setAccountNumber(accountNumber).setPhoneNumber(this.phoneNumber).build();
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public Bank setPhoneNumber(String phoneNumber) {
		return new Bank.Builder().setCvr(this.cvr).setBankName(this.bankName).setRegNumber(this.regNumber).setAccountNumber(this.accountNumber).setPhoneNumber(phoneNumber).build();
	}
}
