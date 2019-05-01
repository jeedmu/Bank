package dk.eamv.bank.javafx.controllers;

import dk.eamv.bank.javafx.interfaces.ITabPane;
import dk.eamv.bank.javafx.viewModels.PropertyModel;
import dk.eamv.bank.javafx.views.CreatePropertyView;
import javafx.scene.control.Tab;

public class CreatePropertyController implements ITabPane{
	private Tab tab;
	private CreatePropertyView view;
	
	public void createPropertyPressed(PropertyModel property)
	{
		ControllerHandler.INSTANCE.getRequestHandler().createNewProperty(property.toDomain());
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
			view=new CreatePropertyView();
			if(o instanceof PropertyModel)
			{
				tab = new Tab("Rediger property", view.getSceneGUI(this, (PropertyModel)o));
			}
			else
			{
				PropertyModel newProperty = new PropertyModel();
				//TODO solve id-problem
				tab = new Tab("Ny property", view.getSceneGUI(this, newProperty));
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
