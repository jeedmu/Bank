package dk.eamv.bank.ejb;

import java.util.HashMap;
import java.util.List;

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
	public boolean createUser(User user) {
		uB.create(user);
		return true;
	}

	@Override
	public List<User> getUsers() {
		return uB.list();
	}

	@Override
	public List<User> getUser(String search) {
		return uB.namedList(search);
	}

	@Override
	public boolean editRole(Role role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRole(int roleID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createRole(Role role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Role> getRole(int roleID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editProperty(Property property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProperty(String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createProperty(Property property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Property> getProperties() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Property> getProperty(String property) {
		// TODO Auto-generated method stub
		return false;
	}

}
