package dk.eamv.bank.ejb;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;
import javax.security.auth.login.AccountNotFoundException;

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

		/*
		 * actual implementation accounts.addAll(accountBean.list(customerID));
		 */

		return accounts;
	}

	@Override
	public List<Entry> showEntries(int accountNo, int noOfDays) {
		
		return entryBean.list(accountNo);
	}

	@Override
	public boolean createEntry(HashMap<String, String> mappedEntry, int customerID) {
		// TODO skal tage højde for fremmed bank
		ArrayList<Entry> fromAndToAccount = translateHashmapIntoEntries(mappedEntry);
		
		Entry fromEntry = fromAndToAccount.get(1);
		Entry toEntry = fromAndToAccount.get(2);
		
		if (accountsBelongToSameBank(fromEntry.getAccountNumber(), toEntry.getAccountNumber(),fromEntry.getRegNumber())) {
			if (accountExists(fromEntry.getAccountNumber(), fromEntry.getRegNumber()) && accountExists(toEntry.getAccountNumber(), fromEntry.getRegNumber())) {
				if (customerHasAccountRights(fromEntry.getAccountNumber(), customerID,fromEntry.getRegNumber())) {
					if (accountHasSufficientFunds(fromEntry.getAccountNumber(), fromEntry.getAmount(),fromEntry.getRegNumber())) {
						try {
							// create entries in database
							entryBean.create(fromEntry);
							entryBean.create(toEntry);
							return true;
						} catch (EntryAlreadyExsistsException e) {
							e.printStackTrace();
						}
						
						updateBalance(fromEntry, false);
						updateBalance(toEntry, true);
					
					}
				}
			}
		}
		else
			if(accountExists(fromEntry.getAccountNumber(),fromEntry.getRegNumber()) && accountExists(toEntry.getAccountNumber(),fromEntry.getRegNumber())) {
				if(customerHasAccountRights(fromEntry.getAccountNumber(), customerID,fromEntry.getRegNumber())){
					if(accountHasSufficientFunds(fromEntry.getAccountNumber(),fromEntry.getAmount(),fromEntry.getRegNumber())){
				    
					}
				}
			}
		return false;
	}

	/**
	 * Update balance in database
	 * @param entry the entry specifying the amount and the account
	 * @param add if true: add amount to account balance, if false: subtract amount from account balance
	 * @return true if succeeded, else false
	 */
	private boolean updateBalance(Entry entry, boolean add) {
		
		
		Account account = accountBean.read(entry.getRegNumber(),entry.getAccountNumber()).get();
		
		if (add)
			account.setBalance(account.getBalance().add(entry.getAmount()));
		else 
			account.setBalance(account.getBalance().subtract(entry.getAmount()));
		
		accountBean.update(account);
		return true;
		
		
	}
	
	private boolean accountsBelongToSameBank(int fromAccountNo, int toAccountNo,int accountReg) {
		return accountBean.read(accountReg,fromAccountNo).get().getRegNumber() == accountBean.read(accountReg,toAccountNo).get()
				.getRegNumber();
	}

	private boolean customerHasAccountRights(int accountNo, int customerID,int accountReg) {
		return accountBean.read(accountReg,accountNo).get().getCustomerID() == customerID;
	}

	private boolean accountHasSufficientFunds(int accountNo, BigDecimal amount, int accountReg) {
		Account account = new AccountBean().read(accountReg,accountNo).get();
		return account.getBalance().compareTo(amount) != -1;
	}

	private boolean accountExists(int accountNo, int accountReg) {
		return accountBean.read(accountReg,accountNo).isPresent();
	}

	private ArrayList<Entry> translateHashmapIntoEntries(HashMap<String, String> mappedEntry) {
		ArrayList<Entry> list = new ArrayList<Entry>();

		Entry fromEntry = new Entry.Builder(0, LocalDateTime.now(), new BigDecimal(mappedEntry.get("amount")),
				Integer.parseInt(mappedEntry.get("fromAccount")), 0).setDescription(mappedEntry.get("fromDescription"))
						.Build();

		Entry toEntry = new Entry.Builder(0, LocalDateTime.now(), new BigDecimal(mappedEntry.get("amount")),
				Integer.parseInt(mappedEntry.get("toAccount")), 0).setDescription(mappedEntry.get("toDescription"))
						.Build();

		list.add(fromEntry);
		list.add(toEntry);

		return list;
	}
}
