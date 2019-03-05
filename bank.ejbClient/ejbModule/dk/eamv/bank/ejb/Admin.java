package dk.eamv.bank.ejb;

import java.util.HashMap;

import javax.ejb.Local;

@Local
public interface Admin {

	
	// TODO user entities?
	public boolean editUser(HashMap<String, String> user);

	public boolean deleteUser(String id);

	
}
