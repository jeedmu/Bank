package dk.eamv.bank.ejb;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Customer;
import dk.eamv.bank.ejb.ws.ForeignEntryNetsBean;
import dk.eamv.bank.ejb.ws.ForeignEntryNetsBeanService;

@Stateless
public class TimerForeignEntryBean {

	@EJB Employee e;
	
	int counter = 2424;
	
	@Schedule(minute="*/1", hour="*")
	public void callWebService()
	{
		Customer a = e.createCustomer(new Customer.Builder(0, counter++ + "").setAddress("").setCity("").setEmail("").setFirstName("").setSurName("").setZipCode("").setPhoneNumber("").setCountry("").build());
		Customer b = e.createCustomer(new Customer.Builder(0, counter++ + "").setAddress("").setCity("").setEmail("").setFirstName("").setSurName("").setZipCode("").setPhoneNumber("").setCountry("").build());
		Account account = new Account.Builder(a.getCustomerID(),0,0).setAccountName("asd").build();
		e.createAccount(account);
		account = new Account.Builder(b.getCustomerID(),24,24).setAccountName("asd23").build();
		e.createAccount(account);
		/*
        System.out.println("***********************");
        System.out.println("Create Web Service Client...");
        ForeignEntryNetsBeanService service1 = new ForeignEntryNetsBeanService();
        System.out.println("Create Web Service...");
        ForeignEntryNetsBean port1 = service1.getForeignEntryNetsBeanPort();
        System.out.println("Call Web Service Operation...");
        System.out.println("Server said: " + port1.createNetsRequest(null));
        //Please input the parameters instead of 'null' for the upper method!
        
        /*
        System.out.println("Create Web Service...");
        ForeignEntryNetsBean port2 = service1.getForeignEntryNetsBeanPort();
        System.out.println("Call Web Service Operation...");
        System.out.println("Server said: " + port2.createNetsRequest(null));
        */
        
        //Please input the parameters instead of 'null' for the upper method!

        System.out.println("***********************");
        System.out.println("Call Over!");		
	}
}
