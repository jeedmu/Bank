package dk.eamv.bank.domain;

import dk.eamv.bank.domain.Customer.Builder;

public class Bank {

	private final String cvr;
	private final String bankName;
	private final int regNumber;
	private final String phoneNumber;
	private final int accountNumber;
	private final String zipCode;
	private final String city;
	private String address;
	private String country;
	
	
	public static class Builder {
		private String cvr;
		private String bankName;
		private int regNumber;
		private int accountNumber;
		private String phoneNumber;
		private String zipCode;
		private String city;
		private String address;
		private String country;
		
		public Builder(){
		}
		
		public Builder setCvr(String cvr) {
			this.cvr = cvr;
			return this;
		}
		public Builder setZipCode(String zipCode) {
			this.zipCode = zipCode;
			return this;
		}

		public Builder setCity(String city) {
			this.city = city;
			return this;
		}
		
		public Builder setAddress(String address) {
			this.address= address;
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
		
		public Builder setCountry(String country) {
			this.country = country;
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
		address= builder.address;
		zipCode = builder.zipCode;
		city = builder.city;
		country = builder.country;
		
	}
	public String getAddress() {
		return address;
	}
	
	public String getCVR() {
		return cvr;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public int getRegNumber() {
		return regNumber;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}	
	
	public String getZipCode() {
		return zipCode;
	}	
	
	public String getCity() {
		return city;
	}
	
	public String getCountry() {
		return country;
	}
	
	
}
