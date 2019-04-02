package dk.eamv.bank.ejb;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Customer;
import dk.eamv.bank.domain.CustomerChanges;
import dk.eamv.bank.domain.CustomerSearchParameters;
import dk.eamv.bank.domain.Entry;
import dk.eamv.bank.ejb.entitybeans.AccountBean;
import dk.eamv.bank.ejb.entitybeans.CustomerBean;
import dk.eamv.bank.ejb.entitybeans.CustomerChangeBean;
import dk.eamv.bank.ejb.entitybeans.EntryBean;
import dk.eamv.bank.ejb.exception.AccountAlreadyExsistsException;
import dk.eamv.bank.ejb.exception.AccountNotFoundException;
import dk.eamv.bank.ejb.exception.CustomerAlreadyExsistsException;
import dk.eamv.bank.ejb.exception.CustomerNotFoundException;

/**
 * Session Bean implementation class EmployeeBean
 */
@Stateless
public class EmployeeBean implements Employee {

	@EJB CustomerChangeBean customerChangesBean;
	@EJB AccountBean accountBean;
	@EJB CustomerBean customerBean; 
	@EJB EntryBean entryBean;
	
    public EmployeeBean() {
        // TODO Auto-generated constructor stub
    }
    
    
    public List<Customer> getCustomers(CustomerSearchParameters parameters)
    {
    	return customerBean.getCustomers(parameters);
    }

    // fix return from customer changes 
	@Override
	public boolean editCustomer(CustomerChanges customerData) {
		if(customerData.getChangeDate().compareTo(LocalDate.now()) < 0)
			return false;
		customerChangesBean.create(customerData);
		return true;
	}

	@Override
	public boolean deleteCustomer(int customerID) {
		try 
		{
			customerBean.delete(customerID);
			return true;
		}
		catch(CustomerNotFoundException e)
		{
			return false;
		}
	}

	@Override
	public boolean editAccount(Account account) {
		try 
		{
			accountBean.update(account);
			return true;
		}
		catch(AccountNotFoundException e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteAccount(int regNumber, int accountNo) {
		try 
		{
			accountBean.delete(regNumber, accountNo);
			return true;
		}
		catch(AccountNotFoundException e)
		{
			return false;
		}
	}


	@Override
	public List<Account> getAccounts(int customerID) {
		return accountBean.list(customerID);
	}


	@Override
	public List<Entry> showEntries(Account account, LocalDateTime from, LocalDateTime to) {
		return entryBean.list(account.getAccountNumber(), account.getRegNumber());
	}


	@Override
	public boolean createAccount(Account account) {
		try {
			accountBean.create(account);
			return true;
		}catch(AccountAlreadyExsistsException e) {
			return false;	
		}
	}

	@Override
	public boolean createCustomer(Customer customer) {
		try {
			customerBean.create(customer);
			return true;
		}catch(CustomerAlreadyExsistsException e) {
			return false;
		}		
	}
}