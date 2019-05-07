package controllers;

import java.util.List;
import java.util.Optional;

import data.RequestHandler;
import dk.eamv.bank.domain.User;

public class UserController {
	RequestHandler handler = new RequestHandler();

	public Optional<User> getUser(String userId) {
		return handler.getUser(userId);
	}

	public List<User> getUsers(String search) {
		return handler.getUsers(search);
	}
	
	public void createUser(User user) {
		handler.createUser(user);
	}
	
	public void editUser(User user) {
		handler.editUser(user);
	}
	
	public void deleteUser(String id) {
		handler.deleteUser(id);
	}
	
}
