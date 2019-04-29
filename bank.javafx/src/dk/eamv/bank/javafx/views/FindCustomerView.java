package dk.eamv.bank.javafx.views;

import dk.eamv.bank.javafx.controllers.FindCustomerController;
import dk.eamv.bank.javafx.domain.Customer;
import dk.eamv.bank.javafx.interfaces.ITabPane;
import dk.eamv.bank.javafx.viewModels.CustomerModel;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;


public class FindCustomerView
{
	private FindCustomerController controller;
	private TableView<CustomerModel> table;
	
	public StackPane getSceneGUI(FindCustomerController controller)
	{
		this.controller=controller;
		
		StackPane root = new StackPane();
		root.setId("view_screen");
		
		VBox holder= new VBox();
		holder.setId("view_screen");
		
		holder.getChildren().add(getSearchArea());
		table = constructTable();
		holder.getChildren().add(table);
		holder.getChildren().add(createButtonContainer());
		
		root.getChildren().add(holder);
		
		return root;
	}
	
	public GridPane getSearchArea()
	{
		GridPane searchArea = new GridPane();
		
		Label nameHeaderLabel=new Label("Navn");
		nameHeaderLabel.setId("create_customer_label");
		
		TextField nameSearchTextField=new TextField();	
		
		Label phoneHeaderLabel=new Label("Tlf. nr.");
		phoneHeaderLabel.setId("create_customer_label");
		
		TextField phoneSearchTextField=new TextField();
		
		Label idHeaderLabel=new Label("Kundenr");
		idHeaderLabel.setId("create_customer_label");
		
		TextField idSearchTextField=new TextField();
		
		
		Button searchButton = new Button("Søg");
		searchButton.setId("view_button");
		searchButton.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	controller.updateTableView(table, idSearchTextField.getText(), nameSearchTextField.getText(), phoneSearchTextField.getText());
		    }
		});
		
		searchArea.add(nameHeaderLabel, 0, 0);
		searchArea.add(nameSearchTextField, 0, 1);
		searchArea.add(phoneHeaderLabel, 1, 0);
		searchArea.add(phoneSearchTextField, 1, 1);
		searchArea.add(idHeaderLabel, 2, 0);
		searchArea.add(idSearchTextField, 2, 1);
		searchArea.add(searchButton, 3, 1);
		
		return searchArea;
	}
	
	public HBox createButtonContainer()
	{
		HBox buttons = new HBox();
		
		Button viewAccountButton = new Button("Se konto");
		viewAccountButton.setId("view_button");
		viewAccountButton.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	CustomerModel customer=table.getSelectionModel().getSelectedItem();
		    	if(customer!=null)
		    		controller.viewAccountsPressed(customer);
		    }
		});
		
		
		Button editButton = new Button("Redigere");
		editButton.setId("view_button");
		editButton.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	CustomerModel customer=table.getSelectionModel().getSelectedItem();
		    	if(customer!=null)
		    		controller.editCustomerPressed(customer);
		    }
		});
		
		
		Button cancelButton = new Button("luk");
		cancelButton.setId("view_button");
		cancelButton.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	controller.closeTab();
		    }
		});
		
		
		buttons.getChildren().add(viewAccountButton);
		buttons.getChildren().add(editButton);
		buttons.getChildren().add(cancelButton);
		
		return buttons;
	}

	
	public TableView<CustomerModel> constructTable()
	{
		TableView<CustomerModel> newTable = new TableView<CustomerModel>();
		
		TableColumn<CustomerModel, String> customerIdCol = new TableColumn<CustomerModel, String>("Kunde id");
		customerIdCol.setCellValueFactory(new PropertyValueFactory<CustomerModel,String>("costumerID"));
		
		TableColumn<CustomerModel, String> firstNameCol = new TableColumn<CustomerModel, String>("Fornavn");
		firstNameCol.setCellValueFactory(new PropertyValueFactory<CustomerModel,String>("firstName"));
		
		TableColumn<CustomerModel, String> lastNameCol = new TableColumn<CustomerModel, String>("Efternavn");
		lastNameCol.setCellValueFactory(new PropertyValueFactory<CustomerModel,String>("surName"));
		
		TableColumn<CustomerModel, String> addressCol = new TableColumn<CustomerModel, String>("Adresse");
		addressCol.setCellValueFactory(new PropertyValueFactory<CustomerModel,String>("address"));
		
		TableColumn<CustomerModel, String> cityCol = new TableColumn<CustomerModel, String>("By");
		cityCol.setCellValueFactory(new PropertyValueFactory<CustomerModel,String>("city"));
		
		TableColumn<CustomerModel, String> zipCol = new TableColumn<CustomerModel, String>("Postnr");
		zipCol.setCellValueFactory(new PropertyValueFactory<CustomerModel,String>("zipCode"));
		
		TableColumn<CustomerModel, String> phoneCol = new TableColumn<CustomerModel, String>("Tlf. nr.");
		phoneCol.setCellValueFactory(new PropertyValueFactory<CustomerModel,String>("phoneNumber"));
		
		TableColumn<CustomerModel, String> emailCol = new TableColumn<CustomerModel, String>("Email");
		emailCol.setCellValueFactory(new PropertyValueFactory<CustomerModel,String>("email"));
		
		newTable.getColumns().addAll(customerIdCol,firstNameCol, lastNameCol, addressCol, cityCol, zipCol, phoneCol, emailCol);
		
		return newTable;
	}
}
