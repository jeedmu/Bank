package test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Bank;
import dk.eamv.bank.domain.Customer;
import dk.eamv.bank.domain.CustomerSearchParameters;
import dk.eamv.bank.domain.Role;
import dk.eamv.bank.domain.Transfer;
import dk.eamv.bank.domain.User;
import dk.eamv.bank.ejb.Admin;
import dk.eamv.bank.ejb.Employee;
import dk.eamv.bank.ejb.HomeBanking;

/**
 * Servlet implementation class TestUserServlet
 */
@WebServlet("admin/TestUser")
public class TestUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private Admin admin;
	@EJB private Employee employee;
	@EJB private HomeBanking homebanking;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if (request.getParameter("test").equalsIgnoreCase("1")) {
			// Roles
			Role role1 = new Role(0, "admin");
			role1 = admin.createRole(role1);
			Role role2 = new Role(0, "employee");
			role2 = admin.createRole(role2);
			Role role3 = new Role(0, "customer");
			role3 = admin.createRole(role3);
			Role role4 = new Role(0, "bank");
			role4 = admin.createRole(role4);
			
			
			// Customers
			Customer customer1 = new Customer.Builder(0, "111").setFirstName("c1").setSurName("s1").setEmail("c1@eamv.dk").setPhoneNumber("+45-111")
					.setAddress("g1").setZipCode("7400").setCity("Herning").setCountry("Danmark").build();
			customer1 = employee.createCustomer(customer1);
			Customer customer2 = new Customer.Builder(0, "222").setFirstName("c2").setSurName("s2").setEmail("c2@eamv.dk").setPhoneNumber("+45-222")
					.setAddress("g2").setZipCode("7400").setCity("Herning").setCountry("Danmark").build();
			customer2 = employee.createCustomer(customer2);
			Customer customer3 = new Customer.Builder(0, "333").setFirstName("c3").setSurName("s3").setEmail("c3@eamv.dk").setPhoneNumber("+45-333")
					.setAddress("g1").setZipCode("7500").setCity("Holstebro").setCountry("Danmark").build();
			customer3 = employee.createCustomer(customer3);
			Customer customer4 = new Customer.Builder(0, "444").setFirstName("c4").setSurName("s4").setEmail("c4@eamv.dk").setPhoneNumber("+45-444")
					.setAddress("g1").setZipCode("8500").setCity("Silkeborg").setCountry("Danmark").build();
			customer4 = employee.createCustomer(customer4);
			
			// Users
			User user1 = new User.Builder("admin").setName("Admin").setPassword("admin").setCustomerId(customer1.getCustomerID()).setRoles(Arrays.asList(role1, role2)).build();
			user1 = admin.createUser(user1);
			User user2 = new User.Builder("employee").setName("Employee").setPassword("employee").setCustomerId(customer2.getCustomerID()).setRoles(Arrays.asList(role2)).build();
			user2 = admin.createUser(user2);
			User user3 = new User.Builder("customer").setName("Customer").setPassword("customer").setCustomerId(customer3.getCustomerID()).setRoles(Arrays.asList(role3)).build();
			user3 = admin.createUser(user3);
			User user4 = new User.Builder("bank").setName("Bank").setPassword("bank").setCustomerId(customer4.getCustomerID()).setRoles(Arrays.asList(role4)).build();
			user4 = admin.createUser(user4);
		}
		if (request.getParameter("test").equalsIgnoreCase("2")) {
			CustomerSearchParameters cp = new CustomerSearchParameters();
			cp.setFirstName("c4");
			List<Customer> customers = employee.getCustomers(cp);
			if (customers.size() == 1) {
				Customer customer = customers.get(0);
				response.getWriter().println(customer);
				
				// Accounts
				Account account1 = new Account.Builder(customer.getCustomerID(), 1111, 0).setAccountName("Lønkonto").setBalance(new BigDecimal(5000.00)).build();
				account1 = employee.createAccount(account1);
				Account account2 = new Account.Builder(customer.getCustomerID(), 1111, 0).setAccountName("Budgetkonto").setBalance(new BigDecimal(10000.00)).build();
				account2 = employee.createAccount(account2);
				
				// Entries
				Transfer transfer1 = new Transfer();
				transfer1.setAmount(new BigDecimal(100.00));
				transfer1.setCurrentCustomer(customer);
				transfer1.setDate(LocalDateTime.now());
				transfer1.setFromAccount(account1);
				transfer1.setFromDescription("Overførsel til budget");
				transfer1.setRegNumber(1111);
				transfer1.setToAccountAccountNumber(account2.getAccountNumber());
				transfer1.setToDescription("Overførsel fra lønkonto");
				homebanking.transferEntry(transfer1);
				
				Transfer transfer2 = new Transfer();
				transfer2.setAmount(new BigDecimal(200.00));
				transfer2.setCurrentCustomer(customer);
				transfer2.setDate(LocalDateTime.now());
				transfer2.setFromAccount(account1);
				transfer2.setFromDescription("Overførsel til budget");
				transfer2.setRegNumber(1111);
				transfer2.setToAccountAccountNumber(account2.getAccountNumber());
				transfer2.setToDescription("Overførsel fra lønkonto");
				homebanking.transferEntry(transfer2);
			}
		}
		if (request.getParameter("test").equalsIgnoreCase("3")) {
			Account account1111 = new Account.Builder(0, 1111, 0).setAccountName("Bank 1111").setBalance(new BigDecimal(0.00)).build();
			account1111 = employee.createAccount(account1111);
			Bank bank1111 = new Bank.Builder().setRegNumber(1111).setAccountNumber(account1111.getAccountNumber())
					.setBankName("Bank 1111").setCvr("1111").setPhoneNumber("+45 1111")
					.setAddress("g1111").setZipCode("7400").setCity("Herning").setCountry("Danmark").build();
			admin.createBank(bank1111);
			
			Account account2222 = new Account.Builder(0, 1111, 0).setAccountName("Bank 2222").setBalance(new BigDecimal(0.00)).build();
			account2222 = employee.createAccount(account2222);
			Bank bank2222 = new Bank.Builder().setRegNumber(2222).setAccountNumber(account2222.getAccountNumber())
					.setBankName("Bank 2222").setCvr("2222").setPhoneNumber("+45 2222")
					.setAddress("g2222").setZipCode("7480").setCity("Vildbjerg").setCountry("Danmark").build();
			admin.createBank(bank2222);
			
			Account account3333 = new Account.Builder(0, 1111, 0).setAccountName("Bank 3333").setBalance(new BigDecimal(0.00)).build();
			account3333 = employee.createAccount(account3333);
			Bank bank3333 = new Bank.Builder().setRegNumber(3333).setAccountNumber(account3333.getAccountNumber())
					.setBankName("Bank 3333").setCvr("3333").setPhoneNumber("+45 3333")
					.setAddress("g3333").setZipCode("7600").setCity("Struer").setCountry("Danmark").build();
			admin.createBank(bank2222);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
