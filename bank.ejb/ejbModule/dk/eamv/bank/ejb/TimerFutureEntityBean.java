package dk.eamv.bank.ejb;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import dk.eamv.bank.ejb.entitybeans.EntryBean;

@Stateless
public class TimerFutureEntityBean {

	@EJB EntryBean e;
	
	@Schedule(minute="*/1", hour="*")
	public void handleEntries()
	{
		
	}
}
