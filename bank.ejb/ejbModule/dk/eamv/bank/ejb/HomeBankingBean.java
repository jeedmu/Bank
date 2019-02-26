package dk.eamv.bank.ejb;

import java.util.ArrayList;

import javax.ejb.Stateless;

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
	public void showAccounts(String customerNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean createEntry(String entry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void showEntries(String accountNo) {
		// TODO Auto-generated method stub
		
	}

}
