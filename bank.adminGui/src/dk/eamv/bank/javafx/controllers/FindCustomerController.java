package dk.eamv.bank.javafx.controllers;

import java.util.ArrayList;
import java.util.List;

import dk.eamv.bank.javafx.domain.Customer;
import dk.eamv.bank.javafx.interfaces.ITabPane;
import dk.eamv.bank.javafx.viewModels.CustomerModel;
import dk.eamv.bank.javafx.views.FindCustomerView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;


public class FindCustomerController implements ITabPane
{
	private Tab tab;
	private FindCustomerView view;
	
	public void updateTableView(TableView<CustomerModel> table, String customerID, String name, String phoneNumber)
	{
		table.getItems().clear();
		
		List<Customer> customerDomainList = ControllerHandler.INSTANCE.getRequestHandler().getCustomers(customerID, name, phoneNumber);
		List<CustomerModel> customerList=new ArrayList<>();
		for (Customer customer : customerDomainList) 
		{
			customerList.add(CustomerModel.domainToModel(customer));
		}
		table.getItems().addAll(customerList);
	}
	
	public void viewAccountsPressed(CustomerModel customer)
	{
		ControllerHandler.INSTANCE.createAndShowTab(new ShowAccountsController(), customer);
	}
	
	@Override
	public Tab getTab(Object o) 
	{
		if(tab!=null)
		{
			return tab;
		}
		else
		{
			view=new FindCustomerView();
			tab = new Tab("Ny konto", view.getSceneGUI(this));
			return tab;
		}
	}

	@Override
	public void closeTab()
	{
		ControllerHandler.INSTANCE.closeTab(tab);
	}
	
	public void editCustomerPressed(CustomerModel customer)
	{
		ControllerHandler.INSTANCE.createAndShowTab(new CreateCustomerController(), customer);
	}
}
