package dk.eamv.bank.javafx.interfaces;

import javafx.scene.control.Tab;
import javafx.scene.layout.StackPane;

public interface ITabPane 
{
	public Tab getTab(Object o);
	
	public void closeTab();
}
