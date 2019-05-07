package controllers;

import java.util.List;
import java.util.Optional;

import data.RequestHandler;
import dk.eamv.bank.domain.Role;

public class RoleController {

	RequestHandler handler = new RequestHandler();

	public Optional<Role> getRole(int roleId) {
		return handler.getRole(roleId);
	}

	public List<Role> getRoles() {
		return handler.getRoles();
	}
	
	public void createRole(Role role) {
		handler.createRole(role);
	}
	
	public void editRole(Role role) {
		handler.editRole(role);
	}
	
	public void deleteRole(int roleId) {
		handler.deleteRole(roleId);
	}
	
}
