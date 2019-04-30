package dk.eamv.bank.javafx.controllers;

import dk.eamv.bank.javafx.domain.User;
import dk.eamv.bank.javafx.interfaces.IDataRequestHandler;
import dk.eamv.bank.javafx.interfaces.ITabPane;
import dk.eamv.bank.javafx.testHandlers.DataRequestHandlerTest;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerHandler 
{
	public final static ControllerHandler INSTANCE = new ControllerHandler();
	private ControllerHandler()
	{
		dataRequestHandler=new DataRequestHandlerTest();
	}
	
	private User currentUser;
	private IDataRequestHandler dataRequestHandler;
	private MainScreenController mainScreen=new MainScreenController();
	
	public Scene createMainScene()
	{
		return mainScreen.getMainScreenView().createMainScreenScene();
	}
	
	public void startLoginScreen()
	{
		Stage loginStage=new Stage();
		LoginController theController=new LoginController(loginStage);
		loginStage.setTitle("Login");
		loginStage.initModality(Modality.APPLICATION_MODAL);
		loginStage.setScene(theController.getView().getSceneGUI(theController));
		loginStage.show();
	}
	
	public void changeUser(User newUser)
	{
		if(newUser==null)
		{
			if(currentUser==null)
			{
				Platform.exit();
			}
		}
		else
		{
			currentUser=newUser;
			mainScreen.setCurrentUserField(newUser);
		}
	}
	
	public void closeTab(Tab tab)
	{
		mainScreen.closeTab(tab);
	}
	
	public void createAndShowTab(ITabPane tab, Object o)
	{
		mainScreen.changeView(tab.getTab(o));
	}
	
	public IDataRequestHandler getRequestHandler()
	{
		return dataRequestHandler;
	}
}
