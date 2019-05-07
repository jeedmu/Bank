package dk.eamv.bank.rest.domain;

import dk.eamv.bank.domain.Role;

public class RoleRest {
	private int roleID;
	private String roleName;
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public Role toDomain() {
		Role role = new Role(roleID, roleName);
		return role;
	}
}
