package dk.eamv.bank.ejb;

import java.time.LocalDate;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Customer;
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

	@Override
	public boolean editCustomer(Customer customerData, LocalDate changeDate) {
		// TODO Auto-generated method stub
		return false;
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