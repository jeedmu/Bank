package dk.eamv.bank.javafx.views;

import dk.eamv.bank.javafx.controllers.CreateCustomerController;
import dk.eamv.bank.javafx.controllers.CreateRoleController;
import dk.eamv.bank.javafx.domain.Role;
import dk.eamv.bank.javafx.viewModels.CustomerModel;
import dk.eamv.bank.javafx.viewModels.RoleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class CreateRoleView {
	private CreateRoleController controller;
	private RoleProperty currentRole;
	
	public StackPane getSceneGUI(CreateRoleController controller, RoleProperty role)
	{
		this.controller=controller;
		currentRole=role;
		
		StackPane root = new StackPane();
		root.setId("view_screen");
		root.setAlignment(Pos.CENTER);
		
		VBox content = createRoleInfoGrid();
		content.setId("view_screen");
		content.setAlignment(Pos.CENTER);
		
		root.getChildren().add(content);
		
		return root;
	}
	
	private VBox createRoleInfoGrid()
	{
		VBox content = new VBox();
		
		GridPane roleInformationGrid=new GridPane();
		roleInformationGrid.setHgap(10);
		roleInformationGrid.setAlignment(Pos.CENTER);
		
		Label roleInformationHeader=new Label("Rolleinformation :");
		roleInformationHeader.setId("part_header_label");
		
		Label roleIDHeader=new Label("RolleID");
		roleIDHeader.setId("create_role_label");
		
		TextField roleIDTextField=new TextField();
		roleIDTextField.textProperty().bindBidirectional(currentRole.roleID());
		roleIDTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches(".{0,32}")) {
                	roleIDTextField.setText(oldValue);
                }
            }
        });
		
		Label roleNameHeader=new Label("RolleNavn");
		roleNameHeader.setId("create_role_label");
		
		TextField roleNameTextField=new TextField();
		roleNameTextField.textProperty().bindBidirectional(currentRole.roleName());
		roleNameTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches(".{0,32}")) {
                	roleNameTextField.setText(oldValue);
                }
            }
        });
		
		
		
		roleInformationGrid.add(roleInformationHeader, 0, 0);
		roleInformationGrid.add(roleIDHeader, 0, 1);
		roleInformationGrid.add(roleIDTextField, 0, 2);
		roleInformationGrid.add(roleNameHeader, 1, 1);
		roleInformationGrid.add(roleNameTextField, 1, 2);
		
		
		content.getChildren().add(roleInformationGrid);
		
		//**********buttons*****************
		HBox buttonHolder=new HBox();
		buttonHolder.setAlignment(Pos.CENTER);
		content.getChildren().add(buttonHolder);
		
		Button createRole = new Button("Opret Rolle");
		createRole.setId("view_button");
		
		createRole.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	controller.createRolePressed(currentRole);
		    }
		});
		
		Button cancelButton = new Button("Annuller");
		cancelButton.setId("view_button");
		cancelButton.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
		    public void handle(ActionEvent e) 
		    {
		    	controller.closeTab();
		    }
		});
		
		buttonHolder.getChildren().add(createRole);
		buttonHolder.getChildren().add(cancelButton);
		HBox.setMargin(createRole, new Insets(6, 6, 6, 0));
		HBox.setMargin(cancelButton, new Insets(6));
		
		return content;
	}
}
