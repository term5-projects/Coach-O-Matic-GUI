package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserMenuController implements Initializable{

	@FXML Label usernameLabel;
	
	@FXML private Button logoutButton;
	@FXML private Button newTeamButton;
	@FXML private ChoiceBox<String> selectTeamChoiceBox;
	private String[] teams = {"FAA Gu11", "SYJS Bu11"}; //NEEDS UPDATE
	@FXML private Button submitButton;
	
	@FXML private AnchorPane userMenuScenePane;
	
	private String selectedTeam = null;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		selectTeamChoiceBox.getItems().addAll(teams);
		
	}
	
	
	public void displayName(String username) {
		usernameLabel.setText("Hi " + username);
	}
	
	
	public void logout(ActionEvent event)
	{
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to logout!");
		alert.setContentText("Do you want to save before exiting?");
		
		if (alert.showAndWait().get() == ButtonType.OK) {
			stage = (Stage) userMenuScenePane.getScene().getWindow();
			System.out.println("You successfully logged out!");
			stage.close();
		}
	}
	public void addTeam(ActionEvent event)throws IOException
	{		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EditTeamScene.fxml"));
		root = loader.load();
		
			
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void getTeam(ActionEvent event) {
		selectedTeam = selectTeamChoiceBox.getValue();
		
//		if (selectedTeam == "FAA Gu11") {
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("TeamMenuScene.fxml"));
//			root = loader.load();
//			
//			TeamMenuController TeamMenuController = loader.getController();
//			TeamMenuController.displayName(selectedTeam);
//			
//			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//			scene = new Scene(root);
//			stage.setScene(scene);
//			stage.show();
//		}
		
	}
	public void visitTeamMenu(ActionEvent event) throws IOException {
			String teamname = selectTeamChoiceBox.getValue();
			if (teamname == null) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Select Team");
				alert.setHeaderText("Invalid Input");
				alert.setContentText("Please select one of the teams from the the drop down list.");
				
				if (alert.showAndWait().get() == ButtonType.OK) {
				}
			}
			
			else {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("TeamMenuScene.fxml"));
				root = loader.load();
				
				TeamMenuController teamMenuController = loader.getController();
				
				teamMenuController.displayTeamName(teamname);
				
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
	}



	
}
	