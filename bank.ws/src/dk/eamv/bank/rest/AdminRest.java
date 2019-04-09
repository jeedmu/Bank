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

import dk.eamv.bank.domain.Property;
import dk.eamv.bank.domain.Role;
import dk.eamv.bank.domain.User;
import dk.eamv.bank.ejb.Admin;

@Path("/admin")
public class AdminRest implements Admin{
	@EJB Admin adminBean;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("editUser")
	@Override
	public boolean editUser(User user) {
		return adminBean.editUser(user);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("deleteUser/{userId}")
	@Override
	public boolean deleteUser(@PathParam("userId") String userId) {
		return adminBean.deleteUser(userId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("createUser")
	@Override
	public User createUser(User user) {
		return adminBean.createUser(user);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getUsers/{search}")
	@Override
	public List<User> getUsers(@PathParam("search") String search) {
		return adminBean.getUsers(search);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getUser/{userId}")
	@Override
	public Optional<User> getUser(@PathParam("userId") String userId) {
		return adminBean.getUser(userId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("editRole")
	@Override
	public boolean editRole(Role role) {
		return adminBean.editRole(role);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("deleteRole/{roleID}")
	@Override
	public boolean deleteRole(@PathParam("roleID") int roleID) {
		return adminBean.deleteRole(roleID);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("createRole")
	@Override
	public Role createRole(Role role) {
		return adminBean.createRole(role);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getRoles")
	@Override
	public List<Role> getRoles() {
		return adminBean.getRoles();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getRole/{roleID}")
	@Override
	public Optional<Role> getRole(@PathParam("roleID") int roleID) {
		return adminBean.getRole(roleID);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("editProperty")
	@Override
	public boolean editProperty(Property property) {
		return adminBean.editProperty(property);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("deleteProperty/{property}")
	@Override
	public boolean deleteProperty(@PathParam("property") String property) {
		return adminBean.deleteProperty(property);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("createProperty")
	@Override
	public boolean createProperty(Property property) {
		return adminBean.createProperty(property);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getProperties")
	@Override
	public List<Property> getProperties() {
		return adminBean.getProperties();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getProperty/{property}")
	@Override
	public Optional<Property> getProperty(@PathParam("property") String property) {
		return adminBean.getProperty(property);
	}
}
