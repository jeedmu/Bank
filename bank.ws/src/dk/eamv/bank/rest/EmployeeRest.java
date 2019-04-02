package dk.eamv.bank.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
import dk.eamv.bank.ejb.entitybeans.AccountBean;
import dk.eamv.bank.ejb.entitybeans.CustomerBean;
import dk.eamv.bank.ejb.entitybeans.CustomerChangeBean;
import dk.eamv.bank.ejb.entitybeans.EntryBean;

@Path("/employee")
public class EmployeeRest implements Employee{
	CustomerChangeBean cCB;	
	CustomerBean cB;
	AccountBean aB;
	EntryBean eB;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("editCustomer")
	@Override
	public boolean editCustomer(CustomerChanges cC) {
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
		return cB.getCustomers(parameters);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("accounts")
	@Override
	public List<Account> getAccounts(int customerID) {
		return aB.list(customerID);
	}

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("showEntries")
	@Override
	public List<Entry> showEntries(Account account, LocalDateTime fromDate, LocalDateTime toDate) {
		List<Entry> entryList = eB.list(account.getAccountNumber(), account.getRegNumber());
		List<Entry> returnList = new ArrayList<Entry>();
		for(Entry e : entryList) {
			if((e.getDate().isAfter(fromDate) || e.getDate().isEqual(fromDate)) 
			&& (e.getDate().isBefore(toDate)|| e.getDate().isEqual(toDate))) {
				returnList.add(e);
			}
		}
		return returnList;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("createAccount")
	@Override
	public boolean createAccount(Account account) {
		aB.create(account);
		return true;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("createCustomer")
	@Override
	public boolean createCustomer(Customer customer) {
		cB.create(customer);
		return true;
	}
}
