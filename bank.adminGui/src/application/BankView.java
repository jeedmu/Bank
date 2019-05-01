package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BankView {

	public static Scene getScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);
		
		Button createBank = new Button("Opret Bank");
		createBank.setMinWidth(scene.getWidth() / 2 - 70);
		createBank.setMinHeight(scene.getHeight() / 2 - 50);
		createBank.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px" );
		layout.setMargin(createBank, new Insets(0, 50, 35, 0));
		layout.add(createBank, 1, 1);
		
		Button getBank = new Button("Se Bank");
		getBank.setMinWidth(scene.getWidth() / 2 - 30);
		getBank.setMinHeight(scene.getHeight() / 2 - 50);
		getBank.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px");
		layout.setMargin(getBank, new Insets(0, 0, 35, 50));
		layout.add(getBank, 2, 1);
		
		Button updateBank = new Button("Opdater Bank");
		updateBank.setMinWidth(scene.getWidth() / 2 - 70);
		updateBank.setMinHeight(scene.getHeight() / 2 - 50);
		updateBank.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px");
		layout.setMargin(updateBank, new Insets(34, 50, 0, 0));
		layout.add(updateBank, 1, 3);
		
		Button deleteBank = new Button("Slet Bank");
		deleteBank.setMinWidth(scene.getWidth() / 2 - 30);
		deleteBank.setMinHeight(scene.getHeight() / 2 - 50);
		deleteBank.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px");
		layout.setMargin(deleteBank, new Insets(34, 0, 0, 50));
		layout.add(deleteBank, 2, 3);
		
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
