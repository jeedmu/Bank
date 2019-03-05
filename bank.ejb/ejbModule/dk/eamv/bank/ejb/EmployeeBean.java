package dk.eamv.bank.ejb;

import java.util.HashMap;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class EmployeeBean
 */
@Stateless
public class EmployeeBean implements Employee {

    /**
     * Default constructor. 
     */
    public EmployeeBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean editCustomer(HashMap<String, String> customerData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editAccount(HashMap<String, String> accountData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccount(int accountNo) {
		// TODO Auto-generated method stub
		return false;
	}
    
    

}
