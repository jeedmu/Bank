package dk.eamv.bank.domain;

import java.util.List;

public class User {

	private final String userId;
	private final int customerId;
	private final String name;
	private final String password;
	private final List<Role> roles;
	
	public static class Builder {
		private final String userId;
		private int customerId;
		private String name;
		private String password;
		private List<Role> roles;
		
		public Builder(String userId) {
			this.userId = userId;
		}
		
		public Builder setCustomerId(int customerId) {
			this.customerId = customerId;
			return this;
		}
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}
		
		public Builder setRoles(List<Role> roles) {
			this.roles = roles;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}
	
	private User(Builder builder) {
		userId = builder.userId;
		customerId = builder.customerId;
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
	
	public int getCustomerId() {
		return customerId;
	}


	public String getName() {
		return name;
	}


	public String getPassword() {
		return password;
	}
}
