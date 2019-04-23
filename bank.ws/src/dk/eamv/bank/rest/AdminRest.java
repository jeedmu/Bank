package dk.eamv.bank.rest;

import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dk.eamv.bank.domain.Bank;
import dk.eamv.bank.domain.Property;
import dk.eamv.bank.domain.Role;
import dk.eamv.bank.domain.User;
import dk.eamv.bank.ejb.Admin;

@Path("/admin")
public class AdminRest {

	@EJB Admin adminBean;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("editUser")
	public boolean editUser(User user) {
		adminBean.editUser(user);
		return true;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("deleteUser/{userId}")
	public boolean deleteUser(@PathParam("userId") String userId) {
		adminBean.deleteUser(userId);
		return true;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("createUser")
	public User createUser(User user) {
		return adminBean.createUser(user);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getUsers/{search}")
	public List<User> getUsers(@PathParam("search") String search) {
		return adminBean.getUsers(search);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getUser/{userId}")
	public Optional<User> getUser(@PathParam("userId") String userId) {
		return adminBean.getUser(userId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("editRole")
	public boolean editRole(Role role) {
		adminBean.editRole(role);
		return true;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("deleteRole/{roleID}")
	public boolean deleteRole(@PathParam("roleID") int roleID) {
		adminBean.deleteRole(roleID);
		return true;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("createRole")
	public Role createRole(Role role) {
		return adminBean.createRole(role);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getRoles")
	public List<Role> getRoles() {
		return adminBean.getRoles();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getRole/{roleID}")
	public Optional<Role> getRole(@PathParam("roleID") int roleID) {
		return adminBean.getRole(roleID);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("editProperty")
	public boolean editProperty(Property property) {
		adminBean.editProperty(property);
		return true;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("deleteProperty/{property}")
	public boolean deleteProperty(@PathParam("property") String property) {
		adminBean.deleteProperty(property);
		return true;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("createProperty")
	public boolean createProperty(Property property) {
		adminBean.createProperty(property);
		return true;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getProperties")
	public List<Property> getProperties() {
		return adminBean.getProperties();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getProperty/{property}")
	public Optional<Property> getProperty(@PathParam("property") String property) {
		return adminBean.getProperty(property);
	}
}
