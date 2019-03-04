package dk.eamv.bank.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: BankEntity
 *
 */
@Entity

public class BankEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public BankEntity() {
		super();
	}
	@NotNull
	private String bankName;
	@Id
	private int regNumber;
	
	
	public int getRegNumber() {
		return regNumber;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	
   
}
