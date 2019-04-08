package dk.eamv.bank.domain;

public class Role {

	
	private final int roleID;
	private final String roleName;
	
	public Role(int roleID, String roleName) {
		this.roleID = roleID;
		this.roleName = roleName;
	}
	
	public int getRoleID() {
		return roleID;
	}
	
	public String getRoleName() {
		return roleName;
	}
}
