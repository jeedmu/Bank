package dk.eamv.bank.domain;

import java.util.List;

public class User {

	private final String userId;
	private final String name;
	private final String password;
	private final List<Role> roles;
	
	public static class Builder {
		private final String userId;
		private String name;
		private String password;
		private List<Role> roles;
		
		public Builder(String userId) {
			this.userId = userId;
		}
		
		public User build() {
			return new User(this);
		}
	}
	
	private User(Builder builder) {
		userId = builder.userId;
		name = builder.name;
		password = builder.password;
		roles = builder.roles;
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
