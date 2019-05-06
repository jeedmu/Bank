package dk.eamv.bank.homebanking;

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
import dk.eamv.bank.domain.Transfer;
import dk.eamv.bank.ejb.HomeBanking;


@Named
@RequestScoped
public class AccountTransferBean implements Serializable {

	@EJB private HomeBanking homebank;
	
	private static final long serialVersionUID = 1L;

	Account opsparing = new Account.Builder(25,9108,24242424).setBalance(BigDecimal.ZERO).setAccountName("Opsparing").build();
	Account ferie = new Account.Builder(11,2201, 894891981).setBalance(BigDecimal.ONE).setAccountName("Ferie").build();
	 private String account;
	 private String kontonummer;
	 private LocalDateTime selectedDate;
	 private String inmessage;
	 private String outmessage;
	 private BigDecimal amount; 
	 private String regNummer;
	 private Map<String, Account> accountmap;
	 
	 
	 private int changenumber(String input) {
		 int result = Integer.parseInt(input);
		 return result;
	 }

	 public void sendData() {
		Transfer transfer = new Transfer();
		/*
		transfer.setAmount(this.amount);
		transfer.setRegNumber(changenumber(this.regNummer));
		transfer.setFromDescription(this.inmessage);
		transfer.setToDescription(this.outmessage);
		transfer.setFromAccount(accountmap.get(account));
		transfer.setToAccountAccountNumber(changenumber(this.kontonummer));
		*/
		}

	 public String getAccount() {
		 return account;
	 }
	 public void setAccount(String acc) {
		 account = acc;
	 }
	 
	 //Denne metode mangler noget fra databasen vi ikke kan give på nuværende tidspunkt.
	public Map<String, Account> getAccounts()
	{
	    Map<String,Account> accounts;
		   accounts  = new HashMap<String, Account>();
	        accounts.put("opsparing",opsparing );
	        accounts.put("ferie",ferie );
	        accountmap = accounts;
	        return accountmap;
	}
	
	
	public String getKontonummer() {
		return kontonummer;
	}
	public void setKontonummer(String kontnummer){
		kontonummer = kontnummer;
	}
	public LocalDateTime getDate() {
		return selectedDate;
	}
	public void setDate(LocalDateTime date) {
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
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getRegNummer() {
		return regNummer;
	}
	public void setRegNummer(String regNummer) {
		this.regNummer = regNummer;
	}
}
