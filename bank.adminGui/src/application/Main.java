package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			GridPane layout = new GridPane();
			BorderPane root = new BorderPane();
			Scene scene = new Scene(layout, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
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
					System.out.println(":)");
				};
			});

			stage.setScene(scene);
			
			//Centers the scene
			Rectangle2D pSB = Screen.getPrimary().getVisualBounds();
			stage.setX((pSB.getMaxX() / 2) - (scene.getWidth() / 2));
			stage.setY((pSB.getMaxY() / 2) - (scene.getHeight() / 2));

			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
