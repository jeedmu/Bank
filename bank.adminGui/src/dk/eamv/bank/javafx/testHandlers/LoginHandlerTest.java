package dk.eamv.bank.javafx.testHandlers;

import java.util.ArrayList;
import java.util.List;

import dk.eamv.bank.javafx.domain.Role;
import dk.eamv.bank.javafx.domain.User;
import dk.eamv.bank.javafx.interfaces.ILoginHandler;

public class LoginHandlerTest implements ILoginHandler {
	
	@Override
	public User loginUser(String userName, String password)
	{
		// Test code
		if(userName.equals("test")&&password.equals("1234"))
		{
			List<Role> testList=new ArrayList<>();
			User user=new User("test", "Harry", "1234", testList);
			return user;
		}
		else
		{
		return null;
		}
	}
}
