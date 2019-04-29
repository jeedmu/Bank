package dk.eamv.bank.javafx.testHandlers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dk.eamv.bank.javafx.domain.Account;
import dk.eamv.bank.javafx.domain.Account.Builder;
import dk.eamv.bank.javafx.domain.Customer;
import dk.eamv.bank.javafx.domain.Entry;
import dk.eamv.bank.javafx.domain.Transfer;
import dk.eamv.bank.javafx.interfaces.IDataRequestHandler;

public class DataRequestHandlerTest implements IDataRequestHandler
{
	@Override
	public void createNewCustomer(Customer customer) 
	{
		System.out.println("new customer created :"+customer.getFirstName()+" "+customer.getSurName());
	}
	
	@Override
	public void createNewAccount(Account account) {
		// TODO Auto-generated method stub
		System.out.println("new account created :"+account.getAccountName()+" "+account.getAccountNumber());
	}

	@Override
	public List<Customer> getCustomers(String customerID, String name, String phoneNumber) {
		// TODO Auto-generated method stub
		//create test code
		Customer.Builder builder1 = new Customer.Builder(1234, "14141").setFirstName("peter").setSurName("larsen").setAddress("lyngbye")
				.setCountry("danmark").setZipCode("1241").setCity("øde").setEmail("wutwut@hotmales.dk").setPhoneNumber("95919192");
		Customer customer1=builder1.build();
		
		Customer.Builder builder2 = new Customer.Builder(63, "345345").setFirstName("per").setSurName("olsen").setAddress("lyngbye")
				.setCountry("danmark").setZipCode("4121").setCity("geje").setEmail("putpti@hotmales.dk").setPhoneNumber("34534212");
		Customer customer2=builder2.build();
		
		Customer.Builder builder3 = new Customer.Builder(3, "323465").setFirstName("patrick").setSurName("Nielsen").setAddress("holstebro")
				.setCountry("tyskland").setZipCode("11221").setCity("verbrundingshejise").setEmail("gutgut@hotmales.dk").setPhoneNumber("2345644");
		Customer customer3=builder3.build();
		
		List<Customer> customers=new ArrayList<Customer>();
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		return customers;
	}

	@Override
	public List<Account> getAccounts(Customer customer) 
	{
		Account.Builder builder1 = new Builder(customer.getCustomerID(), 04040404, 23232323).setAccountName("Forbrug").setBalance(new BigDecimal(2942.23));
		Account account1 = builder1.build();
		
		Account.Builder builder2 = new Builder(customer.getCustomerID(), 04040404, 21234211).setAccountName("Opsparing").setBalance(new BigDecimal(12000.50));
		Account account2 = builder2.build();
		
		List<Account> accounts=new ArrayList<Account>();
		accounts.add(account1);
		accounts.add(account2);
		return accounts;
	}

	@Override
	public List<Entry> getEntries(Account account) 
	{
		
		Entry.Builder builder1 = new Entry.Builder().setAccountNumber(74747474).setAmount(new BigDecimal(2301)).setDate(LocalDateTime.of(2019, 8, 8, 2, 1))
				.setDescription("kattemad").setEntryID(282393812).setRegNumber(3493);
		Entry entry1 = builder1.build();
		
		Entry.Builder builder2 = new Entry.Builder().setAccountNumber(74747474).setAmount(new BigDecimal(50)).setDate(LocalDateTime.of(2019, 8, 12, 4, 23))
				.setDescription("Irma A/S").setEntryID(282393814).setRegNumber(3493);
		Entry entry2 = builder2.build();
		
		List<Entry> entries=new ArrayList<Entry>();
		entries.add(entry1);
		entries.add(entry2);
		return entries;
	}
	
	public Customer getCustomer(String customerID)
	{
		Customer.Builder builder1 = new Customer.Builder(1234, "14141").setFirstName("peter").setSurName("larsen").setAddress("lyngbye")
				.setCountry("danmark").setZipCode("1241").setCity("øde").setEmail("wutwut@hotmales.dk").setPhoneNumber("95919192");
		Customer customer1=builder1.build();
		
		return customer1;
	}

	@Override
	public void createNewTransfer(Transfer transfer) 
	{
		System.out.println("new transfer created :"+transfer.getFromAccount().getAccountName()+" "+transfer.getAmount().toString());
	}



	
}
