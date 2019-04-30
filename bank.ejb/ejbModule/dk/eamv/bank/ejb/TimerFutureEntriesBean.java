package dk.eamv.bank.ejb;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Customer;
import dk.eamv.bank.domain.Entry;
import dk.eamv.bank.ejb.entitybeans.AccountBean;
import dk.eamv.bank.ejb.entitybeans.EntryBean;

@Stateless
public class TimerFutureEntriesBean {

	@EJB EntryBean entryBean;
	@EJB AccountBean accountBean;

	@EJB Employee e;
	
	int counter = 2424;
	
	// TODO change to once every hour?
	@Schedule(minute="*/1", hour="*")
	public void handleEntries()
	{
		Customer a = e.createCustomer(new Customer.Builder(0, counter++ + "").setAddress("").setCity("").setEmail("").setFirstName("").setSurName("").setZipCode("").setPhoneNumber("").setCountry("").build());
		Customer b = e.createCustomer(new Customer.Builder(0, counter++ + "").setAddress("").setCity("").setEmail("").setFirstName("").setSurName("").setZipCode("").setPhoneNumber("").setCountry("").build());
		Account account = new Account.Builder(a.getCustomerID(),0,0).setBalance(BigDecimal.ONE).setAccountName("asd").build();
		int accountID = e.createAccount(account).getAccountNumber();
		
		
		Entry entry = new Entry.Builder().setDate(LocalDateTime.now()).setAmount(BigDecimal.TEN).setDescription("").setAccountNumber(accountID).build();
		entryBean.create(entry);
		Entry entry2 = new Entry.Builder().setDate(LocalDateTime.now().plusDays(1)).setAmount(BigDecimal.TEN).setDescription("").setAccountNumber(accountID).build();
		entryBean.create(entry2);
		Entry entry3 = new Entry.Builder().setDescription("asd").setDate(LocalDateTime.now().minusDays(1)).setAmount(BigDecimal.TEN).setAccountNumber(accountID).build();
		entryBean.create(entry3);
		
		System.out.println(entryBean.getUpcomingUnhandledEntries().size());
		
		System.out.println("BD: "+BigDecimal.TEN.add(BigDecimal.TEN).toPlainString());
		
		for(Entry en : entryBean.getUpcomingUnhandledEntries())
		{
			updateBalance(en);
			entryBean.update(en.setIsHandled(true));
		}
		
	}
	
	private boolean updateBalance(Entry entry) 
	{	
		Account account = accountBean.read(entry.getAccountNumber()).get();
		
		account = account.setBalance(account.getBalance().add(entry.getAmount()));
		
		accountBean.update(account);
		return true;
	}
}