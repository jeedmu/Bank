package domain;

import java.time.LocalDate;

import domain.Customer.Builder;

public class CustomerChanges {
	private final int customerID;
	private final String sSN;
	private final String firstName;
	private final String surName;
	private final String address;
	private final String country;
	private final String zipCode;
	private final String city;
	private final String email;
	private final String phoneNumber;
	private final LocalDate changeDate;

	public static class Builder {
		// Required Params
		private final int customerID;
		private final String sSN;
		private final LocalDate changeDate;

		// Optional Params
		private String firstName;
		private String surName;
		private String address;
		private String country;
		private String zipCode;
		private String city;
		private String email;
		private String phoneNumber;

		public Builder(int customerID, String sSN, LocalDate changeDate) {
			this.customerID = customerID;
			this.sSN = sSN;
			this.changeDate = changeDate;
		}

		public Builder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder setSurName(String surName) {
			this.surName = surName;
			return this;
		}

		public Builder setAddress(String address) {
			this.address = address;
			return this;
		}

		public Builder setCountry(String country) {
			this.country = country;
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

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}
		
		public Builder setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public CustomerChanges build() {
			return new CustomerChanges(this);
		}
	}

	private CustomerChanges(Builder builder) {
		customerID = builder.customerID;
		sSN = builder.sSN;
		changeDate = builder.changeDate;
		firstName = builder.firstName;
		surName = builder.surName;
		address = builder.address;
		country = builder.country;
		zipCode = builder.zipCode;
		city = builder.city;
		email = builder.email;
		phoneNumber = builder.phoneNumber;
	}

	public int getCustomerID() {
		return customerID;
	}

	public CustomerChanges setCustomerID(int customerID) {
		return new CustomerChanges.Builder(customerID, this.sSN, this.changeDate).setFirstName(this.firstName).setSurName(this.surName)
				.setAddress(this.address).setCountry(this.country).setZipCode(this.zipCode).setCity(this.city)
				.setEmail(this.email).build();
	}

	public String getSSN() {
		return sSN;
	}

	public CustomerChanges setSSN(String sSN) {
		return new CustomerChanges.Builder(this.customerID, sSN, this.changeDate).setFirstName(this.firstName).setSurName(this.surName)
				.setAddress(this.address).setCountry(this.country).setZipCode(this.zipCode).setCity(this.city)
				.setEmail(this.email).build();
	}
	
	public LocalDate getChangeDate() {
		return changeDate;
	}

	public CustomerChanges setChangeDate(LocalDate changeDate) {
		return new CustomerChanges.Builder(this.customerID, sSN, changeDate).setFirstName(this.firstName).setSurName(this.surName)
				.setAddress(this.address).setCountry(this.country).setZipCode(this.zipCode).setCity(this.city)
				.setEmail(this.email).build();
	}
	public String getFirstName() {
		return firstName;
	}

	public CustomerChanges setFirstName(String firstName) {
		return new CustomerChanges.Builder(this.customerID, this.sSN, this.changeDate).setFirstName(firstName).setSurName(this.surName)
				.setAddress(this.address).setCountry(this.country).setZipCode(this.zipCode).setCity(this.city)
				.setEmail(this.email).build();
	}

	public String getSurName() {
		return surName;
	}

	public CustomerChanges setSurName(String surName) {
		return new CustomerChanges.Builder(this.customerID, this.sSN, this.changeDate).setFirstName(this.firstName).setSurName(surName)
				.setAddress(this.address).setCountry(this.country).setZipCode(this.zipCode).setCity(this.city)
				.setEmail(this.email).setPhoneNumber(this.phoneNumber).build();
	}

	public String getAddress() {
		return address;
	}

	public CustomerChanges setAddress(String address) {
		return new CustomerChanges.Builder(this.customerID, this.sSN, this.changeDate).setFirstName(this.firstName).setSurName(this.surName)
				.setAddress(address).setCountry(this.country).setZipCode(this.zipCode).setCity(this.city)
				.setEmail(this.email).setPhoneNumber(this.phoneNumber).build();
	}

	public String getCountry() {
		return country;
	}

	public CustomerChanges setCountry(String country) {
		return new CustomerChanges.Builder(this.customerID, this.sSN, this.changeDate).setFirstName(this.firstName).setSurName(this.surName)
				.setAddress(this.address).setCountry(country).setZipCode(this.zipCode).setCity(this.city)
				.setEmail(this.email).setPhoneNumber(this.phoneNumber).build();
	}

	public String getZipCode() {
		return zipCode;
	}

	public CustomerChanges setZipCode(String zipCode) {
		return new CustomerChanges.Builder(this.customerID, this.sSN, this.changeDate).setFirstName(this.firstName).setSurName(this.surName)
				.setAddress(this.address).setCountry(this.country).setZipCode(zipCode).setCity(this.city)
				.setEmail(this.email).build();
	}

	public String getCity() {
		return city;
	}

	public CustomerChanges setCity(String city) {
		return new CustomerChanges.Builder(this.customerID, this.sSN, this.changeDate).setFirstName(this.firstName).setSurName(this.surName)
				.setAddress(this.address).setCountry(this.country).setZipCode(this.zipCode).setCity(city)
				.setEmail(this.email).setPhoneNumber(this.phoneNumber).build();
	}

	public String getEmail() {
		return email;
	}

	public CustomerChanges setEmail(String email) {
		return new CustomerChanges.Builder(this.customerID, this.sSN, this.changeDate).setFirstName(this.firstName).setSurName(this.surName)
				.setAddress(this.address).setCountry(this.country).setZipCode(this.zipCode).setCity(this.city)
				.setEmail(email).setPhoneNumber(this.phoneNumber).build();
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public CustomerChanges setPhoneNumber(String phoneNumber) {
		return new CustomerChanges.Builder(this.customerID, this.sSN, this.changeDate).setFirstName(this.firstName).setSurName(this.surName)
				.setAddress(this.address).setCountry(this.country).setZipCode(this.zipCode).setCity(this.city)
				.setEmail(email).setPhoneNumber(this.phoneNumber).build();
	}
}
