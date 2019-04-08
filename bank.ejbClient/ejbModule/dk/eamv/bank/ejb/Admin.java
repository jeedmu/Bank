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
	public boolean editUser(User user);

	public boolean deleteUser(String userId);
	
	public User createUser(User user);
	
	public List<User> getUsers();
	
	public Optional<User> getUser(String userId);
	
	public boolean editRole(Role role);
	
	public boolean deleteRole(int roleID);
	
	public Role createRole(Role role);
	
	public List<Role> getRoles();
	
	public List<Role> getRole(String roleID);
	
	public boolean editProperty(Property property);
	
	public boolean deleteProperty(String property);
	
	public boolean createProperty(Property property);
	
	public List<Property> getProperties();
	
	public List<Property> getProperty(String property);
	
}
