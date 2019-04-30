package dk.eamv.bank.javafx.views;

import dk.eamv.bank.javafx.controllers.CreateAccountController;
import dk.eamv.bank.javafx.interfaces.ITabPane;
import dk.eamv.bank.javafx.viewModels.AccountModel;
import dk.eamv.bank.javafx.viewModels.CustomerModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class CreateAccountView
{
	private CreateAccountController controller;
	
	public StackPane getSceneGUI(CreateAccountController controller)
	{
		this.controller=controller;
		
		StackPane root = new StackPane();
		root.setId("view_screen");
		
		HBox containerBox=new HBox();
		
		containerBox.getChildren().add(getCustomerGrid());
		containerBox.getChildren().add(getAccountGrid());
		
		root.getChildren().add(containerBox);
		
		return root;
	}
	
	public GridPane getCustomerGrid()
	{
		GridPane customerGrid=new GridPane();
		CustomerModel customer=controller.getCustomer();
		
		Label customerInformationHeader=new Label("Kunde oplysninger:");
		customerInformationHeader.setId("part_header_label");
		
		Label nameHeaderLabel=new Label(customer.getFullName());
		nameHeaderLabel.setId("create_customer_label");
		
		Label idHeaderLabel=new Label(customer.getCustomerID());
		idHeaderLabel.setId("create_customer_label");
		
		Label phoneHeaderLabel=new Label("Tlf:"+customer.getPhoneNumber());
		phoneHeaderLabel.setId("create_customer_label");
		
		customerGrid.add(customerInformationHeader, 0, 0);
		customerGrid.add(nameHeaderLabel, 0, 1);
		customerGrid.add(idHeaderLabel, 0, 2);
		customerGrid.add(phoneHeaderLabel, 0, 3);
		
		return customerGrid;
	}
	
	public GridPane getAccountGrid()
	{
		GridPane accountGrid=new GridPane();
		AccountModel account=controller.getAccount();
		
		Label accountInformationHeader=new Label("Konto oplysninger:");
		accountInformationHeader.setId("part_header_label");
		
		Label RegNrHeader=new Label("Registrerings nr.");
		RegNrHeader.setId("create_customer_label");
		
		TextField RegNrTextField=new TextField();
		RegNrTextField.textProperty().bindBidirectional(account.regNumber());
		
		Label accountNrHeader=new Label("Konto nr.");
		accountNrHeader.setId("create_customer_label");
		
		TextField accountNrTextField=new TextField();
		accountNrTextField.textProperty().bindBidirectional(account.accountNumber());
		
		Label accountNameHeader=new Label("Konto Navn");
		accountNameHeader.setId("create_customer_label");
		
		TextField accountNameTextField=new TextField();
		accountNameTextField.textProperty().bindBidirectional(account.accountName());
		
		Label startDateHeader=new Label("Aktiverings dato");
		startDateHeader.setId("header_label");
		
		DatePicker datePicker=new DatePicker();
		
		HBox buttonHolder=new HBox();
		Button createAccountButton = new Button("Opret konto");
		createAccountButton.setId("view_button");
		createAccountButton.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	controller.createAccountPressed();
		    }
		});
		
		Button closeButton = new Button("Annullér");
		closeButton.setId("view_button");
		closeButton.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	controller.closeTab();
		    }
		});
		
		buttonHolder.getChildren().add(createAccountButton);
		buttonHolder.getChildren().add(closeButton);
		
		accountGrid.add(accountInformationHeader, 0, 0);
		accountGrid.add(RegNrHeader, 0, 1);
		accountGrid.add(RegNrTextField, 0, 2);
		accountGrid.add(accountNrHeader, 0, 3);
		accountGrid.add(accountNrTextField, 0, 4);
		accountGrid.add(accountNameHeader, 0, 5);
		accountGrid.add(accountNameTextField, 0, 6);
		accountGrid.add(startDateHeader, 0, 7);
		accountGrid.add(datePicker, 0, 8);
		accountGrid.add(buttonHolder, 0, 9);
		
		return accountGrid;
	}
}