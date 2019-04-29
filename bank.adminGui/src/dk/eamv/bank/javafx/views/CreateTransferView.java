package dk.eamv.bank.javafx.views;

import dk.eamv.bank.javafx.controllers.CreateTransferController;
import dk.eamv.bank.javafx.interfaces.ITabPane;
import dk.eamv.bank.javafx.viewModels.TransferModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class CreateTransferView
{
	private CreateTransferController controller;
	
	public StackPane getSceneGUI(CreateTransferController controller)
	{
		this.controller=controller;
		
		StackPane root = new StackPane();
		root.setId("view_screen");
		
		root.getChildren().add(getEntryGrid());
		
		return root;
	}
	
	public GridPane getEntryGrid()
	{
		GridPane entryGrid = new GridPane();
		TransferModel transfer=controller.getTransferModel();
		
		Label senderAccountLabel=new Label("Afsender Konto nr.");
		senderAccountLabel.setId("create_customer_label");
		
		Label senderAccountTextField=new Label(transfer.getFromAccount().getFullAccountRegNumber());
		
		Label recieverRegLabel=new Label("Modtager Reg. nr.");
		recieverRegLabel.setId("create_customer_label");
		
		TextField recieverRegTextField=new TextField();
		recieverRegTextField.textProperty().bindBidirectional(transfer.regNumber());
		
		Label recieverAccountLabel=new Label("Modtager Konto nr.");
		recieverAccountLabel.setId("create_customer_label");
		
		TextField recieverAccountTextField=new TextField();
		recieverAccountTextField.textProperty().bindBidirectional(transfer.toAccountAccountNumber());
		
		Label senderMessageLabel=new Label("Besked til afsender");
		senderMessageLabel.setId("create_customer_label");
		
		TextField senderMessageTextField=new TextField();
		senderMessageTextField.textProperty().bindBidirectional(transfer.fromDescription());
		
		Label recieverMessageLabel=new Label("Besked til modtager");
		recieverMessageLabel.setId("create_customer_label");
		
		TextField recieverMessageTextField=new TextField();
		recieverMessageTextField.textProperty().bindBidirectional(transfer.toDescription());
		
		Label amountLabel=new Label("Beløb");
		amountLabel.setId("create_customer_label");
		
		TextField amountTextField=new TextField();
		amountTextField.textProperty().bindBidirectional(transfer.amount());
		
		Label paymentDateLabel=new Label("Betalingsdato");
		paymentDateLabel.setId("create_customer_label");
		
		DatePicker paymentDate=new DatePicker();
		
		Button createEntryButton = new Button("Opret postering");
		createEntryButton.setId("view_button");
		createEntryButton.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	controller.createTransferPressed();
		    }
		});
		
		entryGrid.add(senderAccountLabel, 0, 0);
		entryGrid.add(senderAccountTextField, 0, 1);
		entryGrid.add(amountLabel, 1, 0);
		entryGrid.add(amountTextField, 1, 1);
		entryGrid.add(recieverAccountLabel, 1, 2);
		entryGrid.add(recieverAccountTextField, 1, 3);
		entryGrid.add(recieverRegLabel, 0, 2);
		entryGrid.add(recieverRegTextField, 0, 3);
		entryGrid.add(senderMessageLabel, 0, 4);
		entryGrid.add(senderMessageTextField, 0, 5);
		entryGrid.add(recieverMessageLabel, 1, 4);
		entryGrid.add(recieverMessageTextField, 1, 5);
		entryGrid.add(paymentDateLabel, 0, 6);
		entryGrid.add(paymentDate, 0, 7);
		entryGrid.add(createEntryButton, 0, 8);
		
		return entryGrid;
	}
}