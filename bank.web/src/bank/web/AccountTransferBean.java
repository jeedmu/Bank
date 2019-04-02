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
	 private int kontonummer;
	 private Date selectedDate;
	 private String inmessage;
	 private String outmessage;
	 
	 //lav getters og setters. Set vaedierne i felterne og send videre i metode (submit). 
	 //getters and setters
	 public String getAccount() {
		 return account;
	 }
	 public void setAccount(String acc) {
		 account = acc;
	 }
	 
	public Map<String, Account> getAccounts()
	{
	    Map<String,Account> accounts;
		   accounts  = new HashMap<String, Account>();
	        accounts.put("opsparing",opsparing );
	        accounts.put("ferie",ferie );
	        
	        return accounts;
		//return homeBanking.showAccounts("");
	}
	
	
	public int getKontonummer() {
		return kontonummer;
	}
	public void setKontonummer(int kontnummer){
		kontonummer = kontnummer;
	}
	
	public Date getDate() {
		return selectedDate;
	}
	public void setDate(Date date) {
		selectedDate = date;
	}
	
	public String getInmessage() {
		return inmessage;
	}
	public void setInmessage(String message) {
		inmessage = message;
	}
	public String getOutmessage() {
		return outmessage;
	}
	public void setOutmessage(String message) {
		outmessage = message;
	}
	
	public void setNewEntry() {
		
	}
	
	public void buttonaction() {
	
}
	
	
}
