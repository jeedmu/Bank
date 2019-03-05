package dk.eamv.bank.ejb;

import javax.ejb.Local;

import dk.eamv.bank.domain.Property;

@Local
public interface SingletonPropertiesBeanLocal {
	public Property get(String property);
}