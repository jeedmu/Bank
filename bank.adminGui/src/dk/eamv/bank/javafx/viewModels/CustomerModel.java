package dk.eamv.bank.javafx.viewModels;

import dk.eamv.bank.javafx.domain.Customer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CustomerModel 
{
	private StringProperty firstName = new SimpleStringProperty();
	public final String getFirstName() {return firstName.get();}
	public final void setFirstName(String value){firstName.set(value);}
	public StringProperty firstNameProperty(){return firstName;}
	
	private StringProperty surName = new SimpleStringProperty();
	public final String getSurName() {return surName.get();}
	public final void setSurName(String value){surName.set(value);}
	public StringProperty surNameProperty(){return surName;}
	
	private StringProperty sSN = new SimpleStringProperty();
	public final String getSSN() {return sSN.get();}
	public final void setSSN(String value){sSN.set(value);}
	public StringProperty sSN(){return sSN;}
	
	private StringProperty address = new SimpleStringProperty();
	public final String getAddress() {return address.get();}
	public final void setAddress(String value){address.set(value);}
	public StringProperty address(){return address;}
	
	private StringProperty country = new SimpleStringProperty();
	public final String getCountry() {return country.get();}
	public final void setCountry(String value){country.set(value);}
	public StringProperty country(){return country;}
	
	private StringProperty zipCode = new SimpleStringProperty();
	public final String getZipCode() {return zipCode.get();}
	public final void setZipCode(String value){zipCode.set(value);}
	public StringProperty zipCode(){return zipCode;}
	
	private StringProperty city = new SimpleStringProperty();
	public final String getCity() {return city.get();}
	public final void setCity(String value){city.set(value);}
	public StringProperty city(){return city;}
	
	private StringProperty email = new SimpleStringProperty();
	public final String getEmail() {return email.get();}
	public final void setEmail(String value){email.set(value);}
	public StringProperty email(){return email;}
	
	private StringProperty phoneNumber = new SimpleStringProperty();
	public final String getPhoneNumber() {return phoneNumber.get();}
	public final void setPhoneNumber(String value){phoneNumber.set(value);}
	public StringProperty phoneNumber(){return phoneNumber;}
	
	private StringProperty customerID = new SimpleStringProperty();
	public final String getCustomerID() {return customerID.get();}
	public final void setCustomerID(String value){customerID.set(value);}
	public StringProperty customerID(){return customerID;}
	
	public static CustomerModel domainToModel(Customer dCustomer)
	{
		CustomerModel customerModel =new CustomerModel();
		
		customerModel.setFirstName(dCustomer.getFirstName());
		customerModel.setSurName(dCustomer.getSurName());
		customerModel.setSSN(dCustomer.getSSN());
		customerModel.setAddress(dCustomer.getAddress());
		customerModel.setCountry(dCustomer.getCountry());
		customerModel.setZipCode(dCustomer.getZipCode());
		customerModel.setCity(dCustomer.getCity());
		customerModel.setEmail(dCustomer.getEmail());
		customerModel.setPhoneNumber(dCustomer.getPhoneNumber());
		customerModel.setCustomerID(""+dCustomer.getCustomerID());
		
		return customerModel;
	}
	
	public Customer toDomain()
	{
		Customer.Builder builder = new Customer.Builder(Integer.parseInt(getCustomerID()), getSSN()).setFirstName(getFirstName()).setSurName(getSurName()).setAddress(getAddress())
				.setCountry(getCountry()).setZipCode(getZipCode()).setCity(getCity()).setEmail(getEmail()).setPhoneNumber(getPhoneNumber());
		Customer costumer=builder.build();
		return costumer;
	}
	
	public String getFullName()
	{
		return getFirstName()+" "+getSurName();
	}
}
