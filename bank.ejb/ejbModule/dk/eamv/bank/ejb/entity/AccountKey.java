package dk.eamv.bank.ejb.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;

@Embeddable
public class AccountKey implements Serializable
{
	private static final long serialVersionUID = 1L;

	@NotNull
    private int regNumber;
    
	@GeneratedValue
    private int accountNumber;

    public AccountKey() { }

    public int getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(int regNumber) 
    {
        this.regNumber = regNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int hashCode() {
        return regNumber + accountNumber;
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof AccountKey)) return false;
        AccountKey pk = (AccountKey) obj;
        return pk.accountNumber == accountNumber && pk.regNumber == regNumber;
    }
}
