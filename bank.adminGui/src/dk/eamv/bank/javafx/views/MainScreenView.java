package dk.eamv.bank.javafx.views;

import dk.eamv.bank.javafx.controllers.MainScreenController;
import dk.eamv.bank.javafx.domain.User;
import dk.eamv.bank.javafx.interfaces.ITabPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class MainScreenView 
{
	private MainScreenController controller;
	private Label currentUserLabel;
	private BorderPane root;
	private TabPane tabPane;
	
	public MainScreenView(MainScreenController controller)
	{
		this.controller = controller;
	}
	
	public Scene createMainScreenScene()
	{
		root = new BorderPane();
		
		HBox topMenuContainer= new HBox();
		topMenuContainer.setId("top_bar");
		currentUserLabel=new Label("Medarbejder profil:");
		
		topMenuContainer.getChildren().add(currentUserLabel);
		
		Hyperlink changeLoginLink=new Hyperlink("Skift medarbejder");
		changeLoginLink.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	controller.openLoginScreenPressed();
		    }
		});
		
		topMenuContainer.getChildren().add(changeLoginLink);
		topMenuContainer.setPrefHeight(26);
		topMenuContainer.setAlignment(Pos.CENTER_RIGHT);

		HBox bottomPartContainer= new HBox();
		bottomPartContainer.setId("bottom_bar");
		bottomPartContainer.setPrefHeight(26);
		
		//create left actionMenu
		VBox actionMenu= new VBox();
		actionMenu.setPrefWidth(180);
		actionMenu.setId("menu_backdrop");
		actionMenu.setAlignment(Pos.TOP_CENTER);
		actionMenu.setPadding(new Insets(12, 0 ,0 ,0));
		
		//create actionbuttons
		Button searchCustomerButton= new Button("Find Kunde");
		searchCustomerButton.setId("menu_button");
		searchCustomerButton.setPadding(new Insets(4));
		searchCustomerButton.setPrefSize(120, 30);
		
		searchCustomerButton.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	controller.openSearchCustomer();
		    }
		});
		
		actionMenu.getChildren().add(searchCustomerButton);
		actionMenu.setMargin(searchCustomerButton, new Insets(6, 0, 6, 0));
		
		
		Button createCustomerButton= new Button("Opret Kunde");
		createCustomerButton.setId("menu_button");
		createCustomerButton.setPadding(new Insets(4));
		createCustomerButton.setPrefSize(120, 30);
		
		createCustomerButton.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	controller.createCustomer();
		    }
		});
		
		actionMenu.getChildren().add(createCustomerButton);
		actionMenu.setMargin(createCustomerButton, new Insets(6, 0, 6, 0));
		
		tabPane=new TabPane();
		
		root.setTop(topMenuContainer);
		root.setBottom(bottomPartContainer);
		root.setLeft(actionMenu);
		root.setCenter(tabPane);
				
		//set scene
		Scene scene = new Scene(root,960,600);
		scene.getStylesheets().add(getClass().getResource("appStyle.css").toExternalForm());
		
		return scene;
	}
	
	public void setView(Tab tab)
	{
		tabPane.getTabs().add(tab);
		tabPane.getSelectionModel().select(tab);
	}
	
	public void setCurrentUserField(User newUser)
	{
		
		currentUserLabel.setText("Sælger profil: "+newUser.getName());
	}
	
	public void closeTab(Tab tab)
	{
		tabPane.getTabs().remove(tab);
	}
}
