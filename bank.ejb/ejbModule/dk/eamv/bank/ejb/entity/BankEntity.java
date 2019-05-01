package dk.eamv.bank.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import dk.eamv.bank.domain.Bank;

/**
 * Entity implementation class for Entity: BankEntity
 *
 */

//joke
@NamedQuery(name = "allBanks", query = "SELECT p FROM bank p  "
		+ "ORDER BY p.cvr")

@Entity(name = "bank")

public class BankEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@Id
	private int regNumber;
	@NotNull
	private String bankName;
	@NotNull
	private String cvr;
	@NotNull
	private int accountNumber;
	@NotNull
	private String phoneNumber;
	@NotNull
	private String address;
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "zipCode")
	private ZipCodeEntity zipCode;
	@NotNull
	private String country;

	
	
	
	public BankEntity(Bank bank) {
		this.cvr = bank.getCVR();
		this.bankName = bank.getBankName();
		this.regNumber = bank.getRegNumber();
		this.accountNumber = bank.getAccountNumber();
		this.phoneNumber = bank.getPhoneNumber();
		this.address= bank.getAddress();
		this.country = bank.getCountry();
//		this.zipCode = new ZipCodeEntity(bank.getZipCode(), bank.getCity());
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
	
	public BankEntity() {
	}
	
	public String getCVR() {
		return cvr;
	}
	
	public void setCVR(String cvr) {
		this.cvr = cvr;
	}
	
	public int getRegNumber() {
		return regNumber;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setRegNumber(int regnumber) {
		this.regNumber = regnumber;
	}
	
	public void setBankName(String bankname) {
		this.bankName = bankname;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
   
	public Bank toDomain() {
		return new Bank.Builder().setCvr(this.cvr)
				.setBankName(this.bankName)
				.setRegNumber(this.regNumber)
				.setAccountNumber(this.accountNumber)
				.setPhoneNumber(this.phoneNumber)
				.setAddress(this.address)
				.setZipCode(this.zipCode.getZipCode())
				.setCity(this.zipCode.getCity())
				.setCountry(this.country)
				.build();
	}
	
}
