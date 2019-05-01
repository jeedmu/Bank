package dk.eamv.bank.javafx.viewModels;

import dk.eamv.bank.javafx.domain.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PropertyModel {
	
	private StringProperty property = new SimpleStringProperty();
	public final String getProperty() {return property.get();}
	public final void setProperty(String value) {property.set(value);}
	public StringProperty property() {return property;}

	private StringProperty value = new SimpleStringProperty();
	public final String getValue() {return value.get();}
	public final void setValue(String val) {value.set(val);}
	public StringProperty value() {return value;}
	
	public static PropertyModel domainToModel(Property property)
	{
		PropertyModel propertyModel =new PropertyModel();
		
		propertyModel.setProperty(""+property.getProperty());
		propertyModel.setValue(""+property.getValue());

		
		return propertyModel;
	}
	
	public Property toDomain()
	{
		Property property = new Property(getProperty(), getValue());
		
		return property;
	}
}
