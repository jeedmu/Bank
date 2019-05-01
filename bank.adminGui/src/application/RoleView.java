package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RoleView {

	public static Scene getScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);
		
		Button createRole = new Button("Opret Rolle");
		createRole.setMinWidth(scene.getWidth() / 2 - 70);
		createRole.setMinHeight(scene.getHeight() / 2 - 50);
		createRole.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px" );
		layout.setMargin(createRole, new Insets(0, 50, 35, 0));
		layout.add(createRole, 1, 1);
		
		Button getRole = new Button("Se Rolle");
		getRole.setMinWidth(scene.getWidth() / 2 - 30);
		getRole.setMinHeight(scene.getHeight() / 2 - 50);
		getRole.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px");
		layout.setMargin(getRole, new Insets(0, 0, 35, 50));
		layout.add(getRole, 2, 1);
		
		Button updateRole = new Button("Opdater Rolle");
		updateRole.setMinWidth(scene.getWidth() / 2 - 70);
		updateRole.setMinHeight(scene.getHeight() / 2 - 50);
		updateRole.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px");
		layout.setMargin(updateRole, new Insets(34, 50, 0, 0));
		layout.add(updateRole, 1, 3);
		
		Button deleteRole = new Button("Slet Rolle");
		deleteRole.setMinWidth(scene.getWidth() / 2 - 30);
		deleteRole.setMinHeight(scene.getHeight() / 2 - 50);
		deleteRole.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px");
		layout.setMargin(deleteRole, new Insets(34, 0, 0, 50));
		layout.add(deleteRole, 2, 3);
		
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
