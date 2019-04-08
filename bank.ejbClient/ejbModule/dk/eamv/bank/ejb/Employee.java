package dk.eamv.bank.ejb;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
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
	
	public boolean editCustomer(CustomerChanges customer);

	public List<Account> getAccounts(int customerID);
	
	public List<Entry> showEntries(int regNo, int accountNo, LocalDateTime from, LocalDateTime to);
	
	public boolean createAccount(Account account);
	
	public boolean createCustomer(Customer customer);
	
	public boolean deleteCustomer(int customerID);

	public boolean editAccount(Account account);

	public boolean deleteAccount(int regNumber, int accountNo);	
}