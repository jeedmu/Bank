package dk.eamv.bank.domain;

import java.util.List;

public class User {

	private final String userId;
	private final String name;
	private final String password;
	private final List<Role> roles;
	
	public User(String userId, String name, String password, List<Role> roles) {
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.roles = roles;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public String getUserId() {
		return userId;
	}


	public String getName() {
		return name;
	}


	public String getPassword() {
		return password;
	}
	
	
	
	
	
}
