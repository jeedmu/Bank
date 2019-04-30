package dk.eamv.bank.javafx.controllers;

import dk.eamv.bank.javafx.interfaces.ITabPane;
import dk.eamv.bank.javafx.viewModels.AccountModel;
import dk.eamv.bank.javafx.viewModels.CustomerModel;
import dk.eamv.bank.javafx.views.CreateAccountView;
import dk.eamv.bank.javafx.views.CreateBankView;
import javafx.scene.control.Tab;

public class CreateBankController implements ITabPane{
	private Tab tab;
	private CreateBankView view;
	private BankModel currentCustomer;
	private AccountModel currentAccount;
	
	@Override
	public Tab getTab(Object o) 
	{
		if(o==null || !(o instanceof CustomerModel))
		{
			//TODO
			//should not happen, but throw exception if happens
			return null;
		}
		
		if(tab!=null)
		{
			return tab;
		}
		else
		{
			currentCustomer=(CustomerModel)o;
			currentAccount=new AccountModel();
			currentAccount.setCustomerID(currentCustomer.getCustomerID());
			currentAccount.setBalance("0");
			view=new CreateAccountView();
			tab = new Tab("Ny konto", view.getSceneGUI(this));
			return tab;
		}
	}

	@Override
	public void closeTab() 
	{
		ControllerHandler.INSTANCE.closeTab(tab);
	}
	
	public CustomerModel getCustomer()
	{
		return currentCustomer;
	}
	
	public AccountModel getAccount()
	{
		return currentAccount;
	}
	
	public void createAccountPressed()
	{
		ControllerHandler.INSTANCE.getRequestHandler().createNewAccount(currentAccount.toDomain());
		closeTab();
	}
}
