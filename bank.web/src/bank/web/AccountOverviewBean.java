package bank.web;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.ejb.HomeBanking;

@Named
@RequestScoped
public class AccountOverviewBean implements Serializable{

	@EJB private HomeBanking homeBanking;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Account> getAccounts()
	{
		ArrayList<Account> ac = new ArrayList<Account>();
		ac.add(new Account.Builder(25,9108,24242424).setBalance(BigDecimal.ZERO).setAccountName("Niels").Build());
		ac.add(new Account.Builder(11,2201, 894891981).setBalance(BigDecimal.ONE).setAccountName("Ole").Build());
		ac.add(new Account.Builder(34,3487, 348584598).setBalance(BigDecimal.TEN).setAccountName("Peter").Build());
		return ac;
		//return homeBanking.showAccounts("");
	}
}