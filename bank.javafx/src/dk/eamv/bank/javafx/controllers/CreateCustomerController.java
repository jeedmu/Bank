package dk.eamv.bank.javafx.controllers;


import dk.eamv.bank.javafx.interfaces.ITabPane;
import dk.eamv.bank.javafx.viewModels.CustomerModel;
import dk.eamv.bank.javafx.views.CreateCustomerView;
import javafx.scene.control.Tab;

public class CreateCustomerController implements ITabPane
{
	private Tab tab;
	private CreateCustomerView view;
	
	public void createCustomerPressed(CustomerModel costumer)
	{
		ControllerHandler.INSTANCE.getRequestHandler().createNewCustomer(costumer.toDomain());
		closeTab();
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
			view=new CreateCustomerView();
			if(o instanceof CustomerModel)
			{
				tab = new Tab("Redigér kunde", view.getSceneGUI(this, (CustomerModel)o));
			}
			else
			{
				CustomerModel newCustomer=new CustomerModel();
				//TODO solve id-problem
				newCustomer.setCustomerID("0");
				tab = new Tab("Ny kunde", view.getSceneGUI(this, newCustomer));
			}
			return tab;
		}
	}

	@Override
	public void closeTab() 
	{
		ControllerHandler.INSTANCE.closeTab(tab);
	}
}
