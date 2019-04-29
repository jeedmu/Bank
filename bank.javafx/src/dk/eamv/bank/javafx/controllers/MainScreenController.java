package dk.eamv.bank.javafx.controllers;

import dk.eamv.bank.javafx.domain.User;
import dk.eamv.bank.javafx.interfaces.ITabPane;
import dk.eamv.bank.javafx.views.CreateAccountView;
import dk.eamv.bank.javafx.views.CreateCustomerView;
import dk.eamv.bank.javafx.views.CreateTransferView;
import dk.eamv.bank.javafx.views.ShowAccountsView;
import dk.eamv.bank.javafx.views.FindCustomerView;
import dk.eamv.bank.javafx.views.ShowEntriesView;
import dk.eamv.bank.javafx.views.MainScreenView;
import javafx.application.Platform;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class MainScreenController 
{
	private MainScreenView mainScreenView;
	
	public MainScreenView getMainScreenView()
	{
		return mainScreenView;
	}
	
	public MainScreenController()
	{
		mainScreenView=new MainScreenView(this);
	}

	public void openSearchCustomer()
	{
		ControllerHandler.INSTANCE.createAndShowTab(new FindCustomerController(), null);
	}

	public void createCustomer()
	{
		ControllerHandler.INSTANCE.createAndShowTab(new CreateCustomerController(), null);
	}

	public void changeView(Tab tab)
	{	
		mainScreenView.setView(tab);
	}
	
	public void closeTab(Tab tab)
	{
		mainScreenView.closeTab(tab);
	}
	
	public void setCurrentUserField(User newUser)
	{
		mainScreenView.setCurrentUserField(newUser);
	}
	
	public void openLoginScreenPressed()
	{
		ControllerHandler.INSTANCE.startLoginScreen();
	}
}
