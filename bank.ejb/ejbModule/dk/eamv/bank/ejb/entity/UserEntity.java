package dk.eamv.bank.ejb.entity;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import dk.eamv.bank.domain.Role;
import dk.eamv.bank.domain.User;

@NamedQueries({ 
	@NamedQuery(name = "allUsers", query = "SELECT p FROM user p " + "ORDER BY p.userId"),

	@NamedQuery(name = "searchUser", query = "SELECT p FROM user p " 
												 + "WHERE p.name LIKE :search "
												 + "ORDER BY p.userId") })

@Entity(name = "user")
public class UserEntity {

	@Id
	private String userId;

	@NotNull
	private String name;

	@NotNull
	private String password;

	
	@ManyToMany(
			fetch = FetchType.EAGER)
//			cascade = {
//					CascadeType.PERSIST,
//					CascadeType.REMOVE
//			})
	@JoinTable(name="user_role",
		joinColumns = @JoinColumn(name = "user_userId", referencedColumnName = "userId"),
		inverseJoinColumns = @JoinColumn(name = "role_roleID", referencedColumnName = "roleID")
	)
	private List<RoleEntity> roles;
	

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public UserEntity() {
	}

	public UserEntity(User user) {
		this.userId = user.getUserId();
		this.name = user.getName();
		this.password = user.getPassword();
		this.roles = user.getRoles()
				.stream()
				.map(r -> new RoleEntity(r))
				.collect(Collectors.toList());
	}
	
	public User toDomain() {
		return new User.Builder(userId).setName(name).setPassword(password).setRoles(toRoles()).build();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
	
	private List<Role> toRoles() {
		return this.roles
		.stream()
		.map(r -> r.toDomain())
		.collect(Collectors.toList());
	}

}
