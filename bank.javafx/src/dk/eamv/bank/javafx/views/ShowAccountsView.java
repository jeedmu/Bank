package dk.eamv.bank.javafx.views;

import dk.eamv.bank.javafx.controllers.ShowAccountsController;
import dk.eamv.bank.javafx.interfaces.ITabPane;
import dk.eamv.bank.javafx.viewModels.AccountModel;
import dk.eamv.bank.javafx.viewModels.CustomerModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ShowAccountsView
{
	private ShowAccountsController controller;
	private TableView<AccountModel> table;
	
	public StackPane getSceneGUI(ShowAccountsController controller)
	{
		this.controller=controller;
		
		StackPane root = new StackPane();
		root.setId("view_screen");
		
		VBox holder= new VBox();
		holder.setId("view_screen");
		
		holder.getChildren().add(getCustomerArea());
		table = constructTable();
		controller.updateAccountTable(table);
		
		holder.getChildren().add(table);
		holder.getChildren().add(createButtonContainer());
		
		root.getChildren().add(holder);
		
		return root;
	}
	
	public GridPane getCustomerArea()
	{
		GridPane customerArea = new GridPane();
		CustomerModel customer=controller.getCurrentCustomer();
		
		Label idHeaderLabel=new Label("Kunde nr. :");
		idHeaderLabel.setId("create_customer_label");
		
		Label idLabel=new Label(customer.getCustomerID());
		idLabel.setId("create_customer_label");
		
		Label nameHeaderLabel=new Label("Kunde navn :");
		nameHeaderLabel.setId("create_customer_label");
		
		Label nameLabel=new Label(customer.getFullName());
		nameLabel.setId("create_customer_label");

		customerArea.add(nameHeaderLabel, 0, 0);
		customerArea.add(idLabel, 0, 1);
		customerArea.add(idHeaderLabel, 1, 0);
		customerArea.add(nameLabel, 1, 1);
		
		return customerArea;
	}
	
	public HBox createButtonContainer()
	{
		HBox buttons = new HBox();
		
		Button viewEntriesButton = new Button("Se posteringer");
		viewEntriesButton.setId("view_button");
		viewEntriesButton.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	AccountModel account=table.getSelectionModel().getSelectedItem();
		    	if(account!=null)
		    		controller.viewAccountEntriesPressed(account);
		    }
		});
		
		Button createAccountButton = new Button("Ny konto");
		createAccountButton.setId("view_button");
		createAccountButton.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	controller.createNewAccountPressed();
		    }
		});
		
		Button cancelButton = new Button("Luk");
		cancelButton.setId("view_button");
		cancelButton.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	controller.closeTab();
		    }
		});
		
		buttons.getChildren().add(viewEntriesButton);
		buttons.getChildren().add(createAccountButton);
		buttons.getChildren().add(cancelButton);
		
		return buttons;
	}

	
	public TableView<AccountModel> constructTable()
	{
		TableView<AccountModel> newTable = new TableView<AccountModel>();
		
		TableColumn<AccountModel, String> accountNameCol = new TableColumn<AccountModel, String>("Kontonavn");
		accountNameCol.setCellValueFactory(new PropertyValueFactory<AccountModel,String>("accountName"));
		
		TableColumn<AccountModel, String> regNrCol = new TableColumn<AccountModel, String>("Reg. nr.");
		regNrCol.setCellValueFactory(new PropertyValueFactory<AccountModel,String>("regNumber"));
		
		TableColumn<AccountModel, String> accountNrCol = new TableColumn<AccountModel, String>("Konto nr.");
		accountNrCol.setCellValueFactory(new PropertyValueFactory<AccountModel,String>("accountNumber"));
		
		TableColumn<AccountModel, String> currentBalanceCol = new TableColumn<AccountModel, String>("Beløb");
		currentBalanceCol.setCellValueFactory(new PropertyValueFactory<AccountModel,String>("balance"));
		
		TableColumn<AccountModel, String> availableBalanceCol = new TableColumn<AccountModel, String>("Til rådighed");
		
		newTable.getColumns().addAll(accountNameCol, regNrCol, accountNrCol, currentBalanceCol, availableBalanceCol);
		
		return newTable;
	}
}