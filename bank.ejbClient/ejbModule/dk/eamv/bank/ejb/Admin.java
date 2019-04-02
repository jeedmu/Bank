package dk.eamv.bank.ejb;

import java.util.HashMap;

import javax.ejb.Local;

import dk.eamv.bank.domain.User;

@Local
public interface Admin {

	
	// TODO user entities?
	public boolean editUser(User user);

	public boolean deleteUser(String userId);

	
}
