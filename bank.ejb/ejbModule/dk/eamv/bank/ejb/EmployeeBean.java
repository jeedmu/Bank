package dk.eamv.bank.ejb;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Customer;
import dk.eamv.bank.domain.CustomerChanges;
import dk.eamv.bank.domain.CustomerSearchParameters;
import dk.eamv.bank.ejb.entitybeans.AccountBean;
import dk.eamv.bank.ejb.entitybeans.CustomerBean;
import dk.eamv.bank.ejb.entitybeans.CustomerChangeBean;
import dk.eamv.bank.ejb.exception.AccountNotFoundException;
import dk.eamv.bank.ejb.exception.CustomerNotFoundException;

/**
 * Session Bean implementation class EmployeeBean
 */
@Stateless
public class EmployeeBean implements Employee {

	@EJB CustomerChangeBean customerChangesBean;
	@EJB AccountBean accountBean;
	@EJB CustomerBean customerBean; 
	
    public EmployeeBean() {
        // TODO Auto-generated constructor stub
    }
    
    
    public List<Customer> getCustomers(CustomerSearchParameters parameters)
    {
    	return customerBean.getCustomers(parameters);
    }

    // fix return from customer changes 
	@Override
	public boolean editCustomer(Customer customerData, LocalDate changeDate) {
		if(changeDate.compareTo(LocalDate.now()) < 0)
			return false;
		
		CustomerChanges customerChanges = new CustomerChanges.Builder(customerData.getCustomerID(), customerData.getSSN(), changeDate)
															 .setAddress(customerData.getAddress())
															 .setCity(customerData.getCity())
															 .setCountry(customerData.getCountry())
															 .setEmail(customerData.getEmail())
															 .setFirstName(customerData.getFirstName())
															 .setPhoneNumber(customerData.getPhoneNumber())
															 .setSurName(customerData.getSurName())
															 .setZipCode(customerData.getZipCode())
															 .build();
		customerChangesBean.create(customerChanges);
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
}