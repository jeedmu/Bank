package dk.eamv.bank.javafx.views;

import dk.eamv.bank.javafx.controllers.CreatePropertyController;
import dk.eamv.bank.javafx.viewModels.PropertyModel;
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

public class CreatePropertyView {
	
	private CreatePropertyController controller;
	private PropertyModel property;
	
	public StackPane getSceneGUI(CreatePropertyController controller, PropertyModel property) {
		this.controller = controller;
		this.property = property;
		
		StackPane root = new StackPane();
		root.setId("view_screen");
		root.setAlignment(Pos.CENTER);
		
		VBox content = createPropertyEntryGrid();
		content.setId("view_screen");
		content.setAlignment(Pos.CENTER);
		
		root.getChildren().add(content);
		
		return root;
	}
	
	public VBox createPropertyEntryGrid() {
		VBox content = new VBox();
		
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setAlignment(Pos.CENTER);
		
		Label header = new Label("Property Oplysninger");
		header.setStyle("-fx-font-weight: bold");
		
		Label propName = new Label("Property Navn:");
		TextField propNameText = new TextField();
		propNameText.textProperty().bindBidirectional(property.property());
		
		Label propValue = new Label("Property Værdi:");
		TextField propValueText = new TextField();
		propValueText.textProperty().bindBidirectional(property.value());
		
		pane.add(header, 1, 1);
		pane.add(propName, 1, 3);
		pane.add(propNameText, 2, 3);
		pane.add(propValue, 1, 5);
		pane.add(propValueText, 2, 5);
		
		content.getChildren().add(pane);
		
		HBox buttonHolder=new HBox();
		buttonHolder.setAlignment(Pos.CENTER);
		
		Button createProperty = new Button("Opret Property");
		createProperty.setId("view_button");
		
		createProperty.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	controller.createPropertyPressed(property);
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
		
		buttonHolder.getChildren().add(createProperty);
		buttonHolder.getChildren().add(cancelButton);
		HBox.setMargin(createProperty, new Insets(6, 6, 6, 0));
		HBox.setMargin(cancelButton, new Insets(6));
		
		return content;
	}
}
