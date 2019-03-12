package dk.eamv.bank.ejb;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;
import dk.eamv.bank.domain.*;

@Local
public interface HomeBanking {

	/**
	 * shows all accounts belonging to current customer
	 * @param customerNo The number specifying which customer's account to show
	 */
	public List<Account> showAccounts(int customerID);

	/**
	 * Create a new entry... entry contains account numbers and monetary amount
	 * @param mappedEntry mapping keys: "amount", "fromAccount", "toAccount", "fromDescription", "toDescription"
	 * @param customerID identifies the current customer
	 * @return true if it succeded, else false
	 */
	public boolean createEntry(HashMap<String, String> mappedEntry, int customerID);
	
	/**
	 * Show all entries belonging to specified account
	 * @param accountNo The account number specifying which account's entries to show
	 */
	public List<Entry> showEntries(int accountNo, int noOfDays,int regNumber);
}
