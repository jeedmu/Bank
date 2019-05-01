package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
		
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setScene(Main.getScene(stage));
			};
		});
		
		return scene;
	}
}
