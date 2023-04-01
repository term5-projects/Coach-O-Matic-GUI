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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LineupController implements Initializable{
	
	@FXML private Label formationLabel;
	
	@FXML private AnchorPane LineupScenePane;
	
	@FXML private Button logoutButton;
	
	@FXML private TableView<SoccerPlayer> LineupTable;
	
	
	@FXML private TableColumn<Integer> shiftcolumn;
	
	@FXML private TableColumn<Player, String> GKcolumn;
	
	@FXML private TableColumn<Player, String> LDcolumn;
	
	@FXML private TableColumn<Player, String> RDcolumn;
	
	@FXML private TableColumn<Player, String> LMcoolumn;
	
	@FXML private TableColumn<Player, String> CMcolumn;
	
	@FXML private TableColumn<Player, String> RMcolumn;
	
	@FXML private TableColumn<Player, String> STcolumn;
	
	@FXML private TableColumn<Player, String> Subcolumn;
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		shiftcolumn;
		GKcolumn.setCellValueFactory(new PropertyValueFactory<Player, String>("GK"));
		LDcolumn.setCellValueFactory(new PropertyValueFactory<Player, String>("LD"));
		RDcolumn.setCellValueFactory(new PropertyValueFactory<Player, String>("RD"));
		LMcolumn.setCellValueFactory(new PropertyValueFactory<Player, String>("LM"));
		CMcolumn.setCellValueFactory(new PropertyValueFactory<Player, String>("CM"));
		RMcolumn.setCellValueFactory(new PropertyValueFactory<Player, String>("RM"));
		STcolumn.setCellValueFactory(new PropertyValueFactory<Player, String>("ST"));
		Subcolumn.setCellValueFactory(new PropertyValueFactory<Player, String>("SUB"));
		
		
		
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
