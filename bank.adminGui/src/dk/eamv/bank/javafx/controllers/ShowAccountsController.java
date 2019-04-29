package dk.eamv.bank.javafx.controllers;

import java.util.ArrayList;
import java.util.List;

import dk.eamv.bank.javafx.domain.Account;
import dk.eamv.bank.javafx.domain.Customer;
import dk.eamv.bank.javafx.interfaces.IDataRequestHandler;
import dk.eamv.bank.javafx.interfaces.ITabPane;
import dk.eamv.bank.javafx.testHandlers.DataRequestHandlerTest;
import dk.eamv.bank.javafx.viewModels.AccountModel;
import dk.eamv.bank.javafx.viewModels.CustomerModel;
import dk.eamv.bank.javafx.views.CreateAccountView;
import dk.eamv.bank.javafx.views.ShowEntriesView;
import dk.eamv.bank.javafx.views.ShowAccountsView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;

public class ShowAccountsController implements ITabPane
{
	private Tab tab;
	private ShowAccountsView view;
	private CustomerModel currentCustomer;
	
	public CustomerModel getCurrentCustomer()
	{
		return currentCustomer;
	}
	
	public void updateAccountTable(TableView<AccountModel> table)
	{
		table.getItems().clear();
		
		List<Account> accountDomainList= ControllerHandler.INSTANCE.getRequestHandler().getAccounts(currentCustomer.toDomain());
		List<AccountModel> accountList=new ArrayList<AccountModel>();
		for (Account account : accountDomainList) 
		{
			accountList.add(AccountModel.domainToModel(account));
		}
		table.getItems().addAll(accountList);
	}
	
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
			view=new ShowAccountsView();
			tab = new Tab("Vis Kontoer", view.getSceneGUI(this));
			return tab;
		}
	}

	@Override
	public void closeTab() {
		ControllerHandler.INSTANCE.closeTab(tab);
	}
	
	public void viewAccountEntriesPressed(AccountModel account)
	{
		ControllerHandler.INSTANCE.createAndShowTab(new ShowEntriesController(), account);
	}
	
	public void createNewAccountPressed()
	{
		ControllerHandler.INSTANCE.createAndShowTab(new CreateAccountController(), null);
	}
}
