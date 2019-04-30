package dk.eamv.bank.javafx.controllers;

import dk.eamv.bank.javafx.interfaces.ITabPane;
import dk.eamv.bank.javafx.viewModels.AccountModel;
import dk.eamv.bank.javafx.viewModels.CustomerModel;
import dk.eamv.bank.javafx.viewModels.TransferModel;
import dk.eamv.bank.javafx.views.CreateTransferView;
import javafx.scene.control.Tab;

public class CreateTransferController implements ITabPane
{
	private Tab tab;
	private CreateTransferView view;
	private TransferModel currentTransfer;
	
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
			view=new CreateTransferView();
			
			AccountModel account=(AccountModel)o;
			currentTransfer=new TransferModel();
			currentTransfer.setFromAccount(account);
			//TODO get customer for transfer object
			currentTransfer.setCurrentCustomer(CustomerModel.domainToModel(ControllerHandler.INSTANCE.getRequestHandler().getCustomer(account.getCustomerID())));
			tab = new Tab("Ny overførsel", view.getSceneGUI(this));
			return tab;
		}
	}
	
	public void createTransferPressed()
	{
		ControllerHandler.INSTANCE.getRequestHandler().createNewTransfer(currentTransfer.toDomain());
		closeTab();
	}

	@Override
	public void closeTab() 
	{
		ControllerHandler.INSTANCE.closeTab(tab);
	}
	
	public TransferModel getTransferModel()
	{
		return currentTransfer;
	}
}
