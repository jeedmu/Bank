package dk.eamv.bank.domain;

public class User {

	private final String userId;
	private final String name;
	private final String password;
	
	
	public User(String userId, String name, String password) {
		this.name = name;
		this.userId = userId;
		this.password = password;
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
