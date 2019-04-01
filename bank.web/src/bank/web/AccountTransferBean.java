package bank.web;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Entry;

@Named
@RequestScoped
public class AccountTransferBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Account opsparing = new Account.Builder(25,9108,24242424).setBalance(BigDecimal.ZERO).setAccountName("Opsparing").build();
	Account ferie = new Account.Builder(11,2201, 894891981).setBalance(BigDecimal.ONE).setAccountName("Ferie").build();
	 private String account;  
	 
	 //lav getters og setters. Set vaedierne i felterne og send videre i metode (submit). 
	 
	 public String getAccount() {
		 return account;
	 }

	public Map<String, Account> getAccounts()
	{
//		ArrayList<Account> ac = new ArrayList<Account>();
//		ac.add(new Account.Builder(25,9108,24242424).setBalance(BigDecimal.ZERO).setAccountName("Opsparing").build());
//		ac.add(new Account.Builder(11,2201, 894891981).setBalance(BigDecimal.ONE).setAccountName("Ferie").build());
//		ac.add(new Account.Builder(34,3487, 348584598).setBalance(BigDecimal.TEN.multiply(BigDecimal.TEN).multiply(BigDecimal.TEN).multiply(BigDecimal.TEN)).setAccountName("Kort").build());
//		return ac;

	    Map<String,Account> accounts;
		   accounts  = new HashMap<String, Account>();
	        accounts.put("opsparing",opsparing );
	        accounts.put("ferie",ferie );
	        
	        return accounts;
		//return homeBanking.showAccounts("");
	}
	
	
	public void setNewEntry() {
		
	}
	
	//calendar opsætning
	 private List<Date> invalidDates;
	    private List<Integer> invalidDays;
	    private Date minDate;
	    private Date maxDate;
	   
	 public void init() {
	        invalidDates = new ArrayList<>();
	        Date today = new Date();
	        invalidDates.add(today);
	        long oneDay = 24 * 60 * 60 * 1000;
	        for (int i = 0; i < 5; i++) {
	            invalidDates.add(new Date(invalidDates.get(i).getTime() + oneDay));
	        }
	 
	        invalidDays = new ArrayList<>();
	        invalidDays.add(0); /* the first day of week is disabled */
	        invalidDays.add(3);
	 
	        minDate = new Date(today.getTime() - (365 * oneDay));
	        maxDate = new Date(today.getTime() + (365 * oneDay));
	    }
	 
	
}
