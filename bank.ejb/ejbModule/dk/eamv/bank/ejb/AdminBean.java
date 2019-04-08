package dk.eamv.bank.ejb;

import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dk.eamv.bank.domain.Property;
import dk.eamv.bank.domain.Role;
import dk.eamv.bank.domain.User;
import dk.eamv.bank.ejb.entitybeans.PropertyBean;
import dk.eamv.bank.ejb.entitybeans.RoleBean;
import dk.eamv.bank.ejb.entitybeans.UserBean;

/**
 * Session Bean implementation class AdminBean
 */
@Stateless
public class AdminBean implements Admin {
	@EJB UserBean uB;
	@EJB RoleBean rB;
	@EJB PropertyBean pB;

    /**
     * Default constructor. 
     */
    public AdminBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean editUser(User user) {
		uB.update(user);
		return true;
	}

	@Override
	public boolean deleteUser(String id) {
		uB.delete(id);
		return true;
	}

	@Override
	public User createUser(User user) {
		return uB.create(user);
	}

	@Override
	public List<User> getUsers() {
		return uB.list();
	}

	@Override
	public Optional<User> getUser(String userid) {
		return uB.read(userid);
	}
	@Override
	public boolean editRole(Role role) {
		rB.update(role);
		return true;
	}

	@Override
	public boolean deleteRole(int roleID) {
		rB.delete(roleID);
		return true;
	}

	@Override
	public Role createRole(Role role) {
		return rB.create(role);
	}

	@Override
	public List<Role> getRoles() {
		return rB.list();
	}

	@Override
	public List<Role> getRole(String roleID) {
		return rB.namedList(roleID);
	}

	@Override
	public boolean editProperty(Property property) {
		pB.update(property);
		return true;
	}

	@Override
	public boolean deleteProperty(String property) {
		pB.delete(property);
		return true;
	}

	@Override
	public boolean createProperty(Property property) {
		pB.create(property);
		return true;
	}

	@Override
	public List<Property> getProperties() {
		return pB.list();
	}

	@Override
	public List<Property> getProperty(String search) {
		return pB.search(search);
	}

}
