package dk.eamv.bank.ejb;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Customer;
import dk.eamv.bank.ejb.entitybeans.FutureEntryBean;
import dk.eamv.bank.ejb.ws.ForeignEntryNetsBean;
import dk.eamv.bank.ejb.ws.ForeignEntryNetsBeanService;

@Stateless
public class TimerFutureEntityBean {

	@EJB FutureEntryBean e;
	String name;
	
	@Schedule(minute="*/1", hour="*")
	public void handleEntries()
	{
		
	}
}
