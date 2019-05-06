package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PropertyView {
	public static Scene getScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);
		
		Button createProperty = new Button("Opret Property");
		createProperty.setMinWidth(scene.getWidth() / 2 - 70);
		createProperty.setMinHeight(scene.getHeight() / 2 - 50);
		createProperty.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px" );
		layout.setMargin(createProperty, new Insets(0, 50, 35, 0));
		layout.add(createProperty, 1, 1);
		
		Button getProperty = new Button("Se Property");
		getProperty.setMinWidth(scene.getWidth() / 2 - 30);
		getProperty.setMinHeight(scene.getHeight() / 2 - 50);
		getProperty.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px");
		layout.setMargin(getProperty, new Insets(0, 0, 35, 50));
		layout.add(getProperty, 2, 1);
		
		Button updateProperty = new Button("Opdater Property");
		updateProperty.setMinWidth(scene.getWidth() / 2 - 70);
		updateProperty.setMinHeight(scene.getHeight() / 2 - 50);
		updateProperty.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px");
		layout.setMargin(updateProperty, new Insets(34, 50, 0, 0));
		layout.add(updateProperty, 1, 3);
		
		Button deleteProperty = new Button("Slet Property");
		deleteProperty.setMinWidth(scene.getWidth() / 2 - 30);
		deleteProperty.setMinHeight(scene.getHeight() / 2 - 50);
		deleteProperty.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px");
		layout.setMargin(deleteProperty, new Insets(34, 0, 0, 50));
		layout.add(deleteProperty, 2, 3);
		
		Button backButton = new Button("Tilbage");
		layout.add(backButton, 1, 2);
		
		
		createProperty.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Opret Property");
				stage.setScene(getCreatePropertyScene(stage));
			};
		});
		
		updateProperty.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Opdater Property");
				stage.setScene(getUpdatePropertyScene(stage));
			};
		});
		
		getProperty.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Se Property");
				stage.setScene(getSearchPropertyScene(stage));
			};
		});
		
		deleteProperty.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Delete Property");
				stage.setScene(getDeletePropertyScene(stage));
			};
		});
		
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Hovedmenu");
				stage.setScene(Main.getScene(stage));
			};
		});
		
		return scene;
	}
	
	private static Scene getCreatePropertyScene(Stage stage) {
	GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);
		
		Label headerLabel = new Label("Opret Property");
		headerLabel.setStyle("-fx-font-weight:bold; -fx-font-size:36px"); 
		layout.setMargin(headerLabel, new Insets(0, 0, 40, 0));
		
		Label propertyName = new Label("Property navn:");
		layout.setMargin(propertyName, new Insets(0, 20, 15, 0));
		TextField propertyNameTF = new TextField();
		layout.setMargin(propertyNameTF, new Insets(0, 0, 15, 0));
		
		Label value = new Label("Værdi:");
		layout.setMargin(value, new Insets(0, 20, 15, 0));
		TextField valueTF = new TextField();
		layout.setMargin(valueTF, new Insets(0, 0, 15, 0));
		
		Button backBtn = new Button("Tilbage");
		layout.setMargin(backBtn, new Insets(15, 0, 0, 0));
		Button updateBtn = new Button("Gem property");
		layout.setMargin(updateBtn, new Insets(15, 10, 0, 0));
		
		layout.add(headerLabel, 3, 1);
		layout.add(propertyName, 2, 4);
		layout.add(propertyNameTF, 3, 4);
		layout.add(value, 2, 6);
		layout.add(valueTF, 3, 6);
		layout.add(backBtn, 3, 8);
		layout.add(updateBtn, 2, 8);
		layout.setAlignment(Pos.TOP_CENTER);

		backBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Propertymenu");
				stage.setScene(PropertyView.getScene(stage));
			};
		});
		return scene;
	}
	
	private static Scene getUpdatePropertyScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);
		
		Label headerLabel = new Label("Opdater Property");
		headerLabel.setStyle("-fx-font-weight:bold; -fx-font-size:36px"); 
		layout.setMargin(headerLabel, new Insets(0, 0, 40, 0));
		
		Label propertyName = new Label("Property navn:");
		layout.setMargin(propertyName, new Insets(0, 20, 15, 0));
		TextField propertyNameTF = new TextField();
		layout.setMargin(propertyNameTF, new Insets(0, 0, 15, 0));
		
		Label value = new Label("Værdi:");
		layout.setMargin(value, new Insets(0, 20, 15, 0));
		TextField valueTF = new TextField();
		layout.setMargin(valueTF, new Insets(0, 0, 15, 0));
		
		Button backBtn = new Button("Tilbage");
		layout.setMargin(backBtn, new Insets(15, 0, 0, 0));
		Button updateBtn = new Button("Opdater property");
		layout.setMargin(updateBtn, new Insets(15, 10, 0, 0));
		
		layout.add(headerLabel, 3, 1);
		layout.add(propertyName, 2, 4);
		layout.add(propertyNameTF, 3, 4);
		layout.add(value, 2, 6);
		layout.add(valueTF, 3, 6);
		layout.add(backBtn, 3, 8);
		layout.add(updateBtn, 2, 8);
		layout.setAlignment(Pos.TOP_CENTER);

		backBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Propertymenu");
				stage.setScene(PropertyView.getScene(stage));
			};
		});
		return scene;
	}
	
	private static Scene getSearchPropertyScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);
		
		Label headerLabel = new Label("Se Property");
		headerLabel.setStyle("-fx-font-weight:bold; -fx-font-size:36px"); 
		layout.setMargin(headerLabel, new Insets(0, 0, 40, 0));
		Label searchTerm = new Label("Søg:");
		layout.setMargin(searchTerm, new Insets(0, 20, 15, 0));
		TextField searchTermTF = new TextField();
		layout.setMargin(searchTermTF, new Insets(0, 0, 15, 0));
		
		Button searchBtn = new Button("Søg");
		layout.setMargin(searchBtn, new Insets(15, 10, 0, 0));
		Button backBtn = new Button("Tilbage");
		layout.setMargin(backBtn, new Insets(15, 0, 0, 0));
		
		layout.add(headerLabel, 3, 1);
		layout.add(searchTerm, 2, 4);
		layout.add(searchTermTF, 3, 4);
		layout.add(backBtn, 3, 10);
		layout.add(searchBtn, 2, 10);
		layout.setAlignment(Pos.TOP_CENTER);
		
		backBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Proprtymenu");
				stage.setScene(PropertyView.getScene(stage));
			};
		});
		return scene;
	}
	
	private static Scene getDeletePropertyScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);
		
		Label headerLabel = new Label("Slet Property");
		headerLabel.setStyle("-fx-font-weight:bold; -fx-font-size:36px"); 
		layout.setMargin(headerLabel, new Insets(0, 0, 25, 0));
		Label searchTerm = new Label("Søg:");
		layout.setMargin(searchTerm, new Insets(0, 20, 15, 0));
		TextField searchTermTF = new TextField();
		layout.setMargin(searchTermTF, new Insets(0, 0, 15, 0));
		
		Button searchBtn = new Button("Søg");
		layout.setMargin(searchBtn, new Insets(15, 10, 0, 0));
		Button backBtn = new Button("Tilbage");
		layout.setMargin(backBtn, new Insets(15, 0, 0, 0));
		
		layout.add(headerLabel, 3, 1);
		layout.add(searchTerm, 2, 4);
		layout.add(searchTermTF, 3, 4);
		layout.add(backBtn, 3, 10);
		layout.add(searchBtn, 2, 10);
		layout.setAlignment(Pos.TOP_CENTER);
		
		backBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Proprtymenu");
				stage.setScene(PropertyView.getScene(stage));
			};
		});
		return scene;
	}
}
