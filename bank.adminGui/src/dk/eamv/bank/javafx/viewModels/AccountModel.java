package dk.eamv.bank.javafx.viewModels;

import java.math.BigDecimal;

import dk.eamv.bank.javafx.domain.Account;
import dk.eamv.bank.javafx.domain.Account.Builder;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AccountModel 
{	
	private StringProperty customerID = new SimpleStringProperty();
	public final String getCustomerID() {return customerID.get();}
	public final void setCustomerID(String value){customerID.set(value);}
	public StringProperty customerID(){return customerID;}
	
	private StringProperty regNumber = new SimpleStringProperty();
	public final String getRegNumber() {return regNumber.get();}
	public final void setRegNumber(String value){regNumber.set(value);}
	public StringProperty regNumber(){return regNumber;}
	
	private StringProperty accountNumber = new SimpleStringProperty();
	public final String getAccountNumber() {return accountNumber.get();}
	public final void setAccountNumber(String value){accountNumber.set(value);}
	public StringProperty accountNumber(){return accountNumber;}
	
	private StringProperty accountName = new SimpleStringProperty();
	public final String getAccountName() {return accountName.get();}
	public final void setAccountName(String value){accountName.set(value);}
	public StringProperty accountName(){return accountName;}
	
	private StringProperty balance = new SimpleStringProperty();
	public final String getBalance() {return balance.get();}
	public final void setBalance(String value){balance.set(value);}
	public StringProperty balance(){return balance;}
	
	public static AccountModel domainToModel(Account account)
	{
		AccountModel accountModel =new AccountModel();
		
		accountModel.setCustomerID(""+account.getCustomerID());
		accountModel.setRegNumber(""+account.getRegNumber());
		accountModel.setAccountNumber(""+account.getAccountNumber());
		accountModel.setAccountName(account.getAccountName());
		accountModel.setBalance(""+account.getBalance());
		
		return accountModel;
	}
	
	public Account toDomain()
	{
		Account.Builder builder = new Builder(Integer.parseInt(getCustomerID()), Integer.parseInt(getRegNumber()), Integer.parseInt(getAccountNumber()))
				.setAccountName(getAccountName()).setBalance(new BigDecimal(getBalance()));
		Account account = builder.build();
		
		return account;
	}
	
	public String getFullAccountRegNumber()
	{
		return getRegNumber()+"-"+getAccountNumber();
	}
}
