package dk.eamv.bank.javafx.domain;

public class CustomerSearchParameters {
	
	private String sSN;
	private String firstName;
	private String lastName;
	private String address;
	private String country;
	private String email;
	private String phoneNumber;

	public String getSSN() {
		return sSN;
	}


	public void setSSN(String sSN) {
		this.sSN = sSN;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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

}