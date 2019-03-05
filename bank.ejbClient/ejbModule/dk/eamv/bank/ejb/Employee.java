package dk.eamv.bank.ejb;

import java.util.HashMap;

import javax.ejb.Local;

@Local
public interface Employee {

	/** 
	 * Used for both updating and creating customer
	 * @param customerData HashMap keys: "sSN", "firstName", "surName", "address", "country", "zipCode", "city", "email", "phoneNumber"
	 * @return true if succeeded, else false
	 */
	public boolean editCustomer(HashMap<String, String> customerData);

	public boolean deleteCustomer(int customerID);

	/**
	 * Used for both updating and creating account
	 * @param accountData HashMap keys: "customerID", "regNumber", "accountNumber", "accountName", "balance" 
	 * @return true if succeeded, else false
	 */
	public boolean editAccount(HashMap<String, String> accountData);

	public boolean deleteAccount(int accountNo);
    
	
	
}
