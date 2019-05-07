package dk.eamv.bank.rest.domain;

import java.util.List;

import dk.eamv.bank.domain.Role;
import dk.eamv.bank.domain.User;
import dk.eamv.bank.domain.User.Builder;

public class UserRest {
	private String userId;
	private int customerId;
	private String name;
	private String password;
	private List<Role> roles;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public User toDomain() {
		User.Builder builder = new Builder(userId).setCustomerId(customerId).setName(name).setPassword(password).setRoles(roles);
		return builder.build();
		
	}

}
