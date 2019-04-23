package dk.eamv.bank.ejb;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import dk.eamv.bank.domain.Bank;
import dk.eamv.bank.domain.Property;
import dk.eamv.bank.domain.Role;
import dk.eamv.bank.domain.User;

@Local
public interface Admin {

	
	// TODO user entities?
	public boolean editUser(User user);

	public boolean deleteUser(String userId);
	
	public User createUser(User user);
	
	public List<User> getUsers(String search);
	
	public Optional<User> getUser(String userId);
	
	public boolean editRole(Role role);
	
	public boolean deleteRole(int roleID);
	
	public Role createRole(Role role);
	
	public List<Role> getRoles();
	
	public Optional<Role> getRole(int roleID);
	
	public boolean editProperty(Property property);
	
	public boolean deleteProperty(String property);
	
	public boolean createProperty(Property property);
	
	public List<Property> getProperties();
	
	public Optional<Property> getProperty(String property);
	
	public boolean editBank(Bank bank);
	
	public boolean deleteBank(String address);
	
	public boolean createBank(Bank bank);
	
	public List<Bank> getBanks();

	public Optional<Bank> getBank(int regNumber);
	
	
	
}
