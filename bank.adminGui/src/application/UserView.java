package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UserView {

	public static Scene getScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);
		
		Button createUser = new Button("Opret Bruger");
		createUser.setMinWidth(scene.getWidth() / 2 - 70);
		createUser.setMinHeight(scene.getHeight() / 2 - 50);
		createUser.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px" );
		layout.setMargin(createUser, new Insets(0, 50, 35, 0));
		layout.add(createUser, 1, 1);
		
		Button getUser = new Button("Se Bruger");
		getUser.setMinWidth(scene.getWidth() / 2 - 30);
		getUser.setMinHeight(scene.getHeight() / 2 - 50);
		getUser.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px");
		layout.setMargin(getUser, new Insets(0, 0, 35, 50));
		layout.add(getUser, 2, 1);
		
		Button updateUser = new Button("Opdater Bruger");
		updateUser.setMinWidth(scene.getWidth() / 2 - 70);
		updateUser.setMinHeight(scene.getHeight() / 2 - 50);
		updateUser.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px");
		layout.setMargin(updateUser, new Insets(34, 50, 0, 0));
		layout.add(updateUser, 1, 3);
		
		Button deleteUser = new Button("Slet Bank");
		deleteUser.setMinWidth(scene.getWidth() / 2 - 30);
		deleteUser.setMinHeight(scene.getHeight() / 2 - 50);
		deleteUser.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px");
		layout.setMargin(deleteUser, new Insets(34, 0, 0, 50));
		layout.add(deleteUser, 2, 3);
		
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
