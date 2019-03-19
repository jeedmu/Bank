package dk.eamv.bank.ejb;

import java.time.LocalDate;
import java.util.HashMap;

import javax.ejb.Local;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Customer;

@Local
public interface Employee {

	/** 
	 * Used for both updating and creating customer
	 * @param customerData HashMap keys: "sSN", "firstName", "surName", "address", "country", "zipCode", "city", "email", "phoneNumber"
	 * @return true if succeeded, else false
	 */
	public boolean editCustomer(Customer customerData, LocalDate changeDate);

	public boolean deleteCustomer(int customerID);

	/**
	 * Used for both updating and creating account
	 * @param accountData HashMap keys: "customerID", "regNumber", "accountNumber", "accountName", "balance" 
	 * @return true if succeeded, else false
	 */
	public boolean editAccount(Account account);

	public boolean deleteAccount(int regNumber, int accountNo);
    
	
	
}
