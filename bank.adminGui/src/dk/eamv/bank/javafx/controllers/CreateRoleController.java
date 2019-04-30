package dk.eamv.bank.javafx.controllers;

import dk.eamv.bank.javafx.interfaces.ITabPane;
import dk.eamv.bank.javafx.viewModels.RoleProperty;
import dk.eamv.bank.javafx.views.CreateRoleView;
import javafx.scene.control.Tab;

public class CreateRoleController implements ITabPane {
	private Tab tab;
	private CreateRoleView view;
	
	public void createRolePressed(RoleProperty role)
	{
		ControllerHandler.INSTANCE.getRequestHandler().createNewRole(role.toDomain());
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
			view=new CreateRoleView();
			if(o instanceof RoleProperty)
			{
				tab = new Tab("Redigér rolle", view.getSceneGUI(this, (RoleProperty)o));
			}
			else
			{
				RoleProperty newRole=new RoleProperty();
				//TODO solve id-problem
				newRole.setRoleID("0");
				tab = new Tab("Ny rolle", view.getSceneGUI(this, newRole));
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
