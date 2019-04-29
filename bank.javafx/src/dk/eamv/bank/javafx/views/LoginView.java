package dk.eamv.bank.javafx.views;

import dk.eamv.bank.javafx.controllers.LoginController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class LoginView 
{
private LoginController theController;
	
	public Scene getSceneGUI(LoginController controller)
	{
		theController=controller;
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(25, 25, 25, 25));
	
		//add username and textfield
		Label userNameLabel = new Label("Medarbejder ID:");
		root.add(userNameLabel, 0, 0);

		TextField userTextField = new TextField();
		root.add(userTextField, 1, 0);

		//add password and password field
		Label passwordLabel = new Label("Password:");
		root.add(passwordLabel, 0, 1);

		PasswordField passwordField = new PasswordField();
		root.add(passwordField, 1, 1);
		Label warningLabel = new Label("Forkert brugernavn eller password");
		
		//add login button
		Button loginButton = new Button("Login");
		loginButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) 
		    {
		       if(theController.login(userTextField.getText(), passwordField.getText())==false && !root.getChildren().contains(warningLabel))
		       {
		   		root.add(warningLabel, 0, 4, 2,1);
		       }
		    }
		});
		//add cancel button
		Button cancelButton = new Button("Cancel");
		cancelButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	theController.cancelLogin();
		    }
		});
		
		HBox hbButtonHolder = new HBox(10);
		hbButtonHolder.setAlignment(Pos.BOTTOM_RIGHT);
		hbButtonHolder.getChildren().add(loginButton);
		hbButtonHolder.getChildren().add(cancelButton);
		root.add(hbButtonHolder, 1, 3);
		
		//add cancel button
		Scene scene= new Scene(root, 400, 200);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e)
			{
			    if (e.getCode() == KeyCode.ENTER) {
			        loginButton.fire();
			    }						
			}
		});
		
		return scene;
	}
}
