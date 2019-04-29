package dk.eamv.bank.javafx.controllers;

import dk.eamv.bank.javafx.domain.User;
import dk.eamv.bank.javafx.interfaces.ILoginHandler;
import dk.eamv.bank.javafx.testHandlers.LoginHandlerTest;
import dk.eamv.bank.javafx.views.LoginView;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LoginController 
{
	private LoginView itsView;
	private Stage itsStage;
	
	public LoginController(Stage stage)
	{
		itsView=new LoginView();
		itsStage=stage;
		itsStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				ControllerHandler.INSTANCE.changeUser(null);
			}
		});
	}
	
	public LoginView getView()
	{
		return itsView;
	}
	
	public boolean login(String username, String password)
	{
		ILoginHandler loginHandler = new LoginHandlerTest();
		User user=loginHandler.loginUser(username, password);
		
		if(user!=null)
		{
			ControllerHandler.INSTANCE.changeUser(user);
			itsStage.close();	
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void cancelLogin()
	{
		ControllerHandler.INSTANCE.changeUser(null);
		itsStage.close();
	}
}
