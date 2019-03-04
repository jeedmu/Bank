package dk.eamv.bank.ejb;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Entry;

/**
 * Session Bean implementation class HomeBankingBean
 */
@Stateless
public class HomeBankingBean implements HomeBanking {

    /**
     * Default constructor. 
     */
    public HomeBankingBean() {
    }

	@Override
	public ArrayList<Account> showAccounts(String customerNo) {
		 // test implementation
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account.Builder(0, 0, 0).Build());
		accounts.add(new Account.Builder(1, 1, 1).Build());
		accounts.add(new Account.Builder(2, 2, 2).Build());
		
		return accounts;
	}

	@Override
	public ArrayList<Entry> showEntries(String accountNo, int noOfDays) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createEntry(HashMap<String, String> mappedEntry) {
		
		ArrayList<Entry> list = translateIntoEntries(mappedEntry);
		
		
		// TODO
		
		return false;
	}
	
	private boolean accountHasSufficientFunds (int accountNo) {
		// TODO
		return true;
	}
	
	private boolean accountExists(int accountNo) {
		// TODO
		return true;
	}
	
	private ArrayList<Entry> translateIntoEntries(HashMap<String, String> mappedEntry){
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
