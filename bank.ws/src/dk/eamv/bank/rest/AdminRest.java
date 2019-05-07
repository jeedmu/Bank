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
import dk.eamv.bank.rest.domain.BankRest;
import dk.eamv.bank.rest.domain.PropertyRest;
import dk.eamv.bank.rest.domain.RoleRest;
import dk.eamv.bank.rest.domain.UserRest;

@Path("/admin")
public class AdminRest {

	@EJB Admin adminBean;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("editUser")
	public boolean editUser(UserRest user) {
		adminBean.editUser(user.toDomain());
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
	public User createUser(UserRest user) {
		return adminBean.createUser(user.toDomain());
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
	public boolean editRole(RoleRest role) {
		adminBean.editRole(role.toDomain());
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
	public Role createRole(RoleRest role) {
		return adminBean.createRole(role.toDomain());
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
	public boolean editProperty(PropertyRest property) {
		adminBean.editProperty(property.toDomain());
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
	public boolean createProperty(PropertyRest property) {
		adminBean.createProperty(property.toDomain());
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
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("createBank")
	public boolean createBank(BankRest bank) {
		return adminBean.createBank(bank.toDomain());
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("editBank")
	public boolean editBank(BankRest bank) {
		return adminBean.editBank(bank.toDomain());
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("deleteBank/{address}")
	public boolean deleteBank(@PathParam("address") String address) {
		return adminBean.deleteBank(address);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getBanks")
	public List<Bank> getBanks(){
		return adminBean.getBanks();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getBank/{reg}")
	public Optional<Bank> getBank(@PathParam("reg") int reg){
		return adminBean.getBank(reg);
	}
}
