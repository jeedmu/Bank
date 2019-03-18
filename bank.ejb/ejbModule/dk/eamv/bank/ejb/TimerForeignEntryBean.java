package dk.eamv.bank.ejb;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

import dk.eamv.bank.ejb.ws.ForeignEntryNetsBean;
import dk.eamv.bank.ejb.ws.ForeignEntryNetsBeanService;

@Stateless
public class TimerForeignEntryBean {

	@Schedule(minute="*/1", hour="*")
	public void callWebService()
	{
        System.out.println("***********************");
        System.out.println("Create Web Service Client...");
        ForeignEntryNetsBeanService service1 = new ForeignEntryNetsBeanService();
        System.out.println("Create Web Service...");
        ForeignEntryNetsBean port1 = service1.getForeignEntryNetsBeanPort();
        System.out.println("Call Web Service Operation...");
        System.out.println("Server said: " + port1.createNetsRequest(null));
        //Please input the parameters instead of 'null' for the upper method!

        System.out.println("Create Web Service...");
        ForeignEntryNetsBean port2 = service1.getForeignEntryNetsBeanPort();
        System.out.println("Call Web Service Operation...");
        System.out.println("Server said: " + port2.createNetsRequest(null));
        //Please input the parameters instead of 'null' for the upper method!

        System.out.println("***********************");
        System.out.println("Call Over!");		
	}
}
