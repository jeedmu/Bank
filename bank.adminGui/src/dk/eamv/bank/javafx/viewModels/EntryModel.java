package dk.eamv.bank.javafx.viewModels;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.xml.bind.ParseConversionEvent;

import dk.eamv.bank.javafx.domain.Entry;
import dk.eamv.bank.javafx.domain.Entry.Builder;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EntryModel 
{
	private StringProperty entryID = new SimpleStringProperty();
	public final String getEntryID() {return entryID.get();}
	public final void setEntryID(String value){entryID.set(value);}
	public StringProperty entryID(){return entryID;}
	
	private StringProperty date = new SimpleStringProperty();
	public final String getDate() {return date.get();}
	public final void setDate(String value){date.set(value);}
	public StringProperty date(){return date;}
	
	private StringProperty description = new SimpleStringProperty();
	public final String getDescription() {return description.get();}
	public final void setDescription(String value){description.set(value);}
	public StringProperty description(){return description;}
	
	private StringProperty amount = new SimpleStringProperty();
	public final String getAmount() {return amount.get();}
	public final void setAmount(String value){amount.set(value);}
	public StringProperty amount(){return amount;}
	
	private StringProperty accountNumber = new SimpleStringProperty();
	public final String getAccountNumber() {return accountNumber.get();}
	public final void setAccountNumber(String value){accountNumber.set(value);}
	public StringProperty accountNumber(){return accountNumber;}
	
	private StringProperty regNumber = new SimpleStringProperty();
	public final String getRegNumber() {return regNumber.get();}
	public final void setRegNumber(String value){regNumber.set(value);}
	public StringProperty regNumber(){return regNumber;}
	
	public static EntryModel domainToModel(Entry entry)
	{
		EntryModel entryModel =new EntryModel();
		
		entryModel.setEntryID(""+entry.getEntryID());
		entryModel.setDate(entry.getDate().toString());
		entryModel.setDescription(entry.getDescription());
		entryModel.setAmount(""+entry.getAmount());
		entryModel.setRegNumber(""+entry.getRegNumber());
		entryModel.setAccountNumber(""+entry.getAccountNumber());
		
		return entryModel;
	}
	
	public Entry toDomain()
	{
		Entry.Builder builder = new Builder().setEntryID(Integer.parseInt(getEntryID())).setDescription(getDescription()).setAccountNumber(Integer.parseInt(getAccountNumber()))
				.setRegNumber(Integer.parseInt(getRegNumber())).setAmount(new BigDecimal(getAmount())).setDate(LocalDateTime.parse(getDate()));
		Entry entry = builder.build();
		
		return entry;
	}
}
