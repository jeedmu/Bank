package dk.eamv.bank.javafx.interfaces;

import dk.eamv.bank.javafx.domain.User;

public interface ILoginHandler
{
	//Finds user based on username and passwords, if no users is found, return null
	public User loginUser(String userName, String password);
}
