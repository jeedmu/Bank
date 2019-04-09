package dk.eamv.bank.ejb;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Local;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Customer;
import dk.eamv.bank.domain.CustomerChanges;
import dk.eamv.bank.domain.CustomerSearchParameters;
import dk.eamv.bank.domain.Entry;

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
	
	public void editCustomer(CustomerChanges customer);

	public List<Account> getAccounts(int customerID);
	
	public List<Entry> showEntries(int regNo, int accountNo, LocalDateTime from, LocalDateTime to);
	
	public Account createAccount(Account account);
	
	public Customer createCustomer(Customer customer);
	
	public void deleteCustomer(int customerID);

	public void editAccount(Account account);

	public void deleteAccount(int regNumber, int accountNo);	
}