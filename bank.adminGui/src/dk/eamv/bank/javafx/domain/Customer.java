package dk.eamv.bank.javafx.domain;

public class Customer {

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

	public static class Builder {
		// Required Params
		private final int customerID;
		private final String sSN;

		// Optional Params
		private String firstName;
		private String surName;
		private String address;
		private String country;
		private String zipCode;
		private String city;
		private String email;
		private String phoneNumber;

		public Builder(int customerID, String sSN) {
			this.customerID = customerID;
			this.sSN = sSN;
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

		public Customer build() {
			return new Customer(this);
		}
	}

	private Customer(Builder builder) {
		customerID = builder.customerID;
		sSN = builder.sSN;
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

	public Customer setCustomerID(int customerID) {
		return new Customer.Builder(customerID, this.sSN).setFirstName(this.firstName).setSurName(this.surName)
				.setAddress(this.address).setCountry(this.country).setZipCode(this.zipCode).setCity(this.city)
				.setEmail(this.email).build();
	}

	public String getSSN() {
		return sSN;
	}

	public Customer setSSN(String sSN) {
		return new Customer.Builder(this.customerID, sSN).setFirstName(this.firstName).setSurName(this.surName)
				.setAddress(this.address).setCountry(this.country).setZipCode(this.zipCode).setCity(this.city)
				.setEmail(this.email).build();
	}

	public String getFirstName() {
		return firstName;
	}

	public Customer setFirstName(String firstName) {
		return new Customer.Builder(this.customerID, this.sSN).setFirstName(firstName).setSurName(this.surName)
				.setAddress(this.address).setCountry(this.country).setZipCode(this.zipCode).setCity(this.city)
				.setEmail(this.email).build();
	}

	public String getSurName() {
		return surName;
	}

	public Customer setSurName(String surName) {
		return new Customer.Builder(this.customerID, this.sSN).setFirstName(this.firstName).setSurName(surName)
				.setAddress(this.address).setCountry(this.country).setZipCode(this.zipCode).setCity(this.city)
				.setEmail(this.email).setPhoneNumber(this.phoneNumber).build();
	}

	public String getAddress() {
		return address;
	}

	public Customer setAddress(String address) {
		return new Customer.Builder(this.customerID, this.sSN).setFirstName(this.firstName).setSurName(this.surName)
				.setAddress(address).setCountry(this.country).setZipCode(this.zipCode).setCity(this.city)
				.setEmail(this.email).setPhoneNumber(this.phoneNumber).build();
	}

	public String getCountry() {
		return country;
	}

	public Customer setCountry(String country) {
		return new Customer.Builder(this.customerID, this.sSN).setFirstName(this.firstName).setSurName(this.surName)
				.setAddress(this.address).setCountry(country).setZipCode(this.zipCode).setCity(this.city)
				.setEmail(this.email).setPhoneNumber(this.phoneNumber).build();
	}

	public String getZipCode() {
		return zipCode;
	}

	public Customer setZipCode(String zipCode) {
		return new Customer.Builder(this.customerID, this.sSN).setFirstName(this.firstName).setSurName(this.surName)
				.setAddress(this.address).setCountry(this.country).setZipCode(zipCode).setCity(this.city)
				.setEmail(this.email).build();
	}

	public String getCity() {
		return city;
	}

	public Customer setCity(String city) {
		return new Customer.Builder(this.customerID, this.sSN).setFirstName(this.firstName).setSurName(this.surName)
				.setAddress(this.address).setCountry(this.country).setZipCode(this.zipCode).setCity(city)
				.setEmail(this.email).setPhoneNumber(this.phoneNumber).build();
	}

	public String getEmail() {
		return email;
	}

	public Customer setEmail(String email) {
		return new Customer.Builder(this.customerID, this.sSN).setFirstName(this.firstName).setSurName(this.surName)
				.setAddress(this.address).setCountry(this.country).setZipCode(this.zipCode).setCity(this.city)
				.setEmail(email).setPhoneNumber(this.phoneNumber).build();
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public Customer setPhoneNumber(String phoneNumber) {
		return new Customer.Builder(this.customerID, this.sSN).setFirstName(this.firstName).setSurName(this.surName)
				.setAddress(this.address).setCountry(this.country).setZipCode(this.zipCode).setCity(this.city)
				.setEmail(email).setPhoneNumber(this.phoneNumber).build();
	}

}
