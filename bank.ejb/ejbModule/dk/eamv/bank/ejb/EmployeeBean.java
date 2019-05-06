package dk.eamv.bank.ejb;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import dk.eamv.bank.constants.Constants;
import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Customer;
import dk.eamv.bank.domain.CustomerChanges;
import dk.eamv.bank.domain.CustomerSearchParameters;
import dk.eamv.bank.domain.Entry;
import dk.eamv.bank.ejb.entitybeans.AccountBean;
import dk.eamv.bank.ejb.entitybeans.CustomerBean;
import dk.eamv.bank.ejb.entitybeans.CustomerChangeBean;
import dk.eamv.bank.ejb.entitybeans.EntryBean;
import dk.eamv.bank.ejb.exception.CustomerChangeInPastException;

/**
 * Session Bean implementation class EmployeeBean
 */
@Stateless
@RolesAllowed(Constants.employeeRole)
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
	public void editCustomer(CustomerChanges customerData) {
		if(customerData.getChangeDate().compareTo(LocalDate.now()) < 0)
			throw new CustomerChangeInPastException();
		
		customerChangesBean.create(customerData);
	}

	@Override
	public void deleteCustomer(int customerID) {
		customerBean.delete(customerID);
	}

	@Override
	public void editAccount(Account account) {
		accountBean.update(account);
	}

	@Override
	public void deleteAccount(int regNumber, int accountNo) {
		accountBean.delete(regNumber, accountNo);
	}


	@Override
	public List<Account> getAccounts(int customerID) {
		return accountBean.list(customerID);
	}


	@Override
	public List<Entry> showEntries(int regNo, int accountNo, LocalDateTime from, LocalDateTime to) {
		List<Entry> entries = entryBean.list(accountNo, regNo);
		List<Entry> filteredEntries = new ArrayList<Entry>();
		
		for(Entry e : entries)
		{
			LocalDateTime date = e.getDate(); 
			if((date.isAfter(from) && !date.isBefore(to)) || date.isEqual(from) || date.isEqual(to))
				filteredEntries.add(e);
		}
		
		return entries;
	}


	@Override
	public Account createAccount(Account account) {
		return accountBean.create(account); 
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return customerBean.create(customer);
	}
}