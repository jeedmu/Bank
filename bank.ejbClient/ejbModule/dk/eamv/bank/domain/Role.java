package dk.eamv.bank.domain;

public class Role {

	
	private final int roleID;
	private final String roleName;
	
	
	public static class Builder {
		
		private int roleID;
		private String roleName;
		
		public Builder(int roleID, String roleName) {
			this.roleID = roleID;
			this.roleName = roleName;
		}
		
		public Role build() {
			return new Role(this);
		}
	}
	
	private Role(Builder builder){
		roleID = builder.roleID;
		roleName = builder.roleName;
	}
	
	public int getRoleID() {
		return roleID;
	}
	
	public String getRoleName() {
		return roleName;
	}
}
