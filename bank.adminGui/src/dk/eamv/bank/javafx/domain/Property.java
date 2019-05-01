package dk.eamv.bank.javafx.domain;

public class Property {

	private final String property;
	private final String value;
	
	public Property(String property, String value) {
		this.property = property;
		this.value = value;
	}

	public String getProperty() {
		return this.property;
	}

	public String getValue() {
		return this.value;
	}
	
}
