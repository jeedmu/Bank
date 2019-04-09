package dk.eamv.bank.rest;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
import dk.eamv.bank.ejb.entitybeans.AccountBean;
import dk.eamv.bank.ejb.entitybeans.CustomerBean;
import dk.eamv.bank.ejb.entitybeans.CustomerChangeBean;
import dk.eamv.bank.ejb.entitybeans.EntryBean;

@Path("/employee")
public class EmployeeRest implements Employee {
	@EJB CustomerChangeBean cCB;	
	@EJB CustomerBean cB;
	@EJB AccountBean aB;
	@EJB EntryBean eB;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("editCustomer")
	@Override
	public boolean editCustomer(CustomerChanges cC) {
		try {
			cCB.create(cC);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("deleteCustomer/{customerID}")
	@Override
	public boolean deleteCustomer(@PathParam("customerID") int customerID) {
		try {
			cB.delete(customerID);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("editAccount")
	@Override
	public boolean editAccount(Account account) {
		try {
			aB.update(account);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("deleteAccount/{reg}/{acc}")
	@Override
	public boolean deleteAccount(@PathParam("reg") int reg, @PathParam("acc") int acc) {
		try {
			aB.delete(reg, acc);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("customerSearch/{customerSearch}")
	@Override
	public List<Customer> getCustomers(@PathParam("customerSearch") CustomerSearchParameters parameters) {
		return cB.getCustomers(parameters);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("accounts/{customerID}")
	@Override
	public List<Account> getAccounts(@PathParam("customerID") int customerID) {
		return aB.list(customerID);
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("showEntries/{regNo}-{accountNo}/{fromDate}-{toDate}")
	@Override
	public List<Entry> showEntries(@PathParam("regNo")int regNo, @PathParam("accountNo") int accountNo, @PathParam("fromDate") LocalDateTime fromDate, @PathParam("toDate") LocalDateTime toDate) {
		List<Entry> entryList = eB.list(accountNo, regNo);
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
		try {
			aB.create(account);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("createCustomer")
	@Override
	public boolean createCustomer(Customer customer) {
		try {
			cB.create(customer);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
