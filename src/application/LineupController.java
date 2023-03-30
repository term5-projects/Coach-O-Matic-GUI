package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LineupController implements Initializable{
	
	@FXML Label formationLabel;
	
	
	@FXML private AnchorPane LineupScenePane;
	
	@FXML private Button logoutButton;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@Override

	public void initialize(URL arg0, ResourceBundle arg1) {


	}
	
	public void logout(ActionEvent event)

	{

		Alert alert = new Alert(AlertType.CONFIRMATION);

		alert.setTitle("Logout");

		alert.setHeaderText("You're about to logout!");

		alert.setContentText("Do you want to save before exiting?");


		if (alert.showAndWait().get() == ButtonType.OK) {

			stage = (Stage) LineupScenePane.getScene().getWindow();

			System.out.println("You successfully logged out!");

			stage.close();

		}

	}

}
