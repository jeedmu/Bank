package dk.eamv.bank.ejb;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Entry;
import dk.eamv.bank.ejb.entitybeans.AccountBean;
import dk.eamv.bank.ejb.entitybeans.EntryBean;
import dk.eamv.bank.ejb.exception.EntryAlreadyExsistsException;

/**
 * Session Bean implementation class HomeBankingBean
 */
@Stateless
public class HomeBankingBean implements HomeBanking {

	private AccountBean accountBean = new AccountBean();
	private EntryBean entryBean = new EntryBean();
	
	
    /**
     * Default constructor. 
     */
    public HomeBankingBean() {
    }

	@Override
	public ArrayList<Account> showAccounts(int customerID) {
		 
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		
		// test implementation
		accounts.add(new Account.Builder(0, 0, 0).Build());
		accounts.add(new Account.Builder(1, 1, 1).Build());
		accounts.add(new Account.Builder(2, 2, 2).Build());
		
		
		/* actual implementation
		accounts.addAll(accountBean.list(customerID));
		*/
		
		return accounts;
	}

	@Override
	public List<Entry> showEntries(int accountNo, int noOfDays) {
		//TODO skal søge på noOfDays
		return entryBean.list(accountNo);
	}

	@Override
	public boolean createEntry(HashMap<String, String> mappedEntry, int customerID) {
		// TODO skal tage højde for fremmed bank
		ArrayList<Entry> fromAndToAccount = translateHashmapIntoEntries(mappedEntry);
		Entry fromAccount = fromAndToAccount.get(1);
		Entry toAccount = fromAndToAccount.get(2);
		
		if (accountExists(fromAccount.getAccountNumber()) && accountExists(toAccount.getAccountNumber())) {
			if (customerHasAccountRights(fromAccount.getAccountNumber(), customerID)) {
				if (accountHasSufficientFunds(fromAccount.getAccountNumber(), fromAccount.getAmount())) {
					try {
						entryBean.create(fromAccount);
						entryBean.create(toAccount);
						return true;
					} catch(EntryAlreadyExsistsException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return false;
	}
	
	private boolean customerHasAccountRights(int accountNo, int customerID) {
		return accountBean.read(accountNo).get().getCustomerID() == customerID;
	}
	
	private boolean accountHasSufficientFunds (int accountNo, BigDecimal amount) {
		Account account = new AccountBean().read(accountNo).get();
		return account.getBalance().compareTo(amount) != -1;
	}
	
	private boolean accountExists(int accountNo) {
		return accountBean.read(accountNo).isPresent();
	}
	
	private ArrayList<Entry> translateHashmapIntoEntries(HashMap<String, String> mappedEntry){
		ArrayList<Entry> list = new ArrayList<Entry>();
		
		Entry fromEntry = new Entry.Builder(0, 
											LocalDateTime.now(), 
											new BigDecimal(mappedEntry.get("amount")), 
											Integer.parseInt(mappedEntry.get("fromAccount"))
											)
									.setDescription(mappedEntry.get("fromDescription"))
									.Build();
		
		Entry toEntry = new Entry.Builder(0, 
										  LocalDateTime.now(), 
										  new BigDecimal(mappedEntry.get("amount")), 
										  Integer.parseInt(mappedEntry.get("toAccount"))
										  )
								 .setDescription(mappedEntry.get("toDescription"))
								 .Build();
		
		list.add(fromEntry);
		list.add(toEntry);
		
		return list;
	}
}
