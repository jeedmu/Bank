package dk.eamv.bank.ejb;
import java.util.List;
import javax.ejb.Local;
import dk.eamv.bank.domain.*;

@Local
public interface HomeBanking {

	/**
	 * shows all accounts belonging to current customer
	 * @param customerNo The number specifying which customer's account to show
	 */
	public List<Account> showAccounts(String customerNo);

	/**
	 * Create a new entry... entry contains account numbers and monetary amount
	 * @param to The account to which the amount will be transferred
	 * @param from The account from which the amount will be drawn
	 * @return true if it succeded, else false
	 */
	public boolean createEntry(Entry to, Entry from);
	
	/**
	 * Show all entries belonging to specified account
	 * @param accountNo The account number specifying which account's entries to show
	 */
	public List<Entry> showEntries(String accountNo);
}
