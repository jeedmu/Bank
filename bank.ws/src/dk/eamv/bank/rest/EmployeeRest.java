package dk.eamv.bank.rest;

import java.time.LocalDate;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Customer;
import dk.eamv.bank.domain.CustomerChanges;
import dk.eamv.bank.domain.CustomerSearchParameters;
import dk.eamv.bank.ejb.Employee;
import dk.eamv.bank.ejb.entitybeans.AccountBean;
import dk.eamv.bank.ejb.entitybeans.CustomerBean;
import dk.eamv.bank.ejb.entitybeans.CustomerChangeBean;

@Path("/employee")
public class EmployeeRest implements Employee{
	CustomerChangeBean cCB;	
	CustomerBean cB;
	AccountBean aB;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("editCustomer")
	@Override
	public boolean editCustomer(Customer cD, LocalDate changeDate) {
		CustomerChanges cC = new CustomerChanges.Builder(cD.getCustomerID(), cD.getSSN(), changeDate)
											.setFirstName(cD.getFirstName())
											.setSurName(cD.getSurName())
											.setAddress(cD.getAddress())
											.setCountry(cD.getCountry())
											.setZipCode(cD.getZipCode())
											.setCity(cD.getCity())
											.setEmail(cD.getEmail())
											.setPhoneNumber(cD.getPhoneNumber())
											.build();
		cCB.create(cC);
		return true;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("deleteCustomer/{key}")
	@Override
	public boolean deleteCustomer(@PathParam("key") int key) {
		cB.delete(key);
		return true;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("editAccount")
	@Override
	public boolean editAccount(Account account) {
		aB.update(account);
		return true;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("deleteAccount/{reg}&{acc}")
	@Override
	public boolean deleteAccount(@PathParam("reg") int reg, @PathParam("acc") int acc) {
		aB.delete(reg, acc);
		return true;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("customerSearch")
	@Override
	public List<Customer> getCustomers(CustomerSearchParameters parameters) {
		List<Customer> cL = cB.getCustomers(parameters);
		return cL;
	}

}
