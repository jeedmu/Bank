package dk.eamv.bank.ejb;

import javax.ejb.Local;

@Local
// TODO METHODS SHOULDN'T RETURN VOID!!
public interface HomeBanking {

	/**
	 * shows all accounts belonging to current customer
	 * @param customerNo The number specifying which customer's account to show
	 */
	public void showAccounts(String customerNo);

	// TODO this method should probably not take a string parameter...?
	/**
	 * Create a new entry... entry contains account numbers and monetary amount
	 * @param entry Specify the entry to create
	 * @return true if it succeded, else false
	 */
	public boolean createEntry(String entry);
	
	/**
	 * Show all entries belonging to specified account
	 * @param accountNo The account number specifying which account's entries to show
	 */
	public void showEntries(String accountNo);
}
