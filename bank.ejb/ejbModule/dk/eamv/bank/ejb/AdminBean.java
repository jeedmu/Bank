package dk.eamv.bank.ejb;

import java.util.HashMap;

import javax.ejb.Stateless;

import dk.eamv.bank.domain.Property;
import dk.eamv.bank.domain.Role;
import dk.eamv.bank.domain.User;

/**
 * Session Bean implementation class AdminBean
 */
@Stateless
public class AdminBean implements Admin {

    /**
     * Default constructor. 
     */
    public AdminBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean editUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUsers() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUser(String userId) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean getRoles() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getRole(int roleID) {
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
	public boolean getProperties() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getProperty(String property) {
		// TODO Auto-generated method stub
		return false;
	}

}
