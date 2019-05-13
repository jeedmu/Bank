package dk.eamv.bank.ejb.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import dk.eamv.bank.domain.Customer;

@NamedQueries({	@NamedQuery(name = "allCustomers", query = "SELECT p FROM customer p  "
															+ "ORDER BY p.customerID"),
				@NamedQuery(name = "searchCustomer", query = "SELECT p FROM customer p " 
															+ "WHERE p.firstName LIKE :search OR p.surName LIKE :search "
															+ "ORDER BY p.customerID")})

@Entity(name="customer")
public class CustomerEntity {
	
	@GeneratedValue
	@Id
	private int customerID;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "customerID")
	private List<AccountEntity> accounts;
	
	@NotNull
	@Column (length = 10, unique = true)
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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "zipCode")
	private ZipCodeEntity zipCode;
	
	@NotNull
	private String email;
	
	@NotNull
	private String phoneNumber;
	
	
	
	public CustomerEntity() {}
	
	public CustomerEntity(Customer customer) {
		this.customerID = customer.getCustomerID();
		this.sSN = customer.getSSN();
		this.firstName = customer.getFirstName();
		this.surName = customer.getSurName();
		this.address = customer.getAddress();
	//	this.zipCode = new ZipCodeEntity(customer.getZipCode(), customer.getCity());
		this.country = customer.getCountry();
		this.email = customer.getEmail();
		this.phoneNumber = customer.getPhoneNumber();
	}
	
	
	
	public Customer toDomain() {
		return new Customer.Builder(customerID, this.sSN).setFirstName(this.firstName).setSurName(this.surName).setAddress(this.address)
				.setCountry(this.country).setZipCode(this.zipCode.getZipCode()).setCity(this.zipCode.getCity()).setEmail(this.email)
				.setPhoneNumber(this.phoneNumber).build();
	} 
	
	public List<AccountEntity> getAccounts() {
		return accounts;
	}
	
	public void setAccounts(List<AccountEntity> accounts) {
		this.accounts = accounts;
	}
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
	public ZipCodeEntity getZipCode() {
		return zipCode;
	}
	public void setZipCode(ZipCodeEntity zipCode) {
		this.zipCode = zipCode;
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