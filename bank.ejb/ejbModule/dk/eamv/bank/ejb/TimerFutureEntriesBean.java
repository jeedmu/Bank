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
		Account account = new Account.Builder(a.getCustomerID(),0,0).setBalance(BigDecimal.TEN).setAccountName("asd").build();
		int accountID = e.createAccount(account).getAccountNumber();
		
		
		Entry entry = new Entry.Builder().setDate(LocalDateTime.now()).setAmount(BigDecimal.TEN).setDescription("").setAccountNumber(accountID).build();
		entryBean.create(entry);
		Entry entry2 = new Entry.Builder().setDate(LocalDateTime.now().plusDays(1)).setAmount(BigDecimal.TEN).setDescription("").setAccountNumber(accountID).build();
		entryBean.create(entry2);
		Entry entry3 = new Entry.Builder().setDescription("asd").setDate(LocalDateTime.now().minusDays(1)).setAmount(BigDecimal.TEN).setAccountNumber(accountID).build();
		entryBean.create(entry3);
		
		System.out.println(entryBean.list2().size());
		
		for(Entry en : entryBean.list2())
		{
			updateBalance(en);
			entryBean.update(en.setIsHandled(true));
		}
	}
	
	private boolean updateBalance(Entry entry) {
		System.out.println(entry.getAccountNumber());
		Account account = accountBean.read(entry.getAccountNumber()).get();
		
		System.out.println("bal before: "+account.getBalance().toPlainString());
		System.out.println("Entry: "+entry.getAmount().toPlainString());
		account.setBalance(BigDecimal.ONE);
		System.out.println("bal: "+account.getBalance().toPlainString());
		accountBean.update(account);
		return true;
	}
}