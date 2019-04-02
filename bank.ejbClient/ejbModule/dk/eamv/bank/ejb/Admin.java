package dk.eamv.bank.ejb;

import java.util.HashMap;

import javax.ejb.Local;

import dk.eamv.bank.domain.Property;
import dk.eamv.bank.domain.Role;
import dk.eamv.bank.domain.User;

@Local
public interface Admin {

	
	// TODO user entities?
	public boolean editUser(User user);

	public boolean deleteUser(String userId);
	
	public boolean createUser(User user);
	
	public boolean getUsers();
	
	public boolean getUser(String userId);
	
	public boolean editRole(Role role);
	
	public boolean deleteRole(int roleID);
	
	public boolean createRole(Role role);
	
	public boolean getRoles();
	
	public boolean getRole(int roleID);
	
	public boolean editProperty(Property property);
	
	public boolean deleteProperty(String property);
	
	public boolean createProperty(Property property);
	
	public boolean getProperties();
	
	public boolean getProperty(String property);
	
}
