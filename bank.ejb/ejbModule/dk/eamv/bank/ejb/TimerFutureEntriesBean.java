package dk.eamv.bank.ejb;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import dk.eamv.bank.constants.Constants;
import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Entry;
import dk.eamv.bank.ejb.entitybeans.AccountBean;
import dk.eamv.bank.ejb.entitybeans.EntryBean;

@Stateless
@RunAs(Constants.employeeRole)
public class TimerFutureEntriesBean {

	@EJB EntryBean entryBean;
	@EJB AccountBean accountBean;

	// TODO change to once every hour?
	@Schedule(minute="*/1", hour="*")
	public void handleEntries()
	{
		for(Entry en : entryBean.getUpcomingUnhandledEntries()) {
			try 
			{
				updateBalance(en);
				entryBean.update(en.setIsHandled(true));
			}
			catch(Exception e)
			{
				//
			}
		}
	}
	
	private boolean updateBalance(Entry entry) 
	{	
		try 
		{
			Account account = accountBean.read(entry.getAccountNumber()).get();
			account = account.setBalance(account.getBalance().add(entry.getAmount()));
			accountBean.update(account);
			return true;
		} 
		catch(Exception e)
		{
			return false;
		}
	}
}