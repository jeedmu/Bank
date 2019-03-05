package dk.eamv.bank.ejb;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import dk.eamv.bank.domain.Property;
import dk.eamv.bank.ejb.entitybeans.PropertyBean;

/**
 * Session Bean implementation class SingletonPropertiesBean
 */
@Singleton
public class SingletonPropertiesBean implements SingletonPropertiesBeanLocal {

	@EJB private PropertyBean propertyBean; 
	private HashMap<String, Property> properties;
	
    public SingletonPropertiesBean() {
    	properties = new HashMap<String, Property>();
    }
    
    @PostConstruct
    public void init()
    {
    	for(Property p : propertyBean.list() )
    		properties.put(p.getProperty(), p);
    }
    
    public Property get(String property)
    {
    	return properties.get(property);
    }
}