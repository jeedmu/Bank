package dk.eamv.bank.ejb;

import java.util.HashMap;

import javax.ejb.Stateless;

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

}
