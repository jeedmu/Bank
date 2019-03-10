package dk.eamv.bank.ejb;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class TimerForeignEntryBean {

	@Schedule(minute="*/5", hour="*")
	public void callWebService()
	{
		System.out.println("Calling WebService... /Not implemented yet");
	}
}
