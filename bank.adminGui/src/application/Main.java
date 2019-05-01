package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static Scene getScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);
	
		Button bankBtn = new Button("Bank Menu");
		bankBtn.setMinWidth(scene.getWidth() / 2 - 70);
		bankBtn.setMinHeight(scene.getHeight() / 2 - 50);
		bankBtn.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px" );
		layout.setMargin(bankBtn, new Insets(0, 50, 50, 0));
		layout.add(bankBtn, 1, 1);
		
		Button propertyBtn = new Button("Property Menu");
		propertyBtn.setMinWidth(scene.getWidth() / 2 - 30);
		propertyBtn.setMinHeight(scene.getHeight() / 2 - 50);
		propertyBtn.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px");
		layout.setMargin(propertyBtn, new Insets(0, 0, 50, 50));
		layout.add(propertyBtn, 2, 1);
		
		Button roleBtn = new Button("Role Menu");
		roleBtn.setMinWidth(scene.getWidth() / 2 - 70);
		roleBtn.setMinHeight(scene.getHeight() / 2 - 50);
		roleBtn.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px");
		layout.setMargin(roleBtn, new Insets(50, 50, 0, 0));
		layout.add(roleBtn, 1, 2);
		
		Button userBtn = new Button("User Menu");
		userBtn.setMinWidth(scene.getWidth() / 2 - 30);
		userBtn.setMinHeight(scene.getHeight() / 2 - 50);
		userBtn.setStyle("-fx-background-color: #F40101; -fx-text-fill: white; -fx-font-size: 30px");
		layout.setMargin(userBtn, new Insets(50, 0, 0, 50));
		layout.add(userBtn, 2, 2);
				
		bankBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Bankmenu");
				stage.setScene(BankView.getScene(stage));
			};
		});
		
		userBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Brugermenu");
				stage.setScene(UserView.getScene(stage));
			};
		});
		
		roleBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Rollemenu");
				stage.setScene(RoleView.getScene(stage));
			};
		});
		
		propertyBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Propertymenu");
				stage.setScene(PropertyView.getScene(stage));
			};
		});
		
		return scene;
	}
	
	@Override
	public void start(Stage stage) {
		try {
			Scene scene = getScene(stage);
			stage.setScene(scene);
			
			//Centers the scene
			Rectangle2D pSB = Screen.getPrimary().getVisualBounds();
			stage.setX((pSB.getMaxX() / 2) - (scene.getWidth() / 2));
			stage.setY((pSB.getMaxY() / 2) - (scene.getHeight() / 2));
			stage.setTitle("Hovedmenu");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
