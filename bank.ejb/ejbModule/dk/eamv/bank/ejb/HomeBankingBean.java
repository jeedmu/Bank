package dk.eamv.bank.ejb;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dk.eamv.bank.domain.*;
import dk.eamv.bank.ejb.entitybeans.*;
import dk.eamv.bank.ejb.exception.CustomerNotFoundException;
import dk.eamv.bank.ejb.exception.EntryAlreadyExsistsException;

/**
 * Session Bean implementation class HomeBankingBean
 */
@Stateless
public class HomeBankingBean implements HomeBanking {

	@EJB private AccountBean accountBean;
	@EJB private EntryBean entryBean;
	@EJB private BankBean bankBean;
	@EJB private ForeignEntryBean foreignEntryBean;
	@EJB private CustomerBean customerBean;

	public HomeBankingBean() {}

	@Override
	public ArrayList<Account> showAccounts(int customerID) {

		ArrayList<Account> accounts = new ArrayList<Account>();
		
		accounts.addAll(accountBean.list(customerID));

		return accounts;
	}

	@Override
	public List<Entry> showEntries(int accountNo, int noOfDays,int regNumber) {
		
		return entryBean.list(accountNo,regNumber);
	}

	@Override
	public boolean transferEntry(Transfer transferInfo) {
				
		Entry fromEntry = new Entry.Builder()
				  .setAccountNumber(transferInfo.getFromAccount().getAccountNumber())
				  .setRegNumber(transferInfo.getRegNumber())
				  .setAmount(transferInfo.getAmount())
				  .setEntryID(0)
				  .setDate(transferInfo.getDate())
				  .setDescription(transferInfo.getFromDescription())
				  .build();
		
		Entry toEntry = new Entry.Builder()
				  .setAccountNumber(transferInfo.getToAccount().getAccountNumber())
				  .setRegNumber(transferInfo.getRegNumber())
				  .setAmount(transferInfo.getAmount())
				  .setEntryID(0)
				  .setDate(transferInfo.getDate())
				  .setDescription(transferInfo.getToDescription())
				  .build();
		
		if (accountsBelongToSameBank(fromEntry.getAccountNumber(), toEntry.getAccountNumber(),fromEntry.getRegNumber())) {
			if (accountExists(fromEntry.getAccountNumber(), fromEntry.getRegNumber()) && accountExists(toEntry.getAccountNumber(), fromEntry.getRegNumber())) {
				if (customerHasAccountRights(fromEntry.getAccountNumber(), transferInfo.getCurrentCustomer().getCustomerID(), fromEntry.getRegNumber())) {
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
			if(accountExists(fromEntry.getAccountNumber(),fromEntry.getRegNumber()) && ifForeignBankExsist(toEntry.getRegNumber())) {
				if(customerHasAccountRights(fromEntry.getAccountNumber(), transferInfo.getCurrentCustomer().getCustomerID(),fromEntry.getRegNumber())){
					if(accountHasSufficientFunds(fromEntry.getAccountNumber(),fromEntry.getAmount(),fromEntry.getRegNumber())){
						
						Entry foreignBankEntry = new Entry.Builder()
														  .setAccountNumber(toEntry.getAccountNumber())
														  .setRegNumber(toEntry.getRegNumber())
														  .setAmount(toEntry.getAmount())
														  .setEntryID(0)
														  .setDate(LocalDateTime.now())
														  .setDescription(toEntry.getDescription())
														  .build();
						
						
					try {	
					
				    entryBean.create(fromEntry);
				    entryBean.create(foreignBankEntry);
				    foreignEntryBean.create(toEntry);
				    return true;
				    }
					catch (EntryAlreadyExsistsException e) {
						e.printStackTrace();
					}
					updateBalance(fromEntry, false);
					updateBalance(foreignBankEntry,true);
					
				    
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
	
	private boolean ifForeignBankExsist(int regNumber) {
		return bankBean.read(regNumber).isPresent();
	}
	
	private int getforeignAccount(int regNumber) {
		 Bank entity= bankBean.read(regNumber).get();
		 return entity.getAccountNumber();
		 
	}

	@Override
	public Customer readCustomer(String ssn) {
		CustomerSearchParameters param = new CustomerSearchParameters();
		param.setSSN(ssn);
		
		List<Customer> result = customerBean.getCustomers(param);
		
		if (result.size()>0)
			return result.get(0);
		else
			throw new CustomerNotFoundException();
	}

	
}
