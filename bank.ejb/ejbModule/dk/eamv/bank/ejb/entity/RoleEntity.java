package dk.eamv.bank.ejb.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import dk.eamv.bank.domain.Role;

/* TODO
@NamedQueries({	@NamedQuery(name = "allRoles", query = "SELECT p FROM role p"
														+ "ORDER BY p.roleID"),

	@NamedQuery(name = "searchRole", query = "SELECT p FROM role p " 
											  + "WHERE p.roleName LIKE :search"
											  + "ORDER BY p.roleID")})
*/
@Entity(name="role")
public class RoleEntity {

	@GeneratedValue
	@Id
	private int roleID;
	
	@NotNull
	private String roleName;
	
	public RoleEntity() {}
	
	public RoleEntity(Role role) {
		this.roleID = role.getRoleID();
		this.roleName = role.getRoleName();
	}
	
	public Role toDomain() {
		return new Role.Builder(this.roleID, this.roleName).build();
	}

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
	
}
