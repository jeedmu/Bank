package dk.eamv.bank.ejb;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import dk.eamv.bank.domain.Property;
import dk.eamv.bank.domain.Role;
import dk.eamv.bank.domain.User;

@Local
public interface Admin {

	
	// TODO user entities?
	public void editUser(User user);

	public void deleteUser(String userId);
	
	public User createUser(User user);
	
	public List<User> getUsers(String search);
	
	public Optional<User> getUser(String userId);
	
	public void editRole(Role role);
	
	public void deleteRole(int roleID);
	
	public Role createRole(Role role);
	
	public List<Role> getRoles();
	
	public Optional<Role> getRole(int roleID);
	
	public void editProperty(Property property);
	
	public void deleteProperty(String property);
	
	public void createProperty(Property property);
	
	public List<Property> getProperties();
	
	public Optional<Property> getProperty(String property);
	
}
