package application;

import javafx.application.Application;
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
				stage.setTitle("Hovedmenu");
				stage.setScene(Main.getScene(stage));
			};
		});
		
		createBank.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Opret Bank");
				stage.setScene(getCreateBankScene(stage));
			};
		});
		
		updateBank.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Opdater Bank");
				stage.setScene(getUpdateBankScene(stage));
			};
		});
		
		getBank.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Se Bank");
				stage.setScene(getViewBankScene(stage));
			};
		});
		
		deleteBank.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Slet Bank");
				stage.setScene(getDeleteBankScene(stage));
			};
		});
		
		return scene;
	}
	
	
	
	private static Scene getCreateBankScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);
		
		Label headerLabel = new Label("Opret Bank");
		headerLabel.setStyle("-fx-font-weight:bold; -fx-font-size:36px"); 
		layout.setMargin(headerLabel, new Insets(0, 0, 40, 0));
		
		Label cVR = new Label("CVR:");
		layout.setMargin(cVR, new Insets(0, 20, 15, 0));
		TextField cVRTF = new TextField();
		layout.setMargin(cVRTF, new Insets(0, 0, 15, 0));
		
		Label bankName = new Label("Bank navn:");
		layout.setMargin(bankName, new Insets(0, 20, 15, 0));
		TextField bankNameTF = new TextField();
		layout.setMargin(bankNameTF, new Insets(0, 0, 15, 0));
		
		Label regNum = new Label("Reg nummer:");
		layout.setMargin(regNum, new Insets(0, 20, 15, 0));
		TextField regNumTF = new TextField();
		layout.setMargin(regNumTF, new Insets(0, 0, 15, 0));
		
		Label phoneNum = new Label("Telefon nummer:");
		layout.setMargin(phoneNum, new Insets(0, 20, 15, 0));
		TextField phoneNumTF = new TextField();
		layout.setMargin(phoneNumTF, new Insets(0, 0, 15, 0));
		
		Label accountNum = new Label("Konto nummer:");
		layout.setMargin(accountNum, new Insets(0, 20, 15, 0));
		TextField accountNumTF = new TextField();
		layout.setMargin(accountNumTF, new Insets(0, 0, 15, 0));
		
		Label zipCode = new Label("Postnummer:");
		layout.setMargin(zipCode, new Insets(0, 20, 15, 0));
		TextField zipCodeTF = new TextField();
		layout.setMargin(zipCodeTF, new Insets(0, 0, 15, 0));
		
		Label city = new Label("By:");
		layout.setMargin(city, new Insets(0, 20, 15, 0));
		TextField cityTF = new TextField();
		layout.setMargin(cityTF, new Insets(0, 0, 15, 0));
		
		Label address = new Label("Adresse:");
		layout.setMargin(address, new Insets(0, 20, 15, 0));
		TextField addressTF = new TextField();
		layout.setMargin(addressTF, new Insets(0, 0, 15, 0));
		
		Label country = new Label("Land:");
		layout.setMargin(country, new Insets(0, 20, 15, 0));
		TextField countryTF = new TextField();
		layout.setMargin(countryTF, new Insets(0, 0, 15, 0));



		Button backBtn = new Button("Tilbage");
		layout.setMargin(backBtn, new Insets(25, 0, 0, 0));
		Button createBtn = new Button("Opret og gem");
		layout.setMargin(createBtn, new Insets(25, 0, 0, 10));
		
		
		
		layout.add(headerLabel, 3, 1);
		layout.add(cVR, 2, 4);
		layout.add(cVRTF, 3, 4);
		layout.add(bankName, 2, 6);
		layout.add(bankNameTF, 3, 6);
		layout.add(regNum, 2, 8);
		layout.add(regNumTF, 3, 8);
		layout.add(phoneNum, 2, 10);
		layout.add(phoneNumTF, 3, 10);
		layout.add(accountNum, 2, 12);
		layout.add(accountNumTF, 3, 12);
		layout.add(zipCode, 2, 14);
		layout.add(zipCodeTF, 3, 14);
		layout.add(city, 2, 16);
		layout.add(cityTF, 3, 16);
		layout.add(address, 2, 18);
		layout.add(addressTF, 3, 18);
		layout.add(country, 2, 20);
		layout.add(countryTF, 3, 20);

		layout.add(createBtn, 2, 22);
		layout.add(backBtn, 3, 22);
		
		layout.setAlignment(Pos.TOP_CENTER);

		backBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Bankmenu");
				stage.setScene(BankView.getScene(stage));
			};
		});
		
		return scene;
	}
	
	private static Scene getUpdateBankScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);
		
		Label headerLabel = new Label("Rediger Bank");
		headerLabel.setStyle("-fx-font-weight:bold; -fx-font-size:36px"); 
		layout.setMargin(headerLabel, new Insets(0, 0, 40, 0));
		
		Label cVR = new Label("CVR:");
		layout.setMargin(cVR, new Insets(0, 20, 15, 0));
		TextField cVRTF = new TextField();
		layout.setMargin(cVRTF, new Insets(0, 0, 15, 0));
		
		Label bankName = new Label("Bank navn:");
		layout.setMargin(bankName, new Insets(0, 20, 15, 0));
		TextField bankNameTF = new TextField();
		layout.setMargin(bankNameTF, new Insets(0, 0, 15, 0));
		
		Label regNum = new Label("Reg nummer:");
		layout.setMargin(regNum, new Insets(0, 20, 15, 0));
		TextField regNumTF = new TextField();
		layout.setMargin(regNumTF, new Insets(0, 0, 15, 0));
		
		Label phoneNum = new Label("Telefon nummer:");
		layout.setMargin(phoneNum, new Insets(0, 20, 15, 0));
		TextField phoneNumTF = new TextField();
		layout.setMargin(phoneNumTF, new Insets(0, 0, 15, 0));
		
		Label accountNum = new Label("Konto nummer:");
		layout.setMargin(accountNum, new Insets(0, 20, 15, 0));
		TextField accountNumTF = new TextField();
		layout.setMargin(accountNumTF, new Insets(0, 0, 15, 0));
		
		Label zipCode = new Label("Postnummer:");
		layout.setMargin(zipCode, new Insets(0, 20, 15, 0));
		TextField zipCodeTF = new TextField();
		layout.setMargin(zipCodeTF, new Insets(0, 0, 15, 0));
		
		Label city = new Label("By:");
		layout.setMargin(city, new Insets(0, 20, 15, 0));
		TextField cityTF = new TextField();
		layout.setMargin(cityTF, new Insets(0, 0, 15, 0));
		
		Label address = new Label("Adresse:");
		layout.setMargin(address, new Insets(0, 20, 15, 0));
		TextField addressTF = new TextField();
		layout.setMargin(addressTF, new Insets(0, 0, 15, 0));
		
		Label country = new Label("Land:");
		layout.setMargin(country, new Insets(0, 20, 15, 0));
		TextField countryTF = new TextField();
		layout.setMargin(countryTF, new Insets(0, 0, 15, 0));



		Button backBtn = new Button("Tilbage");
		layout.setMargin(backBtn, new Insets(25, 0, 0, 0));
		Button createBtn = new Button("     Gem bank     ");
		layout.setMargin(createBtn, new Insets(25, 10, 0, 0));
		
		
		
		layout.add(headerLabel, 3, 1);
		layout.add(cVR, 2, 4);
		layout.add(cVRTF, 3, 4);
		layout.add(bankName, 2, 6);
		layout.add(bankNameTF, 3, 6);
		layout.add(regNum, 2, 8);
		layout.add(regNumTF, 3, 8);
		layout.add(phoneNum, 2, 10);
		layout.add(phoneNumTF, 3, 10);
		layout.add(accountNum, 2, 12);
		layout.add(accountNumTF, 3, 12);
		layout.add(zipCode, 2, 14);
		layout.add(zipCodeTF, 3, 14);
		layout.add(city, 2, 16);
		layout.add(cityTF, 3, 16);
		layout.add(address, 2, 18);
		layout.add(addressTF, 3, 18);
		layout.add(country, 2, 20);
		layout.add(countryTF, 3, 20);
		
		layout.add(createBtn, 2, 22);
		layout.add(backBtn, 3, 22);
		
		layout.setAlignment(Pos.TOP_CENTER);

		backBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Bankmenu");
				stage.setScene(getScene(stage));
			};
		});
		
		return scene;
	}
	
	private static Scene getViewBankScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);
		
		Label headerLabel = new Label("Se Bank");
		headerLabel.setStyle("-fx-font-weight:bold; -fx-font-size:36px"); 
		layout.setMargin(headerLabel, new Insets(0, 0, 40, 0));
		
		Label searchBank = new Label("Søg:");
		layout.setMargin(searchBank, new Insets(0, 20, 15, 0));
		TextField searchBankTF = new TextField();
		layout.setMargin(searchBankTF, new Insets(0, 0, 15, 0));
		
		Button searchBtn = new Button("Søg");
		layout.setMargin(searchBtn, new Insets(15, 10, 0, 0));
		Button backBtn = new Button("Tilbage");
		layout.setMargin(backBtn, new Insets(15, 0, 0, 0));
		
		layout.add(headerLabel, 3, 1);
		layout.add(searchBank, 2, 4);
		layout.add(searchBankTF, 3, 4);
		layout.add(backBtn, 3, 10);
		layout.add(searchBtn, 2, 10);
		layout.setAlignment(Pos.TOP_CENTER);
		
		backBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Bankmenu");
				stage.setScene(BankView.getScene(stage));
			};
		});
		
		return scene;
	}
	
	private static Scene getDeleteBankScene(Stage stage) {
		GridPane layout = new GridPane();
		Scene scene = new Scene(layout, 800, 600);
		
		Label headerLabel = new Label("Slet Bank");
		headerLabel.setStyle("-fx-font-weight:bold; -fx-font-size:36px"); 
		layout.setMargin(headerLabel, new Insets(0, 0, 40, 0));
		
		Label searchBank = new Label("Søg:");
		layout.setMargin(searchBank, new Insets(0, 20, 15, 0));
		TextField searchBankTF = new TextField();
		layout.setMargin(searchBankTF, new Insets(0, 0, 15, 0));
		
		Button searchBtn = new Button("Søg");
		layout.setMargin(searchBtn, new Insets(15, 10, 0, 0));
		Button backBtn = new Button("Tilbage");
		layout.setMargin(backBtn, new Insets(15, 0, 0, 0));
		
		layout.add(headerLabel, 3, 1);
		layout.add(searchBank, 2, 4);
		layout.add(searchBankTF, 3, 4);
		layout.add(backBtn, 3, 10);
		layout.add(searchBtn, 2, 10);
		layout.setAlignment(Pos.TOP_CENTER);
		
		
		
		backBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				stage.setTitle("Bankmenu");
				stage.setScene(BankView.getScene(stage));
			};
		});
		
		return scene;
	}
}
