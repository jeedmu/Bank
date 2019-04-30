package dk.eamv.bank.javafx.views;

import dk.eamv.bank.javafx.controllers.CreateCustomerController;
import dk.eamv.bank.javafx.viewModels.CustomerModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class CreateCustomerView
{
	private CreateCustomerController controller;
	private CustomerModel currentCustomer;
	
	public StackPane getSceneGUI(CreateCustomerController controller, CustomerModel customer)
	{
		this.controller=controller;
		currentCustomer=customer;
		
		StackPane root = new StackPane();
		root.setId("view_screen");
		root.setAlignment(Pos.CENTER);
		
		VBox content = createCustomerInfoGrid();
		content.setId("view_screen");
		content.setAlignment(Pos.CENTER);
		
		root.getChildren().add(content);
		
		return root;
	}
	
	private VBox createCustomerInfoGrid()
	{
		VBox content = new VBox();
		
		GridPane customerInformationGrid=new GridPane();
		customerInformationGrid.setHgap(10);
		customerInformationGrid.setAlignment(Pos.CENTER);
		
		Label customerInformationHeader=new Label("Kundeinformation :");
		customerInformationHeader.setId("part_header_label");
		
		Label customerFirstNameHeader=new Label("Fornavn");
		customerFirstNameHeader.setId("create_customer_label");
		
		TextField customerFirstNameTextField=new TextField();
		customerFirstNameTextField.textProperty().bindBidirectional(currentCustomer.firstNameProperty());
		customerFirstNameTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches(".{0,32}")) {
                	customerFirstNameTextField.setText(oldValue);
                }
            }
        });
		
		Label customerLastNameHeader=new Label("Efternavn");
		customerLastNameHeader.setId("create_customer_label");
		
		TextField customerLastNameTextField=new TextField();
		customerLastNameTextField.textProperty().bindBidirectional(currentCustomer.surNameProperty());
		customerLastNameTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches(".{0,32}")) {
                	customerLastNameTextField.setText(oldValue);
                }
            }
        });
		
		Label customerAdressHeader=new Label("Addresse");
		customerAdressHeader.setId("create_customer_label");
		
		TextField customerAdressTextField=new TextField();
		customerAdressTextField.textProperty().bindBidirectional(currentCustomer.address());
		customerAdressTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches(".{0,32}")) {
                	customerAdressTextField.setText(oldValue);
                }
            }
        });
		
		Label customerphoneHeader=new Label("Tlf. nr");
		customerphoneHeader.setId("create_customer_label");
		
		TextField customerPhoneTextField=new TextField();
		customerPhoneTextField.textProperty().bindBidirectional(currentCustomer.phoneNumber());
		customerPhoneTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,20}")) {
                	customerPhoneTextField.setText(oldValue);
                }
            }
        });
		
		Label customerCPRHeader=new Label("CPR nr.");
		customerCPRHeader.setId("create_customer_label");
		
		TextField customerCPRTextField=new TextField();
		customerCPRTextField.textProperty().bindBidirectional(currentCustomer.sSN());
		customerCPRTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,10}")) {
                	customerCPRTextField.setText(oldValue);
                }
            }
        });
		
		Label customerPostalCodeHeader=new Label("Post nr.");
		customerPostalCodeHeader.setId("create_customer_label");
		
		TextField customerPostalCodeTextField=new TextField();
		customerPostalCodeTextField.textProperty().bindBidirectional(currentCustomer.zipCode());
		customerPostalCodeTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,10}")) {
                	customerPostalCodeTextField.setText(oldValue);
                }
            }
        });
		
		Label customerEmailCodeHeader=new Label("Email");
		customerEmailCodeHeader.setId("create_customer_label");
		
		TextField customerEmailTextField=new TextField();
		customerEmailTextField.textProperty().bindBidirectional(currentCustomer.email());
		customerEmailTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches(".{0,50}")) {
                	customerEmailTextField.setText(oldValue);
                }
            }
        });
		
		Label customerCityCodeHeader=new Label("By");
		customerCityCodeHeader.setId("create_customer_label");
		
		TextField customerCityTextField=new TextField();
		customerCityTextField.textProperty().bindBidirectional(currentCustomer.city());
		customerCityTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches(".{0,32}")) {
                	customerCityTextField.setText(oldValue);
                }
            }
        });
		
		Label customerCountryHeader=new Label("Land");
		customerCountryHeader.setId("create_customer_label");
		
		TextField customerCountryTextField=new TextField();
		customerCountryTextField.textProperty().bindBidirectional(currentCustomer.country());
		customerCountryTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches(".{0,32}")) {
                	customerCountryTextField.setText(oldValue);
                }
            }
        });
		
		
		customerInformationGrid.add(customerInformationHeader, 0, 0);
		customerInformationGrid.add(customerFirstNameHeader, 0, 1);
		customerInformationGrid.add(customerFirstNameTextField, 0, 2);
		customerInformationGrid.add(customerLastNameHeader, 1, 1);
		customerInformationGrid.add(customerLastNameTextField, 1, 2);
		customerInformationGrid.add(customerAdressHeader, 0, 3);
		customerInformationGrid.add(customerAdressTextField, 0, 4);
		customerInformationGrid.add(customerCPRHeader, 1, 3);
		customerInformationGrid.add(customerCPRTextField, 1, 4);
		customerInformationGrid.add(customerPostalCodeHeader, 0, 5);
		customerInformationGrid.add(customerPostalCodeTextField, 0, 6);
		customerInformationGrid.add(customerEmailCodeHeader, 1, 5);
		customerInformationGrid.add(customerEmailTextField, 1, 6);
		customerInformationGrid.add(customerCityCodeHeader, 0, 7);
		customerInformationGrid.add(customerCityTextField, 0, 8);
		customerInformationGrid.add(customerphoneHeader, 1, 7);
		customerInformationGrid.add(customerPhoneTextField, 1, 8);
		customerInformationGrid.add(customerCountryHeader, 0, 9);
		customerInformationGrid.add(customerCountryTextField, 0, 10);
		
		content.getChildren().add(customerInformationGrid);
		
		//**********buttons*****************
		HBox buttonHolder=new HBox();
		buttonHolder.setAlignment(Pos.CENTER);
		content.getChildren().add(buttonHolder);
		
		Button createCustomer = new Button("Opret Kunde");
		createCustomer.setId("view_button");
		
		createCustomer.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	controller.createCustomerPressed(currentCustomer);
		    }
		});
		
		Button cancelButton = new Button("Annuller");
		cancelButton.setId("view_button");
		cancelButton.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	controller.closeTab();
		    }
		});
		
		buttonHolder.getChildren().add(createCustomer);
		buttonHolder.getChildren().add(cancelButton);
		HBox.setMargin(createCustomer, new Insets(6, 6, 6, 0));
		HBox.setMargin(cancelButton, new Insets(6));
		
		return content;
	}
}