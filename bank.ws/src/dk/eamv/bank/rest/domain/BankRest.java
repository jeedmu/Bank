package dk.eamv.bank.rest.domain;

import dk.eamv.bank.domain.Bank;
import dk.eamv.bank.domain.Bank.Builder;

public class BankRest {
	private String cvr;
	private String bankName;
	private int regNumber;
	private String phoneNumber;
	private int accountNumber;
	private String zipCode;
	private String city;
	private String address;
	private String country;
	
	public String getCvr() {
		return cvr;
	}
	public void setCvr(String cvr) {
		this.cvr = cvr;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(int regNumber) {
		this.regNumber = regNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Bank toDomain() {
		Bank.Builder builder = new Builder().setAccountNumber(accountNumber)
											.setAddress(address)
											.setBankName(bankName)
											.setCity(city)
											.setCountry(country)
											.setCvr(cvr)
											.setPhoneNumber(phoneNumber)
											.setRegNumber(regNumber)
											.setZipCode(zipCode);
		return builder.build();
	}

}
