package dk.eamv.bank.ejb;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import dk.eamv.bank.constants.Constants;
import dk.eamv.bank.domain.Bank;
import dk.eamv.bank.domain.Property;
import dk.eamv.bank.domain.Role;
import dk.eamv.bank.domain.User;
import dk.eamv.bank.ejb.entitybeans.BankBean;
import dk.eamv.bank.ejb.entitybeans.PropertyBean;
import dk.eamv.bank.ejb.entitybeans.RoleBean;
import dk.eamv.bank.ejb.entitybeans.UserBean;


/**
 * Session Bean implementation class AdminBean
 */
@Stateless
@RolesAllowed(Constants.ROLE_ADMIN)
public class AdminBean implements Admin {
	@EJB UserBean uB;
	@EJB RoleBean rB;
	@EJB PropertyBean pB;
	@EJB BankBean bB;

    /**
     * Default constructor. 
     */
    public AdminBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	
	public void editUser(User user) {
		uB.update(user);
	}

	@Override
	public void deleteUser(String id) {
		uB.delete(id);
	}

	@Override
	public User createUser(User user) {
		return uB.create(user);
	}

	@Override
	public List<User> getUsers(String search) {
		return uB.getUsers(search);
	}

	@Override
	public Optional<User> getUser(String userid) {
		return uB.read(userid);
	}
	@Override
	public void editRole(Role role) {
		rB.update(role);
	}

	@Override
	public void deleteRole(int roleID) {
		rB.delete(roleID);
	}

	@Override
	public Role createRole(Role role) {
		return rB.create(role);
	}

	@Override
	public List<Role> getRoles() {
		return rB.getRoles();
	}

	@Override
	public Optional<Role> getRole(int roleID) {
		return rB.read(roleID);
	}

	@Override
	public void editProperty(Property property) {
		pB.update(property);
	}

	@Override
	public void deleteProperty(String property) {
		pB.delete(property);
	}

	@Override
	public void createProperty(Property property) {
		pB.create(property);
	}

	@Override
	public List<Property> getProperties() {
		return pB.getProperties();
	}

	@Override
	public Optional<Property> getProperty(String search) {
		return pB.read(search);
	}

	@Override
	public boolean editBank(Bank bank) {
		bB.update(bank);
		return false;
	}

	@Override
	public boolean deleteBank(String address) {
		bB.delete(address);
		return false;
	}

	@Override
	public boolean createBank(Bank bank) {
		bB.create(bank);
		return false;
	}

	@Override
	public List<Bank> getBanks() {
		return bB.getBanks();
	}

	@Override
	public Optional<Bank> getBank(int regNumber) {
		return bB.read(regNumber);
	}
}
