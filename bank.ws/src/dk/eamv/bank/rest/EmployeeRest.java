package dk.eamv.bank.rest;

import java.time.LocalDate;

import javax.ws.rs.Path;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Customer;
import dk.eamv.bank.ejb.Employee;

@Path("/employee")
public class EmployeeRest implements Employee{

	@Override
	public boolean editCustomer(Customer customerData, LocalDate changeDate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccount(int regNumber, int accountNo) {
		// TODO Auto-generated method stub
		return false;
	}

}
