package dk.eamv.bank.ejb;

import java.util.ArrayList;

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
        // TODO Auto-generated constructor stub
    }

	@Override
	public ArrayList<Account> showAccounts(String customerNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createEntry(Entry entry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Entry> showEntries(String accountNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
