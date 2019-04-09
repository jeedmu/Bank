package dk.eamv.bank.ejb.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import dk.eamv.bank.domain.Role;


@NamedQuery(name = "allRoles", query = "SELECT p FROM role p " + "ORDER BY p.roleID")

				

@Entity(name="role")
public class RoleEntity {

	@GeneratedValue
	@Id
	private int roleID;
	
	@NotNull
	private String roleName;
	
	@ManyToMany(mappedBy = "roles")
	private List<UserEntity> users = new ArrayList<UserEntity>();
	
	
	
	
	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public RoleEntity() {}
	
	public RoleEntity(Role role) {
		this.roleID = role.getRoleID();
		this.roleName = role.getRoleName();
	}
	
	public Role toDomain() {
		return new Role(this.roleID, this.roleName);
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
