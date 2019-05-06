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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserView {

	public static Scene getScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);

		Button createUser = new Button("Opret Bruger");
		createUser.setMinWidth(scene.getWidth() / 2 - 70);
		createUser.setMinHeight(scene.getHeight() / 2 - 50);
		createUser.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px");
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

		Button deleteUser = new Button("Slet Bruger");
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
				stage.setTitle("Hovedmenu");
				stage.setScene(Main.getScene(stage));
			};
		});

		createUser.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				stage.setTitle("Opret Bruger");
				stage.setScene(getCreateUserScene(stage));
			};
		});

		updateUser.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				stage.setTitle("Rediger Bruger");
				stage.setScene(getUpdateUserScene(stage));
			};
		});

		deleteUser.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				stage.setTitle("Slet Bruger");
				stage.setScene(getDeleteUserScene(stage));
			};
		});
		
		getUser.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				stage.setTitle("Se Bruger");
				stage.setScene(getSearchUserScene(stage));
			};
		});

		return scene;
	}

	private static Scene getCreateUserScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);

		Label headerLabel = new Label("Opret Bruger");
		headerLabel.setStyle("-fx-font-weight:bold; -fx-font-size:36px");
		layout.setMargin(headerLabel, new Insets(0, 0, 40, 0));

		Label userID = new Label("Bruger ID:");
		layout.setMargin(userID, new Insets(0, 20, 15, 0));
		TextField userIDTF = new TextField();
		layout.setMargin(userIDTF, new Insets(0, 0, 15, 0));

		Label userName = new Label("Brugernavn:");
		layout.setMargin(userName, new Insets(0, 20, 15, 0));
		TextField userNameTF = new TextField();
		layout.setMargin(userNameTF, new Insets(0, 0, 15, 0));

		Label password = new Label("Kodeord:");
		layout.setMargin(password, new Insets(0, 20, 0, 0));
		TextField passwordTF = new TextField();

		Button backBtn = new Button("Tilbage");
		layout.setMargin(backBtn, new Insets(15, 0, 0, 0));
		Button createBtn = new Button("Opret og gem");
		layout.setMargin(createBtn, new Insets(15, 10, 0, 0));

		layout.add(headerLabel, 3, 1);
		layout.add(userID, 2, 4);
		layout.add(userIDTF, 3, 4);
		layout.add(userName, 2, 6);
		layout.add(userNameTF, 3, 6);
		layout.add(password, 2, 8);
		layout.add(passwordTF, 3, 8);
		layout.add(backBtn, 3, 10);
		layout.add(createBtn, 2, 10);
		layout.setAlignment(Pos.TOP_CENTER);

		backBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				stage.setTitle("Bankmenu");
				stage.setScene(UserView.getScene(stage));
			};
		});

		return scene;
	}

	private static Scene getUpdateUserScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);

		Label headerLabel = new Label("Rediger Bruger");
		headerLabel.setStyle("-fx-font-weight:bold; -fx-font-size:36px");
		layout.setMargin(headerLabel, new Insets(0, 0, 40, 0));

		Label userID = new Label("Bruger ID:");
		layout.setMargin(userID, new Insets(0, 20, 15, 0));
		TextField userIDTF = new TextField();
		layout.setMargin(userIDTF, new Insets(0, 0, 15, 0));

		Label userName = new Label("Brugernavn:");
		layout.setMargin(userName, new Insets(0, 20, 15, 0));
		TextField userNameTF = new TextField();
		layout.setMargin(userNameTF, new Insets(0, 0, 15, 0));

		Label password = new Label("Kodeord:");
		layout.setMargin(password, new Insets(0, 20, 0, 0));
		TextField passwordTF = new TextField();

		Button backBtn = new Button("Tilbage");
		layout.setMargin(backBtn, new Insets(15, 0, 0, 0));
		Button updateBtn = new Button("Gem bruger");
		layout.setMargin(updateBtn, new Insets(15, 10, 0, 0));

		layout.add(headerLabel, 3, 1);
		layout.add(userID, 2, 4);
		layout.add(userIDTF, 3, 4);
		layout.add(userName, 2, 6);
		layout.add(userNameTF, 3, 6);
		layout.add(password, 2, 8);
		layout.add(passwordTF, 3, 8);
		layout.add(backBtn, 3, 10);
		layout.add(updateBtn, 2, 10);
		layout.setAlignment(Pos.TOP_CENTER);

		backBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				stage.setTitle("Bankmenu");
				stage.setScene(UserView.getScene(stage));
			};
		});

		return scene;
	}

	private static Scene getDeleteUserScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);

		Label headerLabel = new Label("Slet Bruger");
		headerLabel.setStyle("-fx-font-weight:bold; -fx-font-size:36px");
		layout.setMargin(headerLabel, new Insets(0, 0, 40, 0));
		Label userName = new Label("Brugernavn:");
		layout.setMargin(userName, new Insets(0, 20, 15, 0));
		TextField userNameTF = new TextField();
		layout.setMargin(userNameTF, new Insets(0, 0, 15, 0));

		Button searchBtn = new Button("Søg");
		layout.setMargin(searchBtn, new Insets(15, 10, 0, 0));
		Button backBtn = new Button("Tilbage");
		layout.setMargin(backBtn, new Insets(15, 10, 0, 0));

		layout.add(headerLabel, 3, 1);
		layout.add(userName, 2, 4);
		layout.add(userNameTF, 3, 4);
		layout.add(searchBtn, 3, 10);
		layout.add(backBtn, 2, 10);
		layout.setAlignment(Pos.TOP_CENTER);

		backBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				stage.setTitle("Bankmenu");
				stage.setScene(UserView.getScene(stage));
			};
		});

		return scene;
	}
	
	private static Scene getSearchUserScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);

		Label headerLabel = new Label("Se Bruger");
		headerLabel.setStyle("-fx-font-weight:bold; -fx-font-size:36px");
		layout.setMargin(headerLabel, new Insets(0, 0, 40, 0));
		Label userName = new Label("Brugernavn:");
		layout.setMargin(userName, new Insets(0, 20, 15, 0));
		TextField userNameTF = new TextField();
		layout.setMargin(userNameTF, new Insets(0, 0, 15, 0));

		Button searchBtn = new Button("Søg");
		layout.setMargin(searchBtn, new Insets(15, 10, 0, 0));
		Button backBtn = new Button("Tilbage");
		layout.setMargin(backBtn, new Insets(15, 0, 0, 0));

		layout.add(headerLabel, 3, 1);
		layout.add(userName, 2, 4);
		layout.add(userNameTF, 3, 4);
		layout.add(searchBtn, 3, 10);
		layout.add(backBtn, 2, 10);
		layout.setAlignment(Pos.TOP_CENTER);

		backBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				stage.setTitle("Bankmenu");
				stage.setScene(UserView.getScene(stage));
			};
		});

		return scene;
	}
}
