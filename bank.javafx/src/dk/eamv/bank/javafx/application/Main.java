package dk.eamv.bank.javafx.application;
	
import java.net.URI;
import sun.net.www.http.HttpClient;
import dk.eamv.bank.javafx.Implementations.DataRequestHandler;
import dk.eamv.bank.javafx.controllers.ControllerHandler;
import dk.eamv.bank.javafx.controllers.MainScreenController;
import dk.eamv.bank.javafx.views.MainScreenView;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setResizable(false);
			primaryStage.setScene(ControllerHandler.INSTANCE.createMainScene());
			setupStage(primaryStage);
			primaryStage.show();
			
			ControllerHandler.INSTANCE.startLoginScreen();
		} catch(Exception e) {
			e.printStackTrace();
		}
				
	}
	
	public static void main(String[] args) {
		DataRequestHandler h = new DataRequestHandler();
		System.out.println(h.getCustomers(null, null, ""));
		launch(args);
		
	}
	
	public void setupStage(Stage primaryStage)	{
		primaryStage.setTitle("Medarbejder Bank");
	}
}
