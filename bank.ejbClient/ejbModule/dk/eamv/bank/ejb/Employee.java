package dk.eamv.bank.ejb;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Local;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Customer;
import dk.eamv.bank.domain.CustomerSearchParameters;

@Local
public interface Employee {

	/**
	 * Search for customers based on the given search parameters. 
	 * If any of the parameters in the CustomerSearchParameters are equal to null, they will not be used in the search.
	 * 
	 * @param parameters class that contains the search parameters
	 * @return a list with customers based on the given search parameters
	 */
	public List<Customer> getCustomers(CustomerSearchParameters parameters);
	
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
