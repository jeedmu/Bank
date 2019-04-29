package dk.eamv.bank.ejb.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name="zipCode")
public class ZipCodeEntity {

	@Id
	@NotNull
	private String zipCode;
	
	@NotNull
	private String city;
	
	public ZipCodeEntity() {
		
	}
	
	public ZipCodeEntity(String zip, String city) {
		this.zipCode = zip;
		this.city = city;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zip) {
		this.zipCode = zip;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
}
