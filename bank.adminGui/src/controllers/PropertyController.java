package controllers;

import java.util.List;
import java.util.Optional;

import data.RequestHandler;
import dk.eamv.bank.domain.Property;

public class PropertyController {
	RequestHandler handler = new RequestHandler();

	public Optional<Property> getProperty(String search) {
		return handler.getProperty(search);
	}

	public List<Property> getProperties() {
		return handler.getProperties();
	}
	
	public void createBank(Property property) {
		handler.createProperty(property);
	}
	
	public void editBank(Property property) {
		handler.editProperty(property);
	}
	
	public void deleteProperty(String property) {
		handler.deleteProperty(property);
	}
	
}
