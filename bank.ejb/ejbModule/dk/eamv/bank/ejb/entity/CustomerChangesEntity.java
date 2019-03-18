package dk.eamv.bank.ejb.entity;


import java.time.LocalDate;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import dk.eamv.bank.domain.CustomerChanges;
@NamedQueries({	@NamedQuery(name = "allCustomerChanges", query = "SELECT p FROM customerChanges p  "
		+ "ORDER BY p.customerID"),
@NamedQuery(name = "searchCustomerChange", query = "SELECT p FROM customerChanges p " 
		+ "WHERE p.firstName LIKE :search OR p.surName LIKE :search "
		+ "ORDER BY p.customerID")})

@Entity(name="customerChanges")
public class CustomerChangesEntity {
	
	@NotNull
	@Id
	private int customerID;
	
	@NotNull
	@Column (length = 10)
	private String sSN;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String surName;
	
	@NotNull
	private String address;
	
	@NotNull
	private String country;
	
	@NotNull
	@Pattern(regexp= "(\"^[0-9]*$\"")
	private String zipCode;
	
	@NotNull
	@Pattern(regexp = "(\"^[A-Za-z]*$\"")
	private String city;
	
	@NotNull
	private String email;
	
	@NotNull
	private String phoneNumber;
	
	@NotNull
	private LocalDate changeDate;
	
	public CustomerChangesEntity() {}
	
	public CustomerChangesEntity(CustomerChanges customer) {
		this.customerID = customer.getCustomerID();
		this.sSN = customer.getSSN();
		this.firstName = customer.getFirstName();
		this.surName = customer.getSurName();
		this.address = customer.getAddress();
		this.zipCode = customer.getZipCode();
		this.city = customer.getCity();
		this.email = customer.getEmail();
		this.changeDate = customer.getChangeDate();
		
	}	
		
	//Methods
	
	public CustomerChanges toDomain() {
		return new CustomerChanges.Builder(customerID, this.sSN, this.changeDate).setFirstName(this.firstName).setSurName(this.surName).setAddress(this.address)
				.setCountry(this.country).setZipCode(this.zipCode).setCity(this.city).setEmail(this.email)
				.setPhoneNumber(this.phoneNumber).build();
	} 
	
	//..............................//
	//Setters and getters//
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
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
	

}