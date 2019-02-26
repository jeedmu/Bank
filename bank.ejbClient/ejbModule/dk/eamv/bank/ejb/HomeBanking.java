package dk.eamv.bank.ejb;

import java.util.ArrayList;

import javax.ejb.Local;

import dk.eamv.bank.domain.*;

@Local
// TODO METHODS SHOULDN'T RETURN VOID!!
public interface HomeBanking {

	/**
	 * shows all accounts belonging to current customer
	 * @param customerNo The number specifying which customer's account to show
	 */
	public ArrayList<Account> showAccounts(String customerNo);

	/**
	 * Create a new entry... entry contains account numbers and monetary amount
	 * @param entry Specify the entry to create
	 * @return true if it succeded, else false
	 */
	public boolean createEntry(Entry entry);
	
	/**
	 * Show all entries belonging to specified account
	 * @param accountNo The account number specifying which account's entries to show
	 */
	public ArrayList<Entry> showEntries(String accountNo);
}
