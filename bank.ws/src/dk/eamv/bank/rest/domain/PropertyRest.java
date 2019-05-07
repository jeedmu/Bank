package dk.eamv.bank.rest.domain;

import dk.eamv.bank.domain.Property;

public class PropertyRest {
	private String property;
	private String value;
	
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public Property toDomain() {
		Property property = new Property(getProperty(), value);
		return property;
	}
}
