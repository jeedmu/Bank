package dk.eamv.bank.ejb;

import java.util.List;
import javax.ejb.Local;
import dk.eamv.bank.domain.*;

@Local
public interface HomeBanking {
public Customer readCustomer(String cprn);

	public List<Account> showAccounts(int customerID);

	public boolean transferEntry(Transfer transferInfo);
	
	public List<Entry> showEntries(int accountNo, int noOfDays,int regNumber);
}
