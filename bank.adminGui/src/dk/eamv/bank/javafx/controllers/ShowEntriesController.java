package dk.eamv.bank.javafx.controllers;

import java.util.ArrayList;
import java.util.List;

import dk.eamv.bank.javafx.domain.Account;
import dk.eamv.bank.javafx.domain.Entry;
import dk.eamv.bank.javafx.interfaces.IDataRequestHandler;
import dk.eamv.bank.javafx.interfaces.ITabPane;
import dk.eamv.bank.javafx.testHandlers.DataRequestHandlerTest;
import dk.eamv.bank.javafx.viewModels.AccountModel;
import dk.eamv.bank.javafx.viewModels.CustomerModel;
import dk.eamv.bank.javafx.viewModels.EntryModel;
import dk.eamv.bank.javafx.views.CreateAccountView;
import dk.eamv.bank.javafx.views.ShowEntriesView;
import dk.eamv.bank.javafx.views.ShowAccountsView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;

public class ShowEntriesController implements ITabPane
{
	private Tab tab;
	private ShowEntriesView view;
	private AccountModel currentAccount;
	
	@Override
	public Tab getTab(Object o) 
	{
		if(o==null || !(o instanceof AccountModel))
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
			currentAccount=(AccountModel)o;
			view=new ShowEntriesView();
			tab = new Tab("Konto Oversigt", view.getSceneGUI(this));
			return tab;
		}
	}

	@Override
	public void closeTab() 
	{
		ControllerHandler.INSTANCE.closeTab(tab);
	}
	
	public AccountModel getAccount()
	{
		return currentAccount;
	}
	
	public void updateEntryTable(TableView<EntryModel> table)
	{
		table.getItems().clear();
		
		List<Entry> entryDomainList = ControllerHandler.INSTANCE.getRequestHandler().getEntries(currentAccount.toDomain());
		List<EntryModel> entryList=new ArrayList<EntryModel>();
		for (Entry entry : entryDomainList) 
		{
			entryList.add(EntryModel.domainToModel(entry));
		}
		table.getItems().addAll(entryList);
	}
	
	public CustomerModel getCustomer()
	{
		return CustomerModel.domainToModel(ControllerHandler.INSTANCE.getRequestHandler().getCustomer(currentAccount.getCustomerID()));
	}
	
	public void createTransferPressed()
	{
		ControllerHandler.INSTANCE.createAndShowTab(new CreateTransferController(), currentAccount);
	}
}
