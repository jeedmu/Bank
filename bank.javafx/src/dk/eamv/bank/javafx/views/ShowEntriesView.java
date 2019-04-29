package dk.eamv.bank.javafx.views;

import dk.eamv.bank.javafx.controllers.ShowEntriesController;
import dk.eamv.bank.javafx.interfaces.ITabPane;
import dk.eamv.bank.javafx.viewModels.AccountModel;
import dk.eamv.bank.javafx.viewModels.CustomerModel;
import dk.eamv.bank.javafx.viewModels.EntryModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ShowEntriesView
{
	private ShowEntriesController controller;
	private TableView<EntryModel> table;
	
	public StackPane getSceneGUI(ShowEntriesController controller)
	{
		this.controller=controller;
		
		StackPane root = new StackPane();
		root.setId("view_screen");
		
		VBox holder= new VBox();
		holder.setId("view_screen");
		
		holder.getChildren().add(getCustomerArea());
		table = constructTable();
		controller.updateEntryTable(table);
		holder.getChildren().add(table);
		holder.getChildren().add(createButtonContainer());
		
		root.getChildren().add(holder);
		
		return root;
	}
	
	
	public GridPane getCustomerArea()
	{
		GridPane customerArea = new GridPane();
		CustomerModel customer = controller.getCustomer();
		AccountModel account = controller.getAccount();
		
		Label idHeaderLabel=new Label("Kunde nr. :");
		idHeaderLabel.setId("create_customer_label");
		
		Label idLabel=new Label(customer.getCustomerID());
		idLabel.setId("create_customer_label");
		
		Label nameHeaderLabel=new Label("Kunde navn :");
		nameHeaderLabel.setId("create_customer_label");
		
		Label nameLabel=new Label(customer.getFullName());
		nameLabel.setId("create_customer_label");
		
		Label accountNameHeaderLabel=new Label("Konto navn :");
		accountNameHeaderLabel.setId("create_customer_label");
		
		Label accountNameLabel=new Label(account.getAccountName());
		accountNameLabel.setId("create_customer_label");
		
		Label accountNrHeaderLabel=new Label("Konto nr :");
		accountNrHeaderLabel.setId("create_customer_label");
		
		Label accountNrLabel=new Label(account.getFullAccountRegNumber());
		accountNrLabel.setId("create_customer_label");
		
		Label balanceHeaderLabel=new Label("Konto balance :");
		balanceHeaderLabel.setId("create_customer_label");
		
		Label balanceLabel=new Label(account.getBalance());
		balanceLabel.setId("create_customer_label");
		
		Label availableBalanceHeaderLabel=new Label("Til rådighed :");
		availableBalanceHeaderLabel.setId("create_customer_label");
		
		Label availableBalanceLabel=new Label("nn");
		availableBalanceLabel.setId("create_customer_label");

		customerArea.add(nameHeaderLabel, 0, 0);
		customerArea.add(nameLabel, 1, 0);
		customerArea.add(idHeaderLabel, 2, 0);
		customerArea.add(idLabel, 3, 0);
		customerArea.add(accountNameHeaderLabel, 0, 1);
		customerArea.add(accountNameLabel, 1, 1);
		customerArea.add(accountNrHeaderLabel, 2, 1);
		customerArea.add(accountNrLabel, 3, 1);
		customerArea.add(balanceHeaderLabel, 0, 2);
		customerArea.add(balanceLabel, 1, 2);
		customerArea.add(availableBalanceHeaderLabel, 2, 2);
		customerArea.add(availableBalanceLabel, 3, 2);
		
		return customerArea;
	}
	
	public HBox createButtonContainer()
	{
		HBox buttons = new HBox();
		
		
		
		
		Button newEntryButton = new Button("Ny postering");
		newEntryButton.setId("view_button");
		newEntryButton.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	controller.createTransferPressed();
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
		
		buttons.getChildren().add(newEntryButton);
		buttons.getChildren().add(cancelButton);
		
		return buttons;
	}

	
	public TableView<EntryModel> constructTable()
	{
		TableView<EntryModel> newTable = new TableView<EntryModel>();
		
		TableColumn<EntryModel, String> paidDateCol = new TableColumn<EntryModel, String>("Dato");
		paidDateCol.setCellValueFactory(new PropertyValueFactory<EntryModel,String>("date"));
		
		TableColumn<EntryModel, String> messageCol = new TableColumn<EntryModel, String>("Postering");
		messageCol.setCellValueFactory(new PropertyValueFactory<EntryModel,String>("description"));
		
		//TODO no data in entrydomain for this
		TableColumn<EntryModel, String> fromAccountCol = new TableColumn<EntryModel, String>("Fra");
		TableColumn<EntryModel, String> toAccountCol = new TableColumn<EntryModel, String>("Til");
		
		TableColumn<EntryModel, String> entryIDCol = new TableColumn<EntryModel, String>("Løbenr.");
		entryIDCol.setCellValueFactory(new PropertyValueFactory<EntryModel,String>("entryID"));
		
		TableColumn<EntryModel, String> amountCol = new TableColumn<EntryModel, String>("Beløb");
		amountCol.setCellValueFactory(new PropertyValueFactory<EntryModel,String>("amount"));
		
		newTable.getColumns().addAll(paidDateCol, messageCol, fromAccountCol, toAccountCol, entryIDCol, amountCol);
		
		return newTable;
	}
}