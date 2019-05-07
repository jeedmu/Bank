package dk.eamv.bank.rest.domain;

import java.time.LocalDate;

import dk.eamv.bank.domain.CustomerChanges;
import dk.eamv.bank.domain.CustomerChanges.Builder;

public class CustomerChangesRest {
	private int customerID;
	private String sSN;
	private String firstName;
	private String surName;
	private String address;
	private String country;
	private String zipCode;
	private String city;
	private String email;
	private String phoneNumber;
	private LocalDate changeDate;
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getsSN() {
		return sSN;
	}
	public void setsSN(String sSN) {
		this.sSN = sSN;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(LocalDate changeDate) {
		this.changeDate = changeDate;
	}

	public CustomerChanges toDomain() {
		CustomerChanges.Builder builder = new Builder(customerID, sSN, changeDate).setFirstName(firstName).setSurName(surName)
				.setAddress(address).setCountry(country)
				.setCity(city).setZipCode(zipCode)
				.setEmail(email).setPhoneNumber(phoneNumber);
		return builder.build();
	}
}
