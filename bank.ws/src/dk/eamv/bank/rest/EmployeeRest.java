package dk.eamv.bank.rest;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Customer;
import dk.eamv.bank.domain.CustomerChanges;
import dk.eamv.bank.domain.CustomerSearchParameters;
import dk.eamv.bank.domain.Entry;
import dk.eamv.bank.ejb.Employee;

@Path("/employee")
public class EmployeeRest {
	@EJB Employee employBean;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("editCustomer")
	public boolean editCustomer(CustomerChanges cC) {
		employBean.editCustomer(cC);
		return true;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("deleteCustomer/{customerID}")
	public boolean deleteCustomer(@PathParam("customerID") int customerID) {
		employBean.deleteCustomer(customerID);
		return true;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("editAccount")
	public boolean editAccount(Account account) {
		employBean.editAccount(account);
		return true;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("deleteAccount/{reg}/{acc}")
	
	public boolean deleteAccount(@PathParam("reg") int reg, @PathParam("acc") int acc) {
		 employBean.deleteAccount(reg, acc);
		 return true;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("customerSearch/{customerSearch}")
	
	public List<Customer> getCustomers(@PathParam("customerSearch") CustomerSearchParameters parameters) {
		return employBean.getCustomers(parameters);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("accounts/{customerID}")
	
	public List<Account> getAccounts(@PathParam("customerID") int customerID) {
		return employBean.getAccounts(customerID);
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("showEntries/{regNo}-{accountNo}/{fromDate}-{toDate}")
	public List<Entry> showEntries(@PathParam("regNo")int regNo, @PathParam("accountNo") int accountNo, @PathParam("fromDate") LocalDateTime fromDate, @PathParam("toDate") LocalDateTime toDate) {
		return employBean.showEntries(regNo, accountNo, fromDate, toDate);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("createAccount")
	public Account createAccount(Account account) {
		return employBean.createAccount(account);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("createCustomer")
	public Customer createCustomer(Customer customer) {
		return employBean.createCustomer(customer);
	}
}