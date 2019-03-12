package dk.eamv.bank.ejb.ws.clientsample;

import dk.eamv.bank.ejb.ws.*;

public class ClientSample {

	public static void main(String[] args) {
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
