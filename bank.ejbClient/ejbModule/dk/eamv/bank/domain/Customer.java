package dk.eamv.bank.domain;

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

	public String getSSN() {
		return sSN;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurName() {
		return surName;
	}

	public String getAddress() {
		return address;
	}

	public String getCountry() {
		return country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", sSN=" + sSN + ", firstName=" + firstName + ", surName="
				+ surName + ", address=" + address + ", country=" + country + ", zipCode=" + zipCode + ", city=" + city
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
}
