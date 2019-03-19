package dk.eamv.bank.ejb;

import java.time.LocalDate;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Customer;
import dk.eamv.bank.domain.CustomerChanges;
import dk.eamv.bank.ejb.entitybeans.AccountBean;
import dk.eamv.bank.ejb.entitybeans.CustomerChangeBean;

/**
 * Session Bean implementation class EmployeeBean
 */
@Stateless
public class EmployeeBean implements Employee {

	@EJB CustomerChangeBean customerChangesBean;
	@EJB AccountBean accountBean;
	
    public EmployeeBean() {
        // TODO Auto-generated constructor stub
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
															 .setZipCode(customerData.getZipCode()).build();
		customerChangesBean.create(customerChanges);
		return true;
	}

	@Override
	public boolean deleteCustomer(int customerID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editAccount(Account accountData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccount(int accountNo) {
		// TODO Auto-generated method stub
		return false;
	}
}