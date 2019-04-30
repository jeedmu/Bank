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
	public void transferEntry(Transfer transferInfo) {
		
		int fromAccNum = transferInfo.getFromAccount().getAccountNumber();
		int fromRegNum = transferInfo.getFromAccount().getRegNumber();
		String fromDesc = transferInfo.getFromDescription();
		
		int toAccNum = transferInfo.getToAccountAccountNumber();
		int toRegNum = transferInfo.getRegNumber();
		String toDesc = transferInfo.getToDescription();
		
		LocalDateTime date = transferInfo.getDate();
		BigDecimal amount = transferInfo.getAmount();
		
		Entry fromEntry = new Entry.Builder()
				  .setAccountNumber(fromAccNum)
				  .setRegNumber(fromRegNum)
				  .setAmount(BigDecimal.ZERO.subtract(amount))
				  .setEntryID(0)
				  .setDate(date)
				  .setDescription(fromDesc)
				  .build();
		
		Entry toEntry = new Entry.Builder()
				  .setAccountNumber(toAccNum)
				  .setRegNumber(toRegNum)
				  .setAmount(amount)
				  .setEntryID(0)
				  .setDate(date)
				  .setDescription(toDesc)
				  .build();
		
		if(CheckIfTransferValid(transferInfo)) {
			if (accountsBelongToSameBank(fromAccNum, toAccNum, fromRegNum)) {
				fromEntry = fromEntry.setIsHandled(true);
				entryBean.create(fromEntry);
				entryBean.create(toEntry);
				
				updateBalance(fromEntry);
			}
			else if (ifForeignBankExsist(toEntry.getRegNumber())){
				Entry foreignBankEntry = new Entry.Builder()
												  .setAccountNumber(toEntry.getAccountNumber())
												  .setRegNumber(toEntry.getRegNumber())
												  .setAmount(toEntry.getAmount())
												  .setEntryID(0)
												  .setDate(LocalDateTime.now())
												  .setDescription(toEntry.getDescription())
												  .build();
			
				fromEntry = fromEntry.setIsHandled(true);
				entryBean.create(fromEntry);
				foreignEntryBean.create(foreignBankEntry);
		    
				updateBalance(fromEntry);
			}
		}
	}
	
	public boolean CheckIfTransferValid(Transfer transfer) {
		
		int fromAccNum = transfer.getFromAccount().getAccountNumber();
		int fromRegNum = transfer.getFromAccount().getRegNumber();
		int currAccID = transfer.getFromAccount().getCustomerID();
		BigDecimal amount = transfer.getAmount();
		
		int toAccNum = transfer.getToAccountAccountNumber();
		int toRegNum = transfer.getRegNumber();
		
		if (!accountExists(fromAccNum, fromRegNum) && !accountExists(toAccNum, toRegNum)) {
			return false;
		}
		
		if (!customerHasAccountRights(fromAccNum, currAccID, fromRegNum)) {
			return false;
		}
		
		if (!accountHasSufficientFunds(fromAccNum, amount, fromRegNum)) {
			return false;
		}
		
		return true;

	}

	/**
	 * Update balance in database
	 * @param entry the entry specifying the amount and the account
	 * @param add if true: add amount to account balance, if false: subtract amount from account balance
	 * @return true if succeeded, else false
	 */
	private boolean updateBalance(Entry entry) {
		
		Account account = accountBean.read(entry.getAccountNumber()).get();
		
		account.setBalance(account.getBalance().add(entry.getAmount()));
		
		accountBean.update(account);
		return true;
	}

	
	private boolean accountsBelongToSameBank(int fromAccountNo, int toAccountNo,int accountReg) {
		return accountBean.read(fromAccountNo).get().getRegNumber() == accountBean.read(toAccountNo).get()
				.getRegNumber();
	}

	private boolean customerHasAccountRights(int accountNo, int customerID,int accountReg) {
		return accountBean.read(accountNo).get().getCustomerID() == customerID;
	}

	private boolean accountHasSufficientFunds(int accountNo, BigDecimal amount, int accountReg) {
		Account account = new AccountBean().read(accountNo).get();
		return account.getBalance().compareTo(amount) != -1;
	}

	private boolean accountExists(int accountNo, int accountReg) {
		return accountBean.read(accountNo).isPresent();
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
