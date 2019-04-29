package dk.eamv.bank.javafx.viewModels;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import dk.eamv.bank.javafx.domain.Transfer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TransferModel 
{
	private StringProperty amount = new SimpleStringProperty();
	public final String getAmount() {return amount.get();}
	public final void setAmount(String value){amount.set(value);}
	public StringProperty amount(){return amount;}
	
	private StringProperty toAccountAccountNumber = new SimpleStringProperty();
	public final String getToAccountAccountNumber() {return toAccountAccountNumber.get();}
	public final void setToAccountAccountNumber(String value){toAccountAccountNumber.set(value);}
	public StringProperty toAccountAccountNumber(){return toAccountAccountNumber;}
	
	private StringProperty regNumber = new SimpleStringProperty();
	public final String getRegNumber() {return regNumber.get();}
	public final void setRegNumber(String value){regNumber.set(value);}
	public StringProperty regNumber(){return regNumber;}
	
	private StringProperty date = new SimpleStringProperty();
	public final String getDate() {return date.get();}
	public final void setDate(String value){date.set(value);}
	public StringProperty date(){return date;}
	
	private StringProperty fromDescription = new SimpleStringProperty();
	public final String getFromDescription() {return fromDescription.get();}
	public final void setFromDescription(String value){fromDescription.set(value);}
	public StringProperty fromDescription(){return fromDescription;}
	
	private StringProperty toDescription = new SimpleStringProperty();
	public final String getToDescription() {return toDescription.get();}
	public final void setToDescription(String value){toDescription.set(value);}
	public StringProperty toDescription(){return toDescription;}
	
	private AccountModel fromAccount;
	public final AccountModel getFromAccount() {return fromAccount;};
	public final void setFromAccount(AccountModel value) {fromAccount=value;};
	
	private CustomerModel currentCustomer;
	public final CustomerModel getCurrentCustomer() {return currentCustomer;};
	public final void setCurrentCustomer(CustomerModel value) {currentCustomer=value;};
	
	
	public static TransferModel domainToModel(Transfer transfer)
	{
		TransferModel transferModel =new TransferModel();
		
		transferModel.setAmount(""+transfer.getAmount().toString());
		transferModel.setToAccountAccountNumber(""+transfer.getToAccountAccountNumber());
		transferModel.setRegNumber(""+transfer.getRegNumber());
		transferModel.setDate(transfer.getDate().toString());
		transferModel.setFromDescription(transfer.getFromDescription());
		transferModel.setToDescription(transfer.getToDescription());
		transferModel.setFromAccount(AccountModel.domainToModel(transfer.getFromAccount()));
		transferModel.setCurrentCustomer(CustomerModel.domainToModel(transfer.getCurrentCustomer()));
		
		return transferModel;
	}
	
	public Transfer toDomain()
	{
		Transfer transfer = new Transfer();
		transfer.setAmount(new BigDecimal(getAmount()));
		transfer.setToAccountAccountNumber(Integer.parseInt(getToAccountAccountNumber()));
		transfer.setRegNumber(Integer.parseInt(getRegNumber()));
		transfer.setDate(LocalDateTime.parse(getDate()));
		transfer.setFromDescription(getFromDescription());
		transfer.setToDescription(getToDescription());
		transfer.setFromAccount(getFromAccount().toDomain());
		transfer.setCurrentCustomer(getCurrentCustomer().toDomain());
		
		return transfer;
	}
}
