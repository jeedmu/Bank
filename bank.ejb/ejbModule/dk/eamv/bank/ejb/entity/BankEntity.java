package dk.eamv.bank.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import dk.eamv.bank.domain.Bank;

/**
 * Entity implementation class for Entity: BankEntity
 *
 */
@Entity

public class BankEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@Id
	private String cvr;
	@NotNull
	private String bankName;
	@NotNull
	private int regNumber;
	@NotNull
	private int accountNumber;
	@NotNull
	private String phoneNumber;
	
	
	
	public BankEntity(Bank bank) {
		this.cvr = bank.getCVR();
		this.bankName = bank.getBankName();
		this.regNumber = bank.getRegNumber();
		this.accountNumber = bank.getAccountNumber();
		this.phoneNumber = bank.getPhoneNumber();
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
		return new Bank.Builder(this.cvr, this.bankName, this.regNumber, this.accountNumber).setPhoneNumber(this.phoneNumber).Build();
	}
	
}
