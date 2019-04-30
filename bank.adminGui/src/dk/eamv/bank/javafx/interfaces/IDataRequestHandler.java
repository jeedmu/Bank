package dk.eamv.bank.javafx.interfaces;

import java.util.List;

import dk.eamv.bank.javafx.domain.Account;
import dk.eamv.bank.javafx.domain.Customer;
import dk.eamv.bank.javafx.domain.Entry;
import dk.eamv.bank.javafx.domain.Role;
import dk.eamv.bank.javafx.domain.Transfer;

public interface IDataRequestHandler 
{
	public void createNewCustomer(Customer customer);
	
	public void createNewAccount(Account account);
	
	public void createNewRole(Role role);

	public List<Customer> getCustomers(String customerID, String name, String phoneNumber);
	
	public List<Account> getAccounts(Customer customer);
	
	public List<Entry> getEntries(Account account);
	
	public Customer getCustomer(String customerID);
	
	public void createNewTransfer(Transfer transfer);
	
}
