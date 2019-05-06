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
				stage.setTitle("Hovedmenu");
				stage.setScene(Main.getScene(stage));
			};
		});
		
		createRole.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Opret Rolle");
				stage.setScene(getCreateRoleScene(stage));
			};
		});
		
		updateRole.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Rediger Rolle");
				stage.setScene(getUpdateRoleScene(stage));
			};
		});
		
		return scene;
	}
	
	private static Scene getCreateRoleScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);
		
		Label headerLabel = new Label("Opret Rolle");
		headerLabel.setStyle("-fx-font-weight:bold; -fx-font-size:36px"); 
		layout.setMargin(headerLabel, new Insets(0, 0, 40, 0));
		
		Label roleID = new Label("Rolle ID:");
		layout.setMargin(roleID, new Insets(0, 20, 15, 0));
		TextField roleIDTF = new TextField();
		layout.setMargin(roleIDTF, new Insets(0, 0, 15, 0));
		
		Label roleName = new Label("Rollenavn:");
		layout.setMargin(roleName, new Insets(0, 20, 15, 0));
		TextField roleNameTF = new TextField();
		layout.setMargin(roleNameTF, new Insets(0, 0, 15, 0));

		Button backBtn = new Button("Tilbage");
		layout.setMargin(backBtn, new Insets(100, 10, 0, 0));
		Button createBtn = new Button("Opret og gem");
		layout.setMargin(createBtn, new Insets(100, 0, 0, 0));
		
		layout.add(headerLabel, 3, 1);
		layout.add(roleID, 2, 4);
		layout.add(roleIDTF, 3, 4);
		layout.add(roleName, 2, 6);
		layout.add(roleNameTF, 3, 6);

		layout.add(backBtn, 2, 10);
		layout.add(createBtn, 3, 10);
		layout.setAlignment(Pos.TOP_CENTER);

		backBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Rollemenu");
				stage.setScene(UserView.getScene(stage));
			};
		});
		
		return scene;
	}
	
	private static Scene getUpdateRoleScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);
		
		Label headerLabel = new Label("Rediger Rolle");
		headerLabel.setStyle("-fx-font-weight:bold; -fx-font-size:36px"); 
		layout.setMargin(headerLabel, new Insets(0, 0, 40, 0));
		
		Label roleID = new Label("Rolle ID:");
		layout.setMargin(roleID, new Insets(0, 20, 15, 0));
		TextField roleIDTF = new TextField();
		layout.setMargin(roleIDTF, new Insets(0, 0, 15, 0));
		
		Label roleName = new Label("Rollenavn:");
		layout.setMargin(roleName, new Insets(0, 20, 15, 0));
		TextField roleNameTF = new TextField();
		layout.setMargin(roleNameTF, new Insets(0, 0, 15, 0));
		
		Button backBtn = new Button("Tilbage");
		layout.setMargin(backBtn, new Insets(100, 10, 0, 0));
		Button updateBtn = new Button("Gem bruger");
		layout.setMargin(updateBtn, new Insets(100, 0, 0, 0));
		
		layout.add(headerLabel, 3, 1);
		layout.add(roleID, 2, 4);
		layout.add(roleIDTF, 3, 4);
		layout.add(roleName, 2, 6);
		layout.add(roleNameTF, 3, 6);
		layout.add(backBtn, 2, 10);
		layout.add(updateBtn, 3, 10);
		layout.setAlignment(Pos.TOP_CENTER);

		backBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Rollemenu");
				stage.setScene(UserView.getScene(stage));
			};
		});
		
		return scene;
	}
}
