package dk.eamv.bank.ejb;

import java.util.ArrayList;

import javax.ejb.Local;

@Local
// TODO METHODS SHOULDN'T RETURN VOID!!
public interface HomeBanking {

	/* shows all accounts belonging to current customer */
	public void showAccounts(String customerNo);

	/* create a new entry... entry contains account numbers and monetary amount */
	public boolean createEntry(String entry);

	/* Show all entries belonging to specfied account number */
	public void showEntries(String accountNo);
}
