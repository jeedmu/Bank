package dk.eamv.bank.ejb;

import java.util.HashMap;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import dk.eamv.bank.domain.Property;

/**
 * Session Bean implementation class SingletonPropertiesBean
 */
@Singleton
@LocalBean
public class SingletonPropertiesBean implements SingletonPropertiesBeanLocal {

	private HashMap<String, Property> properties;
	
    public SingletonPropertiesBean() {
    	properties = new HashMap<String, Property>();
    }
    
    public Property get(String property)
    {
    	return properties.get(property);
    }
    
    public void SetProperty(Property property)
    {
    	properties.put(property.getProperty(), property);
    }
}